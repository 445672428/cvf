package com.mybatis.pojo;

public class ROUTINESWithBLOBs extends ROUTINES {
    private String dtdIdentifier;

    private String routineDefinition;

    private String routineComment;

    public String getDtdIdentifier() {
        return dtdIdentifier;
    }

    public void setDtdIdentifier(String dtdIdentifier) {
        this.dtdIdentifier = dtdIdentifier == null ? null : dtdIdentifier.trim();
    }

    public String getRoutineDefinition() {
        return routineDefinition;
    }

    public void setRoutineDefinition(String routineDefinition) {
        this.routineDefinition = routineDefinition == null ? null : routineDefinition.trim();
    }

    public String getRoutineComment() {
        return routineComment;
    }

    public void setRoutineComment(String routineComment) {
        this.routineComment = routineComment == null ? null : routineComment.trim();
    }
}