package com.mybatis.service.pojo;

public class User_roleKey {
    private String bUserIndex;

    private String bRoleIndex;

    public String getbUserIndex() {
        return bUserIndex;
    }

    public void setbUserIndex(String bUserIndex) {
        this.bUserIndex = bUserIndex == null ? null : bUserIndex.trim();
    }

    public String getbRoleIndex() {
        return bRoleIndex;
    }

    public void setbRoleIndex(String bRoleIndex) {
        this.bRoleIndex = bRoleIndex == null ? null : bRoleIndex.trim();
    }
}