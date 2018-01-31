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

    public Result setErr(String err) {
        this.err = err;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Result setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Result setValue(String value) {
        this.value = value;
        return this;
    }
}
