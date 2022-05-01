package com.example.modelAttribute;

import javax.xml.bind.annotation.XmlRootElement;

/*
    Create by Atiye Mousavi 
    Date: 5/1/2022
    Time: 10:17 AM
**/
@XmlRootElement
public class Employee {

    private long id;
    private String name;
    private String contactNumber;
    private String workingArea;

    public Employee() {
    }

    public Employee(long id, String name, String contactNumber, String workingArea) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.workingArea = workingArea;
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

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }
}
