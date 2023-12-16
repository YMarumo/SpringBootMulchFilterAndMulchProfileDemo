package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.authentication.UserAuthentication;

public class ProfileXFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        String authorization = request.getHeader("Authorization");
        boolean isUserA = uri.startsWith("/a");
        boolean isUserB = uri.startsWith("/b");
        Authentication authentication = null;
        String authority = null;
        if (isUserA) {
            authority = authorization != null ? "UserA" : "Guest";
        }
        if (isUserB) {
            authority = authorization != null ? "UserB" : "Guest";
        }
        authentication = new UserAuthentication(authority);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}