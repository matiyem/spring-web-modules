package com.example.responseHeaders.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 10:57 AM
**/
@WebFilter("/filter-response-header/*")
public class AddResponseHeaderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddResponseHeaderFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.trace("Initializing filter...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Baeldung-Example-Filter-Header", "Value-Filter");
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.trace("Destroying filter...");
    }
}
