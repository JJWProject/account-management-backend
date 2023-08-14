package com.access.accountmanagement.authentication.filter;

import com.access.accountmanagement.authentication.service.jwt.GenerateJwtCommand;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final GenerateJwtCommand generateJwtCommand;

    public CustomAuthenticationFilter(
            AuthenticationManager authenticationManager,
            GenerateJwtCommand generateJwtCommand
    ) {
        this.authenticationManager = authenticationManager;
        this.generateJwtCommand = generateJwtCommand;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authentication
    ) throws IOException {
        User user = (User) authentication.getPrincipal();
        response.setContentType(APPLICATION_JSON_VALUE);
        Map<String, String> jwtMap = generateJwtCommand.execute(user, request);
        Cookie cookie = new Cookie("RefreshToken", jwtMap.get("refresh_token"));
        response.addCookie(cookie);
        jwtMap.remove("refresh_token");
        new ObjectMapper().writeValue(response.getOutputStream(), jwtMap);
    }
}
