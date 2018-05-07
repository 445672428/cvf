package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class TABLESPACESExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TABLESPACESExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTablespaceNameIsNull() {
            addCriterion("TABLESPACE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameIsNotNull() {
            addCriterion("TABLESPACE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameEqualTo(String value) {
            addCriterion("TABLESPACE_NAME =", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameNotEqualTo(String value) {
            addCriterion("TABLESPACE_NAME <>", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameGreaterThan(String value) {
            addCriterion("TABLESPACE_NAME >", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_NAME >=", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameLessThan(String value) {
            addCriterion("TABLESPACE_NAME <", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameLessThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_NAME <=", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameLike(String value) {
            addCriterion("TABLESPACE_NAME like", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameNotLike(String value) {
            addCriterion("TABLESPACE_NAME not like", value, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameIn(List<String> values) {
            addCriterion("TABLESPACE_NAME in", values, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameNotIn(List<String> values) {
            addCriterion("TABLESPACE_NAME not in", values, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameBetween(String value1, String value2) {
            addCriterion("TABLESPACE_NAME between", value1, value2, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andTablespaceNameNotBetween(String value1, String value2) {
            addCriterion("TABLESPACE_NAME not between", value1, value2, "tablespaceName");
            return (Criteria) this;
        }

        public Criteria andEngineIsNull() {
            addCriterion("ENGINE is null");
            return (Criteria) this;
        }

        public Criteria andEngineIsNotNull() {
            addCriterion("ENGINE is not null");
            return (Criteria) this;
        }

        public Criteria andEngineEqualTo(String value) {
            addCriterion("ENGINE =", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotEqualTo(String value) {
            addCriterion("ENGINE <>", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThan(String value) {
            addCriterion("ENGINE >", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE >=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThan(String value) {
            addCriterion("ENGINE <", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLessThanOrEqualTo(String value) {
            addCriterion("ENGINE <=", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineLike(String value) {
            addCriterion("ENGINE like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotLike(String value) {
            addCriterion("ENGINE not like", value, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineIn(List<String> values) {
            addCriterion("ENGINE in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotIn(List<String> values) {
            addCriterion("ENGINE not in", values, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineBetween(String value1, String value2) {
            addCriterion("ENGINE between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andEngineNotBetween(String value1, String value2) {
            addCriterion("ENGINE not between", value1, value2, "engine");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeIsNull() {
            addCriterion("TABLESPACE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeIsNotNull() {
            addCriterion("TABLESPACE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeEqualTo(String value) {
            addCriterion("TABLESPACE_TYPE =", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeNotEqualTo(String value) {
            addCriterion("TABLESPACE_TYPE <>", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeGreaterThan(String value) {
            addCriterion("TABLESPACE_TYPE >", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_TYPE >=", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeLessThan(String value) {
            addCriterion("TABLESPACE_TYPE <", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeLessThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_TYPE <=", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeLike(String value) {
            addCriterion("TABLESPACE_TYPE like", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeNotLike(String value) {
            addCriterion("TABLESPACE_TYPE not like", value, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeIn(List<String> values) {
            addCriterion("TABLESPACE_TYPE in", values, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeNotIn(List<String> values) {
            addCriterion("TABLESPACE_TYPE not in", values, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeBetween(String value1, String value2) {
            addCriterion("TABLESPACE_TYPE between", value1, value2, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andTablespaceTypeNotBetween(String value1, String value2) {
            addCriterion("TABLESPACE_TYPE not between", value1, value2, "tablespaceType");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameIsNull() {
            addCriterion("LOGFILE_GROUP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameIsNotNull() {
            addCriterion("LOGFILE_GROUP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameEqualTo(String value) {
            addCriterion("LOGFILE_GROUP_NAME =", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameNotEqualTo(String value) {
            addCriterion("LOGFILE_GROUP_NAME <>", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameGreaterThan(String value) {
            addCriterion("LOGFILE_GROUP_NAME >", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGFILE_GROUP_NAME >=", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameLessThan(String value) {
            addCriterion("LOGFILE_GROUP_NAME <", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameLessThanOrEqualTo(String value) {
            addCriterion("LOGFILE_GROUP_NAME <=", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameLike(String value) {
            addCriterion("LOGFILE_GROUP_NAME like", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameNotLike(String value) {
            addCriterion("LOGFILE_GROUP_NAME not like", value, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameIn(List<String> values) {
            addCriterion("LOGFILE_GROUP_NAME in", values, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameNotIn(List<String> values) {
            addCriterion("LOGFILE_GROUP_NAME not in", values, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameBetween(String value1, String value2) {
            addCriterion("LOGFILE_GROUP_NAME between", value1, value2, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNameNotBetween(String value1, String value2) {
            addCriterion("LOGFILE_GROUP_NAME not between", value1, value2, "logfileGroupName");
            return (Criteria) this;
        }

        public Criteria andExtentSizeIsNull() {
            addCriterion("EXTENT_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andExtentSizeIsNotNull() {
            addCriterion("EXTENT_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andExtentSizeEqualTo(Long value) {
            addCriterion("EXTENT_SIZE =", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeNotEqualTo(Long value) {
            addCriterion("EXTENT_SIZE <>", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeGreaterThan(Long value) {
            addCriterion("EXTENT_SIZE >", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("EXTENT_SIZE >=", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeLessThan(Long value) {
            addCriterion("EXTENT_SIZE <", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeLessThanOrEqualTo(Long value) {
            addCriterion("EXTENT_SIZE <=", value, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeIn(List<Long> values) {
            addCriterion("EXTENT_SIZE in", values, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeNotIn(List<Long> values) {
            addCriterion("EXTENT_SIZE not in", values, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeBetween(Long value1, Long value2) {
            addCriterion("EXTENT_SIZE between", value1, value2, "extentSize");
            return (Criteria) this;
        }

        public Criteria andExtentSizeNotBetween(Long value1, Long value2) {
            addCriterion("EXTENT_SIZE not between", value1, value2, "extentSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeIsNull() {
            addCriterion("AUTOEXTEND_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeIsNotNull() {
            addCriterion("AUTOEXTEND_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeEqualTo(Long value) {
            addCriterion("AUTOEXTEND_SIZE =", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeNotEqualTo(Long value) {
            addCriterion("AUTOEXTEND_SIZE <>", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeGreaterThan(Long value) {
            addCriterion("AUTOEXTEND_SIZE >", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("AUTOEXTEND_SIZE >=", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeLessThan(Long value) {
            addCriterion("AUTOEXTEND_SIZE <", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeLessThanOrEqualTo(Long value) {
            addCriterion("AUTOEXTEND_SIZE <=", value, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeIn(List<Long> values) {
            addCriterion("AUTOEXTEND_SIZE in", values, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeNotIn(List<Long> values) {
            addCriterion("AUTOEXTEND_SIZE not in", values, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeBetween(Long value1, Long value2) {
            addCriterion("AUTOEXTEND_SIZE between", value1, value2, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andAutoextendSizeNotBetween(Long value1, Long value2) {
            addCriterion("AUTOEXTEND_SIZE not between", value1, value2, "autoextendSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeIsNull() {
            addCriterion("MAXIMUM_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeIsNotNull() {
            addCriterion("MAXIMUM_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeEqualTo(Long value) {
            addCriterion("MAXIMUM_SIZE =", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeNotEqualTo(Long value) {
            addCriterion("MAXIMUM_SIZE <>", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeGreaterThan(Long value) {
            addCriterion("MAXIMUM_SIZE >", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("MAXIMUM_SIZE >=", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeLessThan(Long value) {
            addCriterion("MAXIMUM_SIZE <", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeLessThanOrEqualTo(Long value) {
            addCriterion("MAXIMUM_SIZE <=", value, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeIn(List<Long> values) {
            addCriterion("MAXIMUM_SIZE in", values, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeNotIn(List<Long> values) {
            addCriterion("MAXIMUM_SIZE not in", values, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeBetween(Long value1, Long value2) {
            addCriterion("MAXIMUM_SIZE between", value1, value2, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andMaximumSizeNotBetween(Long value1, Long value2) {
            addCriterion("MAXIMUM_SIZE not between", value1, value2, "maximumSize");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdIsNull() {
            addCriterion("NODEGROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdIsNotNull() {
            addCriterion("NODEGROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdEqualTo(Long value) {
            addCriterion("NODEGROUP_ID =", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdNotEqualTo(Long value) {
            addCriterion("NODEGROUP_ID <>", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdGreaterThan(Long value) {
            addCriterion("NODEGROUP_ID >", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("NODEGROUP_ID >=", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdLessThan(Long value) {
            addCriterion("NODEGROUP_ID <", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdLessThanOrEqualTo(Long value) {
            addCriterion("NODEGROUP_ID <=", value, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdIn(List<Long> values) {
            addCriterion("NODEGROUP_ID in", values, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdNotIn(List<Long> values) {
            addCriterion("NODEGROUP_ID not in", values, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdBetween(Long value1, Long value2) {
            addCriterion("NODEGROUP_ID between", value1, value2, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andNodegroupIdNotBetween(Long value1, Long value2) {
            addCriterion("NODEGROUP_ID not between", value1, value2, "nodegroupId");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentIsNull() {
            addCriterion("TABLESPACE_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentIsNotNull() {
            addCriterion("TABLESPACE_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentEqualTo(String value) {
            addCriterion("TABLESPACE_COMMENT =", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentNotEqualTo(String value) {
            addCriterion("TABLESPACE_COMMENT <>", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentGreaterThan(String value) {
            addCriterion("TABLESPACE_COMMENT >", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentGreaterThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_COMMENT >=", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentLessThan(String value) {
            addCriterion("TABLESPACE_COMMENT <", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentLessThanOrEqualTo(String value) {
            addCriterion("TABLESPACE_COMMENT <=", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentLike(String value) {
            addCriterion("TABLESPACE_COMMENT like", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentNotLike(String value) {
            addCriterion("TABLESPACE_COMMENT not like", value, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentIn(List<String> values) {
            addCriterion("TABLESPACE_COMMENT in", values, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentNotIn(List<String> values) {
            addCriterion("TABLESPACE_COMMENT not in", values, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentBetween(String value1, String value2) {
            addCriterion("TABLESPACE_COMMENT between", value1, value2, "tablespaceComment");
            return (Criteria) this;
        }

        public Criteria andTablespaceCommentNotBetween(String value1, String value2) {
            addCriterion("TABLESPACE_COMMENT not between", value1, value2, "tablespaceComment");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}