package com.huyy.springcloud.bean;


public class Payment {

    private long id;
    private String serial;

    public Payment(long id, String serial) {
        this.id = id;
        this.serial = serial;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}
