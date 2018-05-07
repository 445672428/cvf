package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class COLLATIONSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public COLLATIONSExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("IS_DEFAULT is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("IS_DEFAULT is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(String value) {
            addCriterion("IS_DEFAULT =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(String value) {
            addCriterion("IS_DEFAULT <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(String value) {
            addCriterion("IS_DEFAULT >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(String value) {
            addCriterion("IS_DEFAULT <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(String value) {
            addCriterion("IS_DEFAULT <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLike(String value) {
            addCriterion("IS_DEFAULT like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotLike(String value) {
            addCriterion("IS_DEFAULT not like", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<String> values) {
            addCriterion("IS_DEFAULT in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<String> values) {
            addCriterion("IS_DEFAULT not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(String value1, String value2) {
            addCriterion("IS_DEFAULT not between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsCompiledIsNull() {
            addCriterion("IS_COMPILED is null");
            return (Criteria) this;
        }

        public Criteria andIsCompiledIsNotNull() {
            addCriterion("IS_COMPILED is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompiledEqualTo(String value) {
            addCriterion("IS_COMPILED =", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledNotEqualTo(String value) {
            addCriterion("IS_COMPILED <>", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledGreaterThan(String value) {
            addCriterion("IS_COMPILED >", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledGreaterThanOrEqualTo(String value) {
            addCriterion("IS_COMPILED >=", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledLessThan(String value) {
            addCriterion("IS_COMPILED <", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledLessThanOrEqualTo(String value) {
            addCriterion("IS_COMPILED <=", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledLike(String value) {
            addCriterion("IS_COMPILED like", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledNotLike(String value) {
            addCriterion("IS_COMPILED not like", value, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledIn(List<String> values) {
            addCriterion("IS_COMPILED in", values, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledNotIn(List<String> values) {
            addCriterion("IS_COMPILED not in", values, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledBetween(String value1, String value2) {
            addCriterion("IS_COMPILED between", value1, value2, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andIsCompiledNotBetween(String value1, String value2) {
            addCriterion("IS_COMPILED not between", value1, value2, "isCompiled");
            return (Criteria) this;
        }

        public Criteria andSortlenIsNull() {
            addCriterion("SORTLEN is null");
            return (Criteria) this;
        }

        public Criteria andSortlenIsNotNull() {
            addCriterion("SORTLEN is not null");
            return (Criteria) this;
        }

        public Criteria andSortlenEqualTo(Long value) {
            addCriterion("SORTLEN =", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenNotEqualTo(Long value) {
            addCriterion("SORTLEN <>", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenGreaterThan(Long value) {
            addCriterion("SORTLEN >", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenGreaterThanOrEqualTo(Long value) {
            addCriterion("SORTLEN >=", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenLessThan(Long value) {
            addCriterion("SORTLEN <", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenLessThanOrEqualTo(Long value) {
            addCriterion("SORTLEN <=", value, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenIn(List<Long> values) {
            addCriterion("SORTLEN in", values, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenNotIn(List<Long> values) {
            addCriterion("SORTLEN not in", values, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenBetween(Long value1, Long value2) {
            addCriterion("SORTLEN between", value1, value2, "sortlen");
            return (Criteria) this;
        }

        public Criteria andSortlenNotBetween(Long value1, Long value2) {
            addCriterion("SORTLEN not between", value1, value2, "sortlen");
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