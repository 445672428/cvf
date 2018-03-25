package com.mybatis.pojo;

public class User {
    private String uName;

    private String mnId;

    private String password;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName == null ? null : uName.trim();
    }

    public String getMnId() {
        return mnId;
    }

    public void setMnId(String mnId) {
        this.mnId = mnId == null ? null : mnId.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}