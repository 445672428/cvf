package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class INNODB_LOCKSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public INNODB_LOCKSExample() {
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

        public Criteria andLockIdIsNull() {
            addCriterion("lock_id is null");
            return (Criteria) this;
        }

        public Criteria andLockIdIsNotNull() {
            addCriterion("lock_id is not null");
            return (Criteria) this;
        }

        public Criteria andLockIdEqualTo(String value) {
            addCriterion("lock_id =", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotEqualTo(String value) {
            addCriterion("lock_id <>", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThan(String value) {
            addCriterion("lock_id >", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdGreaterThanOrEqualTo(String value) {
            addCriterion("lock_id >=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThan(String value) {
            addCriterion("lock_id <", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLessThanOrEqualTo(String value) {
            addCriterion("lock_id <=", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdLike(String value) {
            addCriterion("lock_id like", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotLike(String value) {
            addCriterion("lock_id not like", value, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdIn(List<String> values) {
            addCriterion("lock_id in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotIn(List<String> values) {
            addCriterion("lock_id not in", values, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdBetween(String value1, String value2) {
            addCriterion("lock_id between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockIdNotBetween(String value1, String value2) {
            addCriterion("lock_id not between", value1, value2, "lockId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdIsNull() {
            addCriterion("lock_trx_id is null");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdIsNotNull() {
            addCriterion("lock_trx_id is not null");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdEqualTo(String value) {
            addCriterion("lock_trx_id =", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdNotEqualTo(String value) {
            addCriterion("lock_trx_id <>", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdGreaterThan(String value) {
            addCriterion("lock_trx_id >", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("lock_trx_id >=", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdLessThan(String value) {
            addCriterion("lock_trx_id <", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdLessThanOrEqualTo(String value) {
            addCriterion("lock_trx_id <=", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdLike(String value) {
            addCriterion("lock_trx_id like", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdNotLike(String value) {
            addCriterion("lock_trx_id not like", value, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdIn(List<String> values) {
            addCriterion("lock_trx_id in", values, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdNotIn(List<String> values) {
            addCriterion("lock_trx_id not in", values, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdBetween(String value1, String value2) {
            addCriterion("lock_trx_id between", value1, value2, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockTrxIdNotBetween(String value1, String value2) {
            addCriterion("lock_trx_id not between", value1, value2, "lockTrxId");
            return (Criteria) this;
        }

        public Criteria andLockModeIsNull() {
            addCriterion("lock_mode is null");
            return (Criteria) this;
        }

        public Criteria andLockModeIsNotNull() {
            addCriterion("lock_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLockModeEqualTo(String value) {
            addCriterion("lock_mode =", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeNotEqualTo(String value) {
            addCriterion("lock_mode <>", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeGreaterThan(String value) {
            addCriterion("lock_mode >", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeGreaterThanOrEqualTo(String value) {
            addCriterion("lock_mode >=", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeLessThan(String value) {
            addCriterion("lock_mode <", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeLessThanOrEqualTo(String value) {
            addCriterion("lock_mode <=", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeLike(String value) {
            addCriterion("lock_mode like", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeNotLike(String value) {
            addCriterion("lock_mode not like", value, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeIn(List<String> values) {
            addCriterion("lock_mode in", values, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeNotIn(List<String> values) {
            addCriterion("lock_mode not in", values, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeBetween(String value1, String value2) {
            addCriterion("lock_mode between", value1, value2, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockModeNotBetween(String value1, String value2) {
            addCriterion("lock_mode not between", value1, value2, "lockMode");
            return (Criteria) this;
        }

        public Criteria andLockTypeIsNull() {
            addCriterion("lock_type is null");
            return (Criteria) this;
        }

        public Criteria andLockTypeIsNotNull() {
            addCriterion("lock_type is not null");
            return (Criteria) this;
        }

        public Criteria andLockTypeEqualTo(String value) {
            addCriterion("lock_type =", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotEqualTo(String value) {
            addCriterion("lock_type <>", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThan(String value) {
            addCriterion("lock_type >", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lock_type >=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThan(String value) {
            addCriterion("lock_type <", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLessThanOrEqualTo(String value) {
            addCriterion("lock_type <=", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeLike(String value) {
            addCriterion("lock_type like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotLike(String value) {
            addCriterion("lock_type not like", value, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeIn(List<String> values) {
            addCriterion("lock_type in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotIn(List<String> values) {
            addCriterion("lock_type not in", values, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeBetween(String value1, String value2) {
            addCriterion("lock_type between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTypeNotBetween(String value1, String value2) {
            addCriterion("lock_type not between", value1, value2, "lockType");
            return (Criteria) this;
        }

        public Criteria andLockTableIsNull() {
            addCriterion("lock_table is null");
            return (Criteria) this;
        }

        public Criteria andLockTableIsNotNull() {
            addCriterion("lock_table is not null");
            return (Criteria) this;
        }

        public Criteria andLockTableEqualTo(String value) {
            addCriterion("lock_table =", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotEqualTo(String value) {
            addCriterion("lock_table <>", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableGreaterThan(String value) {
            addCriterion("lock_table >", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableGreaterThanOrEqualTo(String value) {
            addCriterion("lock_table >=", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLessThan(String value) {
            addCriterion("lock_table <", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLessThanOrEqualTo(String value) {
            addCriterion("lock_table <=", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableLike(String value) {
            addCriterion("lock_table like", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotLike(String value) {
            addCriterion("lock_table not like", value, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableIn(List<String> values) {
            addCriterion("lock_table in", values, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotIn(List<String> values) {
            addCriterion("lock_table not in", values, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableBetween(String value1, String value2) {
            addCriterion("lock_table between", value1, value2, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockTableNotBetween(String value1, String value2) {
            addCriterion("lock_table not between", value1, value2, "lockTable");
            return (Criteria) this;
        }

        public Criteria andLockIndexIsNull() {
            addCriterion("lock_index is null");
            return (Criteria) this;
        }

        public Criteria andLockIndexIsNotNull() {
            addCriterion("lock_index is not null");
            return (Criteria) this;
        }

        public Criteria andLockIndexEqualTo(String value) {
            addCriterion("lock_index =", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexNotEqualTo(String value) {
            addCriterion("lock_index <>", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexGreaterThan(String value) {
            addCriterion("lock_index >", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexGreaterThanOrEqualTo(String value) {
            addCriterion("lock_index >=", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexLessThan(String value) {
            addCriterion("lock_index <", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexLessThanOrEqualTo(String value) {
            addCriterion("lock_index <=", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexLike(String value) {
            addCriterion("lock_index like", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexNotLike(String value) {
            addCriterion("lock_index not like", value, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexIn(List<String> values) {
            addCriterion("lock_index in", values, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexNotIn(List<String> values) {
            addCriterion("lock_index not in", values, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexBetween(String value1, String value2) {
            addCriterion("lock_index between", value1, value2, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockIndexNotBetween(String value1, String value2) {
            addCriterion("lock_index not between", value1, value2, "lockIndex");
            return (Criteria) this;
        }

        public Criteria andLockSpaceIsNull() {
            addCriterion("lock_space is null");
            return (Criteria) this;
        }

        public Criteria andLockSpaceIsNotNull() {
            addCriterion("lock_space is not null");
            return (Criteria) this;
        }

        public Criteria andLockSpaceEqualTo(Long value) {
            addCriterion("lock_space =", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceNotEqualTo(Long value) {
            addCriterion("lock_space <>", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceGreaterThan(Long value) {
            addCriterion("lock_space >", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceGreaterThanOrEqualTo(Long value) {
            addCriterion("lock_space >=", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceLessThan(Long value) {
            addCriterion("lock_space <", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceLessThanOrEqualTo(Long value) {
            addCriterion("lock_space <=", value, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceIn(List<Long> values) {
            addCriterion("lock_space in", values, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceNotIn(List<Long> values) {
            addCriterion("lock_space not in", values, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceBetween(Long value1, Long value2) {
            addCriterion("lock_space between", value1, value2, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockSpaceNotBetween(Long value1, Long value2) {
            addCriterion("lock_space not between", value1, value2, "lockSpace");
            return (Criteria) this;
        }

        public Criteria andLockPageIsNull() {
            addCriterion("lock_page is null");
            return (Criteria) this;
        }

        public Criteria andLockPageIsNotNull() {
            addCriterion("lock_page is not null");
            return (Criteria) this;
        }

        public Criteria andLockPageEqualTo(Long value) {
            addCriterion("lock_page =", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageNotEqualTo(Long value) {
            addCriterion("lock_page <>", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageGreaterThan(Long value) {
            addCriterion("lock_page >", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageGreaterThanOrEqualTo(Long value) {
            addCriterion("lock_page >=", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageLessThan(Long value) {
            addCriterion("lock_page <", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageLessThanOrEqualTo(Long value) {
            addCriterion("lock_page <=", value, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageIn(List<Long> values) {
            addCriterion("lock_page in", values, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageNotIn(List<Long> values) {
            addCriterion("lock_page not in", values, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageBetween(Long value1, Long value2) {
            addCriterion("lock_page between", value1, value2, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockPageNotBetween(Long value1, Long value2) {
            addCriterion("lock_page not between", value1, value2, "lockPage");
            return (Criteria) this;
        }

        public Criteria andLockRecIsNull() {
            addCriterion("lock_rec is null");
            return (Criteria) this;
        }

        public Criteria andLockRecIsNotNull() {
            addCriterion("lock_rec is not null");
            return (Criteria) this;
        }

        public Criteria andLockRecEqualTo(Long value) {
            addCriterion("lock_rec =", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecNotEqualTo(Long value) {
            addCriterion("lock_rec <>", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecGreaterThan(Long value) {
            addCriterion("lock_rec >", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecGreaterThanOrEqualTo(Long value) {
            addCriterion("lock_rec >=", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecLessThan(Long value) {
            addCriterion("lock_rec <", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecLessThanOrEqualTo(Long value) {
            addCriterion("lock_rec <=", value, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecIn(List<Long> values) {
            addCriterion("lock_rec in", values, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecNotIn(List<Long> values) {
            addCriterion("lock_rec not in", values, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecBetween(Long value1, Long value2) {
            addCriterion("lock_rec between", value1, value2, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockRecNotBetween(Long value1, Long value2) {
            addCriterion("lock_rec not between", value1, value2, "lockRec");
            return (Criteria) this;
        }

        public Criteria andLockDataIsNull() {
            addCriterion("lock_data is null");
            return (Criteria) this;
        }

        public Criteria andLockDataIsNotNull() {
            addCriterion("lock_data is not null");
            return (Criteria) this;
        }

        public Criteria andLockDataEqualTo(String value) {
            addCriterion("lock_data =", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataNotEqualTo(String value) {
            addCriterion("lock_data <>", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataGreaterThan(String value) {
            addCriterion("lock_data >", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataGreaterThanOrEqualTo(String value) {
            addCriterion("lock_data >=", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataLessThan(String value) {
            addCriterion("lock_data <", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataLessThanOrEqualTo(String value) {
            addCriterion("lock_data <=", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataLike(String value) {
            addCriterion("lock_data like", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataNotLike(String value) {
            addCriterion("lock_data not like", value, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataIn(List<String> values) {
            addCriterion("lock_data in", values, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataNotIn(List<String> values) {
            addCriterion("lock_data not in", values, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataBetween(String value1, String value2) {
            addCriterion("lock_data between", value1, value2, "lockData");
            return (Criteria) this;
        }

        public Criteria andLockDataNotBetween(String value1, String value2) {
            addCriterion("lock_data not between", value1, value2, "lockData");
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