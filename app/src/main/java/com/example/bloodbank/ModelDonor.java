package com.example.bloodbank;

public class ModelDonor {
    String name,mobile,address,bGroup;

    public ModelDonor() {
    }

    public ModelDonor(String name, String mobile, String address, String bGroup) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.bGroup = bGroup;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getbGroup() {
        return bGroup;
    }

    public void setbGroup(String bGroup) {
        this.bGroup = bGroup;
    }
}
