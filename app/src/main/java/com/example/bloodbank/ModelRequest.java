package com.example.bloodbank;

public class ModelRequest {

    String name,bGroup,description,mobile,location;

    public ModelRequest() {
    }

    public ModelRequest(String name, String bGroup, String description, String mobile, String location) {
        this.name = name;
        this.bGroup = bGroup;
        this.description = description;
        this.mobile = mobile;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getbGroup() {
        return bGroup;
    }

    public void setbGroup(String bGroup) {
        this.bGroup = bGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
