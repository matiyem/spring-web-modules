package com.example.compress;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 1:09 PM
**/
@Configuration
public class JettyWebServerConfiguration {

    private static final int MIN_BYTES=1;

    @Bean
    public JettyServletWebServerFactory jettyServletWebServerFactory(){
        JettyServletWebServerFactory factory=new JettyServletWebServerFactory();

        factory.addServerCustomizers(server -> {
            GzipHandler gzipHandler=new GzipHandler();
            gzipHandler.setInflateBufferSize(MIN_BYTES);
            gzipHandler.setHandler(server.getHandler());

            HandlerCollection handlerCollection=new HandlerCollection(gzipHandler);
            server.setHandler(handlerCollection);
        });
        return factory;
    }
}
