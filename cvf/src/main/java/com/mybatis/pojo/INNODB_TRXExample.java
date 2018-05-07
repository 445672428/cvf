package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class INNODB_TRXExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public INNODB_TRXExample() {
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

        public Criteria andTrxIdIsNull() {
            addCriterion("trx_id is null");
            return (Criteria) this;
        }

        public Criteria andTrxIdIsNotNull() {
            addCriterion("trx_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrxIdEqualTo(String value) {
            addCriterion("trx_id =", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdNotEqualTo(String value) {
            addCriterion("trx_id <>", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdGreaterThan(String value) {
            addCriterion("trx_id >", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdGreaterThanOrEqualTo(String value) {
            addCriterion("trx_id >=", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdLessThan(String value) {
            addCriterion("trx_id <", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdLessThanOrEqualTo(String value) {
            addCriterion("trx_id <=", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdLike(String value) {
            addCriterion("trx_id like", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdNotLike(String value) {
            addCriterion("trx_id not like", value, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdIn(List<String> values) {
            addCriterion("trx_id in", values, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdNotIn(List<String> values) {
            addCriterion("trx_id not in", values, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdBetween(String value1, String value2) {
            addCriterion("trx_id between", value1, value2, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxIdNotBetween(String value1, String value2) {
            addCriterion("trx_id not between", value1, value2, "trxId");
            return (Criteria) this;
        }

        public Criteria andTrxStateIsNull() {
            addCriterion("trx_state is null");
            return (Criteria) this;
        }

        public Criteria andTrxStateIsNotNull() {
            addCriterion("trx_state is not null");
            return (Criteria) this;
        }

        public Criteria andTrxStateEqualTo(String value) {
            addCriterion("trx_state =", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateNotEqualTo(String value) {
            addCriterion("trx_state <>", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateGreaterThan(String value) {
            addCriterion("trx_state >", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateGreaterThanOrEqualTo(String value) {
            addCriterion("trx_state >=", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateLessThan(String value) {
            addCriterion("trx_state <", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateLessThanOrEqualTo(String value) {
            addCriterion("trx_state <=", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateLike(String value) {
            addCriterion("trx_state like", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateNotLike(String value) {
            addCriterion("trx_state not like", value, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateIn(List<String> values) {
            addCriterion("trx_state in", values, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateNotIn(List<String> values) {
            addCriterion("trx_state not in", values, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateBetween(String value1, String value2) {
            addCriterion("trx_state between", value1, value2, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStateNotBetween(String value1, String value2) {
            addCriterion("trx_state not between", value1, value2, "trxState");
            return (Criteria) this;
        }

        public Criteria andTrxStartedIsNull() {
            addCriterion("trx_started is null");
            return (Criteria) this;
        }

        public Criteria andTrxStartedIsNotNull() {
            addCriterion("trx_started is not null");
            return (Criteria) this;
        }

        public Criteria andTrxStartedEqualTo(Date value) {
            addCriterion("trx_started =", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedNotEqualTo(Date value) {
            addCriterion("trx_started <>", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedGreaterThan(Date value) {
            addCriterion("trx_started >", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedGreaterThanOrEqualTo(Date value) {
            addCriterion("trx_started >=", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedLessThan(Date value) {
            addCriterion("trx_started <", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedLessThanOrEqualTo(Date value) {
            addCriterion("trx_started <=", value, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedIn(List<Date> values) {
            addCriterion("trx_started in", values, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedNotIn(List<Date> values) {
            addCriterion("trx_started not in", values, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedBetween(Date value1, Date value2) {
            addCriterion("trx_started between", value1, value2, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxStartedNotBetween(Date value1, Date value2) {
            addCriterion("trx_started not between", value1, value2, "trxStarted");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdIsNull() {
            addCriterion("trx_requested_lock_id is null");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdIsNotNull() {
            addCriterion("trx_requested_lock_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdEqualTo(String value) {
            addCriterion("trx_requested_lock_id =", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdNotEqualTo(String value) {
            addCriterion("trx_requested_lock_id <>", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdGreaterThan(String value) {
            addCriterion("trx_requested_lock_id >", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdGreaterThanOrEqualTo(String value) {
            addCriterion("trx_requested_lock_id >=", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdLessThan(String value) {
            addCriterion("trx_requested_lock_id <", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdLessThanOrEqualTo(String value) {
            addCriterion("trx_requested_lock_id <=", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdLike(String value) {
            addCriterion("trx_requested_lock_id like", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdNotLike(String value) {
            addCriterion("trx_requested_lock_id not like", value, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdIn(List<String> values) {
            addCriterion("trx_requested_lock_id in", values, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdNotIn(List<String> values) {
            addCriterion("trx_requested_lock_id not in", values, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdBetween(String value1, String value2) {
            addCriterion("trx_requested_lock_id between", value1, value2, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxRequestedLockIdNotBetween(String value1, String value2) {
            addCriterion("trx_requested_lock_id not between", value1, value2, "trxRequestedLockId");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedIsNull() {
            addCriterion("trx_wait_started is null");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedIsNotNull() {
            addCriterion("trx_wait_started is not null");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedEqualTo(Date value) {
            addCriterion("trx_wait_started =", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedNotEqualTo(Date value) {
            addCriterion("trx_wait_started <>", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedGreaterThan(Date value) {
            addCriterion("trx_wait_started >", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedGreaterThanOrEqualTo(Date value) {
            addCriterion("trx_wait_started >=", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedLessThan(Date value) {
            addCriterion("trx_wait_started <", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedLessThanOrEqualTo(Date value) {
            addCriterion("trx_wait_started <=", value, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedIn(List<Date> values) {
            addCriterion("trx_wait_started in", values, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedNotIn(List<Date> values) {
            addCriterion("trx_wait_started not in", values, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedBetween(Date value1, Date value2) {
            addCriterion("trx_wait_started between", value1, value2, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWaitStartedNotBetween(Date value1, Date value2) {
            addCriterion("trx_wait_started not between", value1, value2, "trxWaitStarted");
            return (Criteria) this;
        }

        public Criteria andTrxWeightIsNull() {
            addCriterion("trx_weight is null");
            return (Criteria) this;
        }

        public Criteria andTrxWeightIsNotNull() {
            addCriterion("trx_weight is not null");
            return (Criteria) this;
        }

        public Criteria andTrxWeightEqualTo(Long value) {
            addCriterion("trx_weight =", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightNotEqualTo(Long value) {
            addCriterion("trx_weight <>", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightGreaterThan(Long value) {
            addCriterion("trx_weight >", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_weight >=", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightLessThan(Long value) {
            addCriterion("trx_weight <", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightLessThanOrEqualTo(Long value) {
            addCriterion("trx_weight <=", value, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightIn(List<Long> values) {
            addCriterion("trx_weight in", values, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightNotIn(List<Long> values) {
            addCriterion("trx_weight not in", values, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightBetween(Long value1, Long value2) {
            addCriterion("trx_weight between", value1, value2, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxWeightNotBetween(Long value1, Long value2) {
            addCriterion("trx_weight not between", value1, value2, "trxWeight");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdIsNull() {
            addCriterion("trx_mysql_thread_id is null");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdIsNotNull() {
            addCriterion("trx_mysql_thread_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdEqualTo(Long value) {
            addCriterion("trx_mysql_thread_id =", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdNotEqualTo(Long value) {
            addCriterion("trx_mysql_thread_id <>", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdGreaterThan(Long value) {
            addCriterion("trx_mysql_thread_id >", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_mysql_thread_id >=", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdLessThan(Long value) {
            addCriterion("trx_mysql_thread_id <", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdLessThanOrEqualTo(Long value) {
            addCriterion("trx_mysql_thread_id <=", value, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdIn(List<Long> values) {
            addCriterion("trx_mysql_thread_id in", values, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdNotIn(List<Long> values) {
            addCriterion("trx_mysql_thread_id not in", values, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdBetween(Long value1, Long value2) {
            addCriterion("trx_mysql_thread_id between", value1, value2, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxMysqlThreadIdNotBetween(Long value1, Long value2) {
            addCriterion("trx_mysql_thread_id not between", value1, value2, "trxMysqlThreadId");
            return (Criteria) this;
        }

        public Criteria andTrxQueryIsNull() {
            addCriterion("trx_query is null");
            return (Criteria) this;
        }

        public Criteria andTrxQueryIsNotNull() {
            addCriterion("trx_query is not null");
            return (Criteria) this;
        }

        public Criteria andTrxQueryEqualTo(String value) {
            addCriterion("trx_query =", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryNotEqualTo(String value) {
            addCriterion("trx_query <>", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryGreaterThan(String value) {
            addCriterion("trx_query >", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryGreaterThanOrEqualTo(String value) {
            addCriterion("trx_query >=", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryLessThan(String value) {
            addCriterion("trx_query <", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryLessThanOrEqualTo(String value) {
            addCriterion("trx_query <=", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryLike(String value) {
            addCriterion("trx_query like", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryNotLike(String value) {
            addCriterion("trx_query not like", value, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryIn(List<String> values) {
            addCriterion("trx_query in", values, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryNotIn(List<String> values) {
            addCriterion("trx_query not in", values, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryBetween(String value1, String value2) {
            addCriterion("trx_query between", value1, value2, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxQueryNotBetween(String value1, String value2) {
            addCriterion("trx_query not between", value1, value2, "trxQuery");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateIsNull() {
            addCriterion("trx_operation_state is null");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateIsNotNull() {
            addCriterion("trx_operation_state is not null");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateEqualTo(String value) {
            addCriterion("trx_operation_state =", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateNotEqualTo(String value) {
            addCriterion("trx_operation_state <>", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateGreaterThan(String value) {
            addCriterion("trx_operation_state >", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateGreaterThanOrEqualTo(String value) {
            addCriterion("trx_operation_state >=", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateLessThan(String value) {
            addCriterion("trx_operation_state <", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateLessThanOrEqualTo(String value) {
            addCriterion("trx_operation_state <=", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateLike(String value) {
            addCriterion("trx_operation_state like", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateNotLike(String value) {
            addCriterion("trx_operation_state not like", value, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateIn(List<String> values) {
            addCriterion("trx_operation_state in", values, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateNotIn(List<String> values) {
            addCriterion("trx_operation_state not in", values, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateBetween(String value1, String value2) {
            addCriterion("trx_operation_state between", value1, value2, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxOperationStateNotBetween(String value1, String value2) {
            addCriterion("trx_operation_state not between", value1, value2, "trxOperationState");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseIsNull() {
            addCriterion("trx_tables_in_use is null");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseIsNotNull() {
            addCriterion("trx_tables_in_use is not null");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseEqualTo(Long value) {
            addCriterion("trx_tables_in_use =", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseNotEqualTo(Long value) {
            addCriterion("trx_tables_in_use <>", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseGreaterThan(Long value) {
            addCriterion("trx_tables_in_use >", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_tables_in_use >=", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseLessThan(Long value) {
            addCriterion("trx_tables_in_use <", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseLessThanOrEqualTo(Long value) {
            addCriterion("trx_tables_in_use <=", value, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseIn(List<Long> values) {
            addCriterion("trx_tables_in_use in", values, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseNotIn(List<Long> values) {
            addCriterion("trx_tables_in_use not in", values, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseBetween(Long value1, Long value2) {
            addCriterion("trx_tables_in_use between", value1, value2, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesInUseNotBetween(Long value1, Long value2) {
            addCriterion("trx_tables_in_use not between", value1, value2, "trxTablesInUse");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedIsNull() {
            addCriterion("trx_tables_locked is null");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedIsNotNull() {
            addCriterion("trx_tables_locked is not null");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedEqualTo(Long value) {
            addCriterion("trx_tables_locked =", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedNotEqualTo(Long value) {
            addCriterion("trx_tables_locked <>", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedGreaterThan(Long value) {
            addCriterion("trx_tables_locked >", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_tables_locked >=", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedLessThan(Long value) {
            addCriterion("trx_tables_locked <", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedLessThanOrEqualTo(Long value) {
            addCriterion("trx_tables_locked <=", value, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedIn(List<Long> values) {
            addCriterion("trx_tables_locked in", values, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedNotIn(List<Long> values) {
            addCriterion("trx_tables_locked not in", values, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedBetween(Long value1, Long value2) {
            addCriterion("trx_tables_locked between", value1, value2, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxTablesLockedNotBetween(Long value1, Long value2) {
            addCriterion("trx_tables_locked not between", value1, value2, "trxTablesLocked");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsIsNull() {
            addCriterion("trx_lock_structs is null");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsIsNotNull() {
            addCriterion("trx_lock_structs is not null");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsEqualTo(Long value) {
            addCriterion("trx_lock_structs =", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsNotEqualTo(Long value) {
            addCriterion("trx_lock_structs <>", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsGreaterThan(Long value) {
            addCriterion("trx_lock_structs >", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_lock_structs >=", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsLessThan(Long value) {
            addCriterion("trx_lock_structs <", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsLessThanOrEqualTo(Long value) {
            addCriterion("trx_lock_structs <=", value, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsIn(List<Long> values) {
            addCriterion("trx_lock_structs in", values, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsNotIn(List<Long> values) {
            addCriterion("trx_lock_structs not in", values, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsBetween(Long value1, Long value2) {
            addCriterion("trx_lock_structs between", value1, value2, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockStructsNotBetween(Long value1, Long value2) {
            addCriterion("trx_lock_structs not between", value1, value2, "trxLockStructs");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesIsNull() {
            addCriterion("trx_lock_memory_bytes is null");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesIsNotNull() {
            addCriterion("trx_lock_memory_bytes is not null");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesEqualTo(Long value) {
            addCriterion("trx_lock_memory_bytes =", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesNotEqualTo(Long value) {
            addCriterion("trx_lock_memory_bytes <>", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesGreaterThan(Long value) {
            addCriterion("trx_lock_memory_bytes >", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_lock_memory_bytes >=", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesLessThan(Long value) {
            addCriterion("trx_lock_memory_bytes <", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesLessThanOrEqualTo(Long value) {
            addCriterion("trx_lock_memory_bytes <=", value, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesIn(List<Long> values) {
            addCriterion("trx_lock_memory_bytes in", values, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesNotIn(List<Long> values) {
            addCriterion("trx_lock_memory_bytes not in", values, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesBetween(Long value1, Long value2) {
            addCriterion("trx_lock_memory_bytes between", value1, value2, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxLockMemoryBytesNotBetween(Long value1, Long value2) {
            addCriterion("trx_lock_memory_bytes not between", value1, value2, "trxLockMemoryBytes");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedIsNull() {
            addCriterion("trx_rows_locked is null");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedIsNotNull() {
            addCriterion("trx_rows_locked is not null");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedEqualTo(Long value) {
            addCriterion("trx_rows_locked =", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedNotEqualTo(Long value) {
            addCriterion("trx_rows_locked <>", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedGreaterThan(Long value) {
            addCriterion("trx_rows_locked >", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_rows_locked >=", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedLessThan(Long value) {
            addCriterion("trx_rows_locked <", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedLessThanOrEqualTo(Long value) {
            addCriterion("trx_rows_locked <=", value, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedIn(List<Long> values) {
            addCriterion("trx_rows_locked in", values, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedNotIn(List<Long> values) {
            addCriterion("trx_rows_locked not in", values, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedBetween(Long value1, Long value2) {
            addCriterion("trx_rows_locked between", value1, value2, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsLockedNotBetween(Long value1, Long value2) {
            addCriterion("trx_rows_locked not between", value1, value2, "trxRowsLocked");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedIsNull() {
            addCriterion("trx_rows_modified is null");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedIsNotNull() {
            addCriterion("trx_rows_modified is not null");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedEqualTo(Long value) {
            addCriterion("trx_rows_modified =", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedNotEqualTo(Long value) {
            addCriterion("trx_rows_modified <>", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedGreaterThan(Long value) {
            addCriterion("trx_rows_modified >", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_rows_modified >=", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedLessThan(Long value) {
            addCriterion("trx_rows_modified <", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedLessThanOrEqualTo(Long value) {
            addCriterion("trx_rows_modified <=", value, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedIn(List<Long> values) {
            addCriterion("trx_rows_modified in", values, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedNotIn(List<Long> values) {
            addCriterion("trx_rows_modified not in", values, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedBetween(Long value1, Long value2) {
            addCriterion("trx_rows_modified between", value1, value2, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxRowsModifiedNotBetween(Long value1, Long value2) {
            addCriterion("trx_rows_modified not between", value1, value2, "trxRowsModified");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsIsNull() {
            addCriterion("trx_concurrency_tickets is null");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsIsNotNull() {
            addCriterion("trx_concurrency_tickets is not null");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsEqualTo(Long value) {
            addCriterion("trx_concurrency_tickets =", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsNotEqualTo(Long value) {
            addCriterion("trx_concurrency_tickets <>", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsGreaterThan(Long value) {
            addCriterion("trx_concurrency_tickets >", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_concurrency_tickets >=", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsLessThan(Long value) {
            addCriterion("trx_concurrency_tickets <", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsLessThanOrEqualTo(Long value) {
            addCriterion("trx_concurrency_tickets <=", value, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsIn(List<Long> values) {
            addCriterion("trx_concurrency_tickets in", values, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsNotIn(List<Long> values) {
            addCriterion("trx_concurrency_tickets not in", values, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsBetween(Long value1, Long value2) {
            addCriterion("trx_concurrency_tickets between", value1, value2, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxConcurrencyTicketsNotBetween(Long value1, Long value2) {
            addCriterion("trx_concurrency_tickets not between", value1, value2, "trxConcurrencyTickets");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelIsNull() {
            addCriterion("trx_isolation_level is null");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelIsNotNull() {
            addCriterion("trx_isolation_level is not null");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelEqualTo(String value) {
            addCriterion("trx_isolation_level =", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelNotEqualTo(String value) {
            addCriterion("trx_isolation_level <>", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelGreaterThan(String value) {
            addCriterion("trx_isolation_level >", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelGreaterThanOrEqualTo(String value) {
            addCriterion("trx_isolation_level >=", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelLessThan(String value) {
            addCriterion("trx_isolation_level <", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelLessThanOrEqualTo(String value) {
            addCriterion("trx_isolation_level <=", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelLike(String value) {
            addCriterion("trx_isolation_level like", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelNotLike(String value) {
            addCriterion("trx_isolation_level not like", value, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelIn(List<String> values) {
            addCriterion("trx_isolation_level in", values, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelNotIn(List<String> values) {
            addCriterion("trx_isolation_level not in", values, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelBetween(String value1, String value2) {
            addCriterion("trx_isolation_level between", value1, value2, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxIsolationLevelNotBetween(String value1, String value2) {
            addCriterion("trx_isolation_level not between", value1, value2, "trxIsolationLevel");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksIsNull() {
            addCriterion("trx_unique_checks is null");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksIsNotNull() {
            addCriterion("trx_unique_checks is not null");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksEqualTo(Integer value) {
            addCriterion("trx_unique_checks =", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksNotEqualTo(Integer value) {
            addCriterion("trx_unique_checks <>", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksGreaterThan(Integer value) {
            addCriterion("trx_unique_checks >", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksGreaterThanOrEqualTo(Integer value) {
            addCriterion("trx_unique_checks >=", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksLessThan(Integer value) {
            addCriterion("trx_unique_checks <", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksLessThanOrEqualTo(Integer value) {
            addCriterion("trx_unique_checks <=", value, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksIn(List<Integer> values) {
            addCriterion("trx_unique_checks in", values, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksNotIn(List<Integer> values) {
            addCriterion("trx_unique_checks not in", values, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksBetween(Integer value1, Integer value2) {
            addCriterion("trx_unique_checks between", value1, value2, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxUniqueChecksNotBetween(Integer value1, Integer value2) {
            addCriterion("trx_unique_checks not between", value1, value2, "trxUniqueChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksIsNull() {
            addCriterion("trx_foreign_key_checks is null");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksIsNotNull() {
            addCriterion("trx_foreign_key_checks is not null");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksEqualTo(Integer value) {
            addCriterion("trx_foreign_key_checks =", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksNotEqualTo(Integer value) {
            addCriterion("trx_foreign_key_checks <>", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksGreaterThan(Integer value) {
            addCriterion("trx_foreign_key_checks >", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksGreaterThanOrEqualTo(Integer value) {
            addCriterion("trx_foreign_key_checks >=", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksLessThan(Integer value) {
            addCriterion("trx_foreign_key_checks <", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksLessThanOrEqualTo(Integer value) {
            addCriterion("trx_foreign_key_checks <=", value, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksIn(List<Integer> values) {
            addCriterion("trx_foreign_key_checks in", values, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksNotIn(List<Integer> values) {
            addCriterion("trx_foreign_key_checks not in", values, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksBetween(Integer value1, Integer value2) {
            addCriterion("trx_foreign_key_checks between", value1, value2, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxForeignKeyChecksNotBetween(Integer value1, Integer value2) {
            addCriterion("trx_foreign_key_checks not between", value1, value2, "trxForeignKeyChecks");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorIsNull() {
            addCriterion("trx_last_foreign_key_error is null");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorIsNotNull() {
            addCriterion("trx_last_foreign_key_error is not null");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorEqualTo(String value) {
            addCriterion("trx_last_foreign_key_error =", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorNotEqualTo(String value) {
            addCriterion("trx_last_foreign_key_error <>", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorGreaterThan(String value) {
            addCriterion("trx_last_foreign_key_error >", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorGreaterThanOrEqualTo(String value) {
            addCriterion("trx_last_foreign_key_error >=", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorLessThan(String value) {
            addCriterion("trx_last_foreign_key_error <", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorLessThanOrEqualTo(String value) {
            addCriterion("trx_last_foreign_key_error <=", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorLike(String value) {
            addCriterion("trx_last_foreign_key_error like", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorNotLike(String value) {
            addCriterion("trx_last_foreign_key_error not like", value, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorIn(List<String> values) {
            addCriterion("trx_last_foreign_key_error in", values, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorNotIn(List<String> values) {
            addCriterion("trx_last_foreign_key_error not in", values, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorBetween(String value1, String value2) {
            addCriterion("trx_last_foreign_key_error between", value1, value2, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxLastForeignKeyErrorNotBetween(String value1, String value2) {
            addCriterion("trx_last_foreign_key_error not between", value1, value2, "trxLastForeignKeyError");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedIsNull() {
            addCriterion("trx_adaptive_hash_latched is null");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedIsNotNull() {
            addCriterion("trx_adaptive_hash_latched is not null");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedEqualTo(Integer value) {
            addCriterion("trx_adaptive_hash_latched =", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedNotEqualTo(Integer value) {
            addCriterion("trx_adaptive_hash_latched <>", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedGreaterThan(Integer value) {
            addCriterion("trx_adaptive_hash_latched >", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedGreaterThanOrEqualTo(Integer value) {
            addCriterion("trx_adaptive_hash_latched >=", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedLessThan(Integer value) {
            addCriterion("trx_adaptive_hash_latched <", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedLessThanOrEqualTo(Integer value) {
            addCriterion("trx_adaptive_hash_latched <=", value, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedIn(List<Integer> values) {
            addCriterion("trx_adaptive_hash_latched in", values, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedNotIn(List<Integer> values) {
            addCriterion("trx_adaptive_hash_latched not in", values, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedBetween(Integer value1, Integer value2) {
            addCriterion("trx_adaptive_hash_latched between", value1, value2, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashLatchedNotBetween(Integer value1, Integer value2) {
            addCriterion("trx_adaptive_hash_latched not between", value1, value2, "trxAdaptiveHashLatched");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutIsNull() {
            addCriterion("trx_adaptive_hash_timeout is null");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutIsNotNull() {
            addCriterion("trx_adaptive_hash_timeout is not null");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutEqualTo(Long value) {
            addCriterion("trx_adaptive_hash_timeout =", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutNotEqualTo(Long value) {
            addCriterion("trx_adaptive_hash_timeout <>", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutGreaterThan(Long value) {
            addCriterion("trx_adaptive_hash_timeout >", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutGreaterThanOrEqualTo(Long value) {
            addCriterion("trx_adaptive_hash_timeout >=", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutLessThan(Long value) {
            addCriterion("trx_adaptive_hash_timeout <", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutLessThanOrEqualTo(Long value) {
            addCriterion("trx_adaptive_hash_timeout <=", value, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutIn(List<Long> values) {
            addCriterion("trx_adaptive_hash_timeout in", values, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutNotIn(List<Long> values) {
            addCriterion("trx_adaptive_hash_timeout not in", values, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutBetween(Long value1, Long value2) {
            addCriterion("trx_adaptive_hash_timeout between", value1, value2, "trxAdaptiveHashTimeout");
            return (Criteria) this;
        }

        public Criteria andTrxAdaptiveHashTimeoutNotBetween(Long value1, Long value2) {
            addCriterion("trx_adaptive_hash_timeout not between", value1, value2, "trxAdaptiveHashTimeout");
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