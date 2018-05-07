package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class INNODB_LOCK_WAITSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public INNODB_LOCK_WAITSExample() {
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

        public Criteria andRequestingTrxIdIsNull() {
            addCriterion("requesting_trx_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdIsNotNull() {
            addCriterion("requesting_trx_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdEqualTo(String value) {
            addCriterion("requesting_trx_id =", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdNotEqualTo(String value) {
            addCriterion("requesting_trx_id <>", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdGreaterThan(String value) {
            addCriterion("requesting_trx_id >", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("requesting_trx_id >=", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdLessThan(String value) {
            addCriterion("requesting_trx_id <", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdLessThanOrEqualTo(String value) {
            addCriterion("requesting_trx_id <=", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdLike(String value) {
            addCriterion("requesting_trx_id like", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdNotLike(String value) {
            addCriterion("requesting_trx_id not like", value, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdIn(List<String> values) {
            addCriterion("requesting_trx_id in", values, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdNotIn(List<String> values) {
            addCriterion("requesting_trx_id not in", values, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdBetween(String value1, String value2) {
            addCriterion("requesting_trx_id between", value1, value2, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestingTrxIdNotBetween(String value1, String value2) {
            addCriterion("requesting_trx_id not between", value1, value2, "requestingTrxId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdIsNull() {
            addCriterion("requested_lock_id is null");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdIsNotNull() {
            addCriterion("requested_lock_id is not null");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdEqualTo(String value) {
            addCriterion("requested_lock_id =", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdNotEqualTo(String value) {
            addCriterion("requested_lock_id <>", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdGreaterThan(String value) {
            addCriterion("requested_lock_id >", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdGreaterThanOrEqualTo(String value) {
            addCriterion("requested_lock_id >=", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdLessThan(String value) {
            addCriterion("requested_lock_id <", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdLessThanOrEqualTo(String value) {
            addCriterion("requested_lock_id <=", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdLike(String value) {
            addCriterion("requested_lock_id like", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdNotLike(String value) {
            addCriterion("requested_lock_id not like", value, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdIn(List<String> values) {
            addCriterion("requested_lock_id in", values, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdNotIn(List<String> values) {
            addCriterion("requested_lock_id not in", values, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdBetween(String value1, String value2) {
            addCriterion("requested_lock_id between", value1, value2, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andRequestedLockIdNotBetween(String value1, String value2) {
            addCriterion("requested_lock_id not between", value1, value2, "requestedLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdIsNull() {
            addCriterion("blocking_trx_id is null");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdIsNotNull() {
            addCriterion("blocking_trx_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdEqualTo(String value) {
            addCriterion("blocking_trx_id =", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdNotEqualTo(String value) {
            addCriterion("blocking_trx_id <>", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdGreaterThan(String value) {
            addCriterion("blocking_trx_id >", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("blocking_trx_id >=", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdLessThan(String value) {
            addCriterion("blocking_trx_id <", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdLessThanOrEqualTo(String value) {
            addCriterion("blocking_trx_id <=", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdLike(String value) {
            addCriterion("blocking_trx_id like", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdNotLike(String value) {
            addCriterion("blocking_trx_id not like", value, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdIn(List<String> values) {
            addCriterion("blocking_trx_id in", values, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdNotIn(List<String> values) {
            addCriterion("blocking_trx_id not in", values, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdBetween(String value1, String value2) {
            addCriterion("blocking_trx_id between", value1, value2, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingTrxIdNotBetween(String value1, String value2) {
            addCriterion("blocking_trx_id not between", value1, value2, "blockingTrxId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdIsNull() {
            addCriterion("blocking_lock_id is null");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdIsNotNull() {
            addCriterion("blocking_lock_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdEqualTo(String value) {
            addCriterion("blocking_lock_id =", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdNotEqualTo(String value) {
            addCriterion("blocking_lock_id <>", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdGreaterThan(String value) {
            addCriterion("blocking_lock_id >", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdGreaterThanOrEqualTo(String value) {
            addCriterion("blocking_lock_id >=", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdLessThan(String value) {
            addCriterion("blocking_lock_id <", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdLessThanOrEqualTo(String value) {
            addCriterion("blocking_lock_id <=", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdLike(String value) {
            addCriterion("blocking_lock_id like", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdNotLike(String value) {
            addCriterion("blocking_lock_id not like", value, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdIn(List<String> values) {
            addCriterion("blocking_lock_id in", values, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdNotIn(List<String> values) {
            addCriterion("blocking_lock_id not in", values, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdBetween(String value1, String value2) {
            addCriterion("blocking_lock_id between", value1, value2, "blockingLockId");
            return (Criteria) this;
        }

        public Criteria andBlockingLockIdNotBetween(String value1, String value2) {
            addCriterion("blocking_lock_id not between", value1, value2, "blockingLockId");
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