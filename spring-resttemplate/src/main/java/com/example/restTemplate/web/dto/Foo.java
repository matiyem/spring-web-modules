package com.example.restTemplate.web.dto;

/*
    created by Atiye Mousavi
    Date: 5/3/2022
    Time: 6:33 PM
*/

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Foo")
public class Foo {
    private long id;
    private String name;

    public Foo(final String name) {
        super();
        this.name = name;
    }

    public Foo(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
