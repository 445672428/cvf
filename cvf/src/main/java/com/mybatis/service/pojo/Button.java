package com.mybatis.service.pojo;

public class Button {
    private String btnId;

    private String type;

    private Integer buttonStatus;

    public String getBtnId() {
        return btnId;
    }

    public void setBtnId(String btnId) {
        this.btnId = btnId == null ? null : btnId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(Integer buttonStatus) {
        this.buttonStatus = buttonStatus;
    }
}