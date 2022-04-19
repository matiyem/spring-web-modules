package com.example.chachedRequest;

import org.springframework.util.StreamUtils;
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
import java.io.InputStream;

/*
    Create by Atiye Mousavi 
    Date: 4/17/2022
    Time: 11:53 AM
**/
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
@WebFilter(filterName = "printRequestContentFilter", urlPatterns = "/*")
public class PrintRequestContentFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("IN  PrintRequestContentFilter ");
        InputStream inputStream=request.getInputStream();
        byte[] body= StreamUtils.copyToByteArray(inputStream);
        System.out.println("In PrintRequestContentFilter. Request body is: " + new String(body));
        filterChain.doFilter(request,response);
    }
}
