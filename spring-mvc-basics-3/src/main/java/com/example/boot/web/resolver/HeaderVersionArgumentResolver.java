package com.example.boot.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/*
    Create by Atiye Mousavi 
    Date: 4/13/2022
    Time: 2:46 PM
**/
@Component
public class HeaderVersionArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.getParameterAnnotation(Version.class) != null;
    }

    @Override
    public Object resolveArgument(final MethodParameter parameter,final ModelAndViewContainer mavContainer, NativeWebRequest nativeRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request= (HttpServletRequest) nativeRequest.getNativeRequest();
        return request.getHeader("version");
    }
}
