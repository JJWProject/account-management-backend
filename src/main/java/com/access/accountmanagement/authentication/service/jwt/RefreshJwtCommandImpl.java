package com.access.accountmanagement.authentication.service.jwt;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.domain.Role;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@PropertySource(value = {"classpath:application.yml"})
public class RefreshJwtCommandImpl implements RefreshJwtCommand{

    @Value("${jwt.key}")
    private String key;

    @Override
    public Map<String, String> execute(AppUser variable1, HttpServletRequest variable2, String variable3) {
        Algorithm algorithm = Algorithm.HMAC256(key.getBytes());
        String access_token = JWT.create()
                .withSubject(variable1.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10*60*1000))
                .withIssuer(variable2.getRequestURL().toString())
                .withClaim("roles",variable1.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .sign(algorithm);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token",access_token);
        tokens.put("refresh_token",variable3);

        return tokens;
    }
}
