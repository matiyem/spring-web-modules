package com.example.service.impl;

import com.example.service.CustomerIdGenerator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/*
    Create by Atiye Mousavi 
    Date: 5/22/2022
    Time: 11:10 AM
**/
@Component
public class CustomerIdGeneratorImpl implements CustomerIdGenerator {
    private static final AtomicInteger SEQUENCE = new AtomicInteger();

    @Override
    public int generateNextId() {
        return SEQUENCE.incrementAndGet();
    }
}
