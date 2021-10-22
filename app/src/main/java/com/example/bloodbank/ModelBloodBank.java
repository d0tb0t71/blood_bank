package com.example.bloodbank;

public class ModelBloodBank {
    String bb_name,bb_description,bb_mobile,bb_location,bb_addedBy;


    public ModelBloodBank() {
    }

    public ModelBloodBank(String bb_name, String bb_description, String bb_mobile, String bb_location, String bb_addedBy) {
        this.bb_name = bb_name;
        this.bb_description = bb_description;
        this.bb_mobile = bb_mobile;
        this.bb_location = bb_location;
        this.bb_addedBy = bb_addedBy;
    }


    public String getBb_name() {
        return bb_name;
    }

    public void setBb_name(String bb_name) {
        this.bb_name = bb_name;
    }

    public String getBb_description() {
        return bb_description;
    }

    public void setBb_description(String bb_description) {
        this.bb_description = bb_description;
    }

    public String getBb_mobile() {
        return bb_mobile;
    }

    public void setBb_mobile(String bb_mobile) {
        this.bb_mobile = bb_mobile;
    }

    public String getBb_location() {
        return bb_location;
    }

    public void setBb_location(String bb_location) {
        this.bb_location = bb_location;
    }

    public String getBb_addedBy() {
        return bb_addedBy;
    }

    public void setBb_addedBy(String bb_addedBy) {
        this.bb_addedBy = bb_addedBy;
    }
}
