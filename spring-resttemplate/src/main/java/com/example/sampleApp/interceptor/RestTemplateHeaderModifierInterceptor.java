package com.example.sampleApp.interceptor;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 1:27 PM
*/


import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response=execution.execute(request, body);
        response.getHeaders().add("Foo","bar");
        return response;
    }
}
