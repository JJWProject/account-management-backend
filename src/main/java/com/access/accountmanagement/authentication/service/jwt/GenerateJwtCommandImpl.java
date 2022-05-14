package com.access.accountmanagement.authentication.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@PropertySource(value = {"classpath:application.yml"})
public class GenerateJwtCommandImpl implements GenerateJwtCommand{

    @Value("${jwt.key}")
    private String key;

    @Override
    public Map<String, String> execute(User variable1, HttpServletRequest variable2) {
        Algorithm algorithm = Algorithm.HMAC256(key.getBytes());
        String access_token = JWT.create()
                .withSubject(variable1.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10*60*1000))
                .withIssuer(variable2.getRequestURL().toString())
                .withClaim("roles",variable1.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refresh_token = JWT.create()
                .withSubject(variable1.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 30*60*1000))
                .withIssuer(variable2.getRequestURL().toString())
                .withClaim("roles",variable1.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token",access_token);
        tokens.put("refresh_token",refresh_token);

        return tokens;
    }
}
