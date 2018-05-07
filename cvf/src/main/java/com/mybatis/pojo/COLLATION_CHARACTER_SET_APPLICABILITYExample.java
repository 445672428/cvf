package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class COLLATION_CHARACTER_SET_APPLICABILITYExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public COLLATION_CHARACTER_SET_APPLICABILITYExample() {
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

        public Criteria andCollationNameIsNull() {
            addCriterion("COLLATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCollationNameIsNotNull() {
            addCriterion("COLLATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCollationNameEqualTo(String value) {
            addCriterion("COLLATION_NAME =", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotEqualTo(String value) {
            addCriterion("COLLATION_NAME <>", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameGreaterThan(String value) {
            addCriterion("COLLATION_NAME >", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameGreaterThanOrEqualTo(String value) {
            addCriterion("COLLATION_NAME >=", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLessThan(String value) {
            addCriterion("COLLATION_NAME <", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLessThanOrEqualTo(String value) {
            addCriterion("COLLATION_NAME <=", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLike(String value) {
            addCriterion("COLLATION_NAME like", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotLike(String value) {
            addCriterion("COLLATION_NAME not like", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameIn(List<String> values) {
            addCriterion("COLLATION_NAME in", values, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotIn(List<String> values) {
            addCriterion("COLLATION_NAME not in", values, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameBetween(String value1, String value2) {
            addCriterion("COLLATION_NAME between", value1, value2, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotBetween(String value1, String value2) {
            addCriterion("COLLATION_NAME not between", value1, value2, "collationName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIsNull() {
            addCriterion("CHARACTER_SET_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIsNotNull() {
            addCriterion("CHARACTER_SET_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME =", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME <>", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameGreaterThan(String value) {
            addCriterion("CHARACTER_SET_NAME >", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME >=", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLessThan(String value) {
            addCriterion("CHARACTER_SET_NAME <", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLessThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME <=", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLike(String value) {
            addCriterion("CHARACTER_SET_NAME like", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotLike(String value) {
            addCriterion("CHARACTER_SET_NAME not like", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIn(List<String> values) {
            addCriterion("CHARACTER_SET_NAME in", values, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotIn(List<String> values) {
            addCriterion("CHARACTER_SET_NAME not in", values, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_NAME between", value1, value2, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_NAME not between", value1, value2, "characterSetName");
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