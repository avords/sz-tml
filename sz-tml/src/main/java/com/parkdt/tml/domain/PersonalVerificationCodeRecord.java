package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class PersonalVerificationCodeRecord implements Serializable {
    private Long id;

    private String phone;

    private Long memberId;

    private String code;

    private Date createTime;

    private Date failureTime;

    private Short useFlag;

    private Short type;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    public Short getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Short useFlag) {
        this.useFlag = useFlag;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}