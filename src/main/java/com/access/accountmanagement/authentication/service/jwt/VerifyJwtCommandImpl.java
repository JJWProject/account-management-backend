package com.access.accountmanagement.authentication.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VerifyJwtCommandImpl implements VerifyJwtCommand{

    @Value("${jwt.key}")
    private String key;

    @Override
    public DecodedJWT execute(String variable) {
        String token = variable.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256(key.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }
}
