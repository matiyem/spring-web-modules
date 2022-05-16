package com.example.compress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 2:17 PM
**/
@RestController
public class MessageController {

    protected static final String PROCESSED = "Processed ";

    protected static final String REQUEST_MAPPING = "process";

    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    @PostMapping(value = REQUEST_MAPPING)
    public ResponseEntity<String> processMessage(@RequestHeader Map<String, String> headers, @RequestBody Message message) {
        headers.forEach((k, v) -> LOG.info(k + "=" + v));
       return ResponseEntity.ok(PROCESSED+message.getText());
    }
}
