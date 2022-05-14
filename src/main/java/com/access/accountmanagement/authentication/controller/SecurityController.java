package com.access.accountmanagement.authentication.controller;

import com.access.accountmanagement.account.domain.AppUser;
import com.access.accountmanagement.account.service.basecommands.AppUser.GetAppUserByUserNameCommand;
import com.access.accountmanagement.authentication.service.jwt.RefreshJwtCommand;
import com.access.accountmanagement.authentication.service.jwt.VerifyJwtCommand;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/security")
@Slf4j
public class SecurityController {

    @Autowired
    private VerifyJwtCommand verifyJwtCommand;

    @Autowired
    private GetAppUserByUserNameCommand getAppUserByUserNameCommand;

    @Autowired
    private RefreshJwtCommand refreshJwtCommand;

    @GetMapping("/refresh")
    private void refreshJwtToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                DecodedJWT decodedJWT = verifyJwtCommand.execute(authorizationHeader);
                AppUser user = getAppUserByUserNameCommand.execute(decodedJWT.getSubject());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(
                        response.getOutputStream(),
                        refreshJwtCommand.execute(user, request, authorizationHeader.substring("Bearer ".length()))
                );
            } catch (Exception exception) {
                log.error("Error loggin in:{}", exception.getMessage());
                response.setHeader("error",exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message",exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),error);
            }
        } else {
            throw new RuntimeException("Refresh Token is Missing");
        }
    }
}
