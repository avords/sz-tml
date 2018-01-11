package com.parkdt.tml.domain;

import java.io.Serializable;
import java.util.Date;

public class PersonalLoginInfo implements Serializable {
    private Long id;

    private Integer roleId;

    private String wechatId;

    private String email;

    private String phone;

    private String password;

    private String header;

    private Date loginTime;

    private Date registrationTime;

    private Long isDisable;

    private String nickName;

    private Short certificationLoginFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId == null ? null : wechatId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Long getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Long isDisable) {
        this.isDisable = isDisable;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Short getCertificationLoginFlag() {
        return certificationLoginFlag;
    }

    public void setCertificationLoginFlag(Short certificationLoginFlag) {
        this.certificationLoginFlag = certificationLoginFlag;
    }
}