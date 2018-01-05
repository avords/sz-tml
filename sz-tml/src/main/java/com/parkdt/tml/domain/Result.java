package com.parkdt.tml.domain;

public class Result {

//    @"err":@"err",
//    @"status":@"status",
//    @"value":@"value"

    private String err;
    private String status;
    private String value;

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
