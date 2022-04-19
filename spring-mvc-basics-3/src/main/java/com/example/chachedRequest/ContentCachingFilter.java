package com.example.chachedRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:41 AM
**/
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@Component
@WebFilter(filterName = "ContentCachingFilter", urlPatterns = "/*")
public class ContentCachingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("IN ContentCachingFilter ");
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest=new CachedBodyHttpServletRequest(request);
        filterChain.doFilter(cachedBodyHttpServletRequest,response);
    }
}
