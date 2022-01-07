package com.example.longpolling.client;

import io.netty.handler.timeout.ReadTimeoutException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

/**
 * created by Atiye Mousavi
 * Date: 9/20/2021
 * Time: 5:21 PM
 */
@Component
public class LongPollingBakeryClient {

    public String callBakeWithRestTemplate(RestTemplateBuilder restTemplateBuilder){
        //در اینجا داریم سرویسی مینویسیم که از یک long polling استفاده کند
        //هم از طریق restTemplate امکان پذیر است هم از طریق web client
        RestTemplate restTemplate=restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(10))
                .setReadTimeout(Duration.ofSeconds(10))
                .build();
        try {
            return restTemplate.getForObject("/api/bake/cookie?bakeTime=1000", String.class);
        } catch (ResourceAccessException e) {
            //در اینجا میتوانیم ارور را هندل کنیم.این ارور از long polling بر میگردد
            throw e;
        }
    }
    public String callBakeWithWebClient(){
        WebClient webClient=WebClient.create();

        try {
            return webClient.get()
                    .uri("/api/bake/cookie?bakeTime=1000")
                    .retrieve()
                    .bodyToFlux(String.class)
                    .timeout(Duration.ofSeconds(10))
                    .blockFirst();
        } catch (ReadTimeoutException e) {
            //در اینجا میتوانیم ارور را هندل کنیم.این ارور از long polling بر میگردد

            throw e;
        }
    }
}
