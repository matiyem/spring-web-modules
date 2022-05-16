package com.example.compress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/*
    Create by Atiye Mousavi 
    Date: 5/14/2022
    Time: 3:36 PM
**/
public class CompressingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(CompressingClientHttpRequestInterceptor.class);

    private static final String GZIP_ENCODING = "gzip";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        LOG.info("Compressing request...");
        HttpHeaders httpHeaders=request.getHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_ENCODING, GZIP_ENCODING);
        httpHeaders.add(HttpHeaders.ACCEPT_ENCODING, GZIP_ENCODING);
        return execution.execute(request,GzipUtils.compress(body));

    }
}
