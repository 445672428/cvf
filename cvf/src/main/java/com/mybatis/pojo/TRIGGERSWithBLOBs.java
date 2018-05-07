package com.mybatis.pojo;

public class TRIGGERSWithBLOBs extends TRIGGERS {
    private String actionCondition;

    private String actionStatement;

    public String getActionCondition() {
        return actionCondition;
    }

    public void setActionCondition(String actionCondition) {
        this.actionCondition = actionCondition == null ? null : actionCondition.trim();
    }

    public String getActionStatement() {
        return actionStatement;
    }

    public void setActionStatement(String actionStatement) {
        this.actionStatement = actionStatement == null ? null : actionStatement.trim();
    }
}