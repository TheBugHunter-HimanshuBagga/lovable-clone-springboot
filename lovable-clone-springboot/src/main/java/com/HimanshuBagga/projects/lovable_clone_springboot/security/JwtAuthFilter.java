package com.HimanshuBagga.projects.lovable_clone_springboot.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final AuthUtil authUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("incoming request: {}", request.getRequestURI());

        final String requestHeaderToken = request.getHeader("Authorization");

        // Bearer "token"
        if(requestHeaderToken == null || !requestHeaderToken.startsWith("Bearer")){ // something wrong is happening
            filterChain.doFilter(request,response); // move to next requet
            return;
        }

        // token = "Bearer ", "aswnjfejhurhg.gnfbhwbfeufurhugngfbhgbohbe.nvhgfgruegu"

        String jwtToken = requestHeaderToken.split("Bearer ")[1]; // i will get the seconf part


        // check the validity of the token
        JwtUserPrinciple user = authUtil.verifyAccessToken(jwtToken);

        // if user is found inflate the security context holder with that

        if(user != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null , user.authorities()
            );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request,response);

    }
}
/*
Used when:
        Since the request http://localhost:8080/api/projects/8467 is authenticated and throwing 403 unauthorized
        to access this i need to pass the JWT auth token of a logged-in user, to get the result hence
        in this filter here will be the code of adding the Bearer Token inside my authenticated api


        - check each request
        - find the header(authorization Header)
        - get the token
        - check the validity of the token
        - fetch user info
        - if verified : inflate SecurityContextHolder
 */
