package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

/*
    Create by Atiye Mousavi 
    Date: 5/21/2022
    Time: 2:57 PM
**/
@RestController
public class DeferredResultController {
    private final static Logger LOG = LoggerFactory.getLogger(DeferredResultController.class);

    @GetMapping("/async-deferredresult")
    public DeferredResult<ResponseEntity<?>> handleReqDefResult(Model model) {
        LOG.info("Received async-deferredresult request");
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            LOG.info("Processing in separate thread");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.setResult(ResponseEntity.ok("ok"));
        });
        LOG.info("servlet thread freed");
        return output;
    }

    public DeferredResult<ResponseEntity<?>> handleAsyncFailedRequest(Model model) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            try {
                // Exception occurred in processing
                throw new Exception();
            } catch (Exception e) {
                LOG.info("Request processing failed");
                deferredResult.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("INTERNAL_SERVER_ERROR occurred."));
            }
        });
        return deferredResult;
    }

}
