package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class INNODB_CMPMEM_RESETExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public INNODB_CMPMEM_RESETExample() {
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

        public Criteria andPageSizeIsNull() {
            addCriterion("page_size is null");
            return (Criteria) this;
        }

        public Criteria andPageSizeIsNotNull() {
            addCriterion("page_size is not null");
            return (Criteria) this;
        }

        public Criteria andPageSizeEqualTo(Integer value) {
            addCriterion("page_size =", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotEqualTo(Integer value) {
            addCriterion("page_size <>", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThan(Integer value) {
            addCriterion("page_size >", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_size >=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThan(Integer value) {
            addCriterion("page_size <", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeLessThanOrEqualTo(Integer value) {
            addCriterion("page_size <=", value, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeIn(List<Integer> values) {
            addCriterion("page_size in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotIn(List<Integer> values) {
            addCriterion("page_size not in", values, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeBetween(Integer value1, Integer value2) {
            addCriterion("page_size between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andPageSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("page_size not between", value1, value2, "pageSize");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceIsNull() {
            addCriterion("buffer_pool_instance is null");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceIsNotNull() {
            addCriterion("buffer_pool_instance is not null");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceEqualTo(Integer value) {
            addCriterion("buffer_pool_instance =", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceNotEqualTo(Integer value) {
            addCriterion("buffer_pool_instance <>", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceGreaterThan(Integer value) {
            addCriterion("buffer_pool_instance >", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("buffer_pool_instance >=", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceLessThan(Integer value) {
            addCriterion("buffer_pool_instance <", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceLessThanOrEqualTo(Integer value) {
            addCriterion("buffer_pool_instance <=", value, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceIn(List<Integer> values) {
            addCriterion("buffer_pool_instance in", values, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceNotIn(List<Integer> values) {
            addCriterion("buffer_pool_instance not in", values, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceBetween(Integer value1, Integer value2) {
            addCriterion("buffer_pool_instance between", value1, value2, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andBufferPoolInstanceNotBetween(Integer value1, Integer value2) {
            addCriterion("buffer_pool_instance not between", value1, value2, "bufferPoolInstance");
            return (Criteria) this;
        }

        public Criteria andPagesUsedIsNull() {
            addCriterion("pages_used is null");
            return (Criteria) this;
        }

        public Criteria andPagesUsedIsNotNull() {
            addCriterion("pages_used is not null");
            return (Criteria) this;
        }

        public Criteria andPagesUsedEqualTo(Integer value) {
            addCriterion("pages_used =", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedNotEqualTo(Integer value) {
            addCriterion("pages_used <>", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedGreaterThan(Integer value) {
            addCriterion("pages_used >", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("pages_used >=", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedLessThan(Integer value) {
            addCriterion("pages_used <", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedLessThanOrEqualTo(Integer value) {
            addCriterion("pages_used <=", value, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedIn(List<Integer> values) {
            addCriterion("pages_used in", values, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedNotIn(List<Integer> values) {
            addCriterion("pages_used not in", values, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedBetween(Integer value1, Integer value2) {
            addCriterion("pages_used between", value1, value2, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesUsedNotBetween(Integer value1, Integer value2) {
            addCriterion("pages_used not between", value1, value2, "pagesUsed");
            return (Criteria) this;
        }

        public Criteria andPagesFreeIsNull() {
            addCriterion("pages_free is null");
            return (Criteria) this;
        }

        public Criteria andPagesFreeIsNotNull() {
            addCriterion("pages_free is not null");
            return (Criteria) this;
        }

        public Criteria andPagesFreeEqualTo(Integer value) {
            addCriterion("pages_free =", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeNotEqualTo(Integer value) {
            addCriterion("pages_free <>", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeGreaterThan(Integer value) {
            addCriterion("pages_free >", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pages_free >=", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeLessThan(Integer value) {
            addCriterion("pages_free <", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeLessThanOrEqualTo(Integer value) {
            addCriterion("pages_free <=", value, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeIn(List<Integer> values) {
            addCriterion("pages_free in", values, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeNotIn(List<Integer> values) {
            addCriterion("pages_free not in", values, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeBetween(Integer value1, Integer value2) {
            addCriterion("pages_free between", value1, value2, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andPagesFreeNotBetween(Integer value1, Integer value2) {
            addCriterion("pages_free not between", value1, value2, "pagesFree");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsIsNull() {
            addCriterion("relocation_ops is null");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsIsNotNull() {
            addCriterion("relocation_ops is not null");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsEqualTo(Long value) {
            addCriterion("relocation_ops =", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsNotEqualTo(Long value) {
            addCriterion("relocation_ops <>", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsGreaterThan(Long value) {
            addCriterion("relocation_ops >", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsGreaterThanOrEqualTo(Long value) {
            addCriterion("relocation_ops >=", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsLessThan(Long value) {
            addCriterion("relocation_ops <", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsLessThanOrEqualTo(Long value) {
            addCriterion("relocation_ops <=", value, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsIn(List<Long> values) {
            addCriterion("relocation_ops in", values, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsNotIn(List<Long> values) {
            addCriterion("relocation_ops not in", values, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsBetween(Long value1, Long value2) {
            addCriterion("relocation_ops between", value1, value2, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationOpsNotBetween(Long value1, Long value2) {
            addCriterion("relocation_ops not between", value1, value2, "relocationOps");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeIsNull() {
            addCriterion("relocation_time is null");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeIsNotNull() {
            addCriterion("relocation_time is not null");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeEqualTo(Integer value) {
            addCriterion("relocation_time =", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeNotEqualTo(Integer value) {
            addCriterion("relocation_time <>", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeGreaterThan(Integer value) {
            addCriterion("relocation_time >", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("relocation_time >=", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeLessThan(Integer value) {
            addCriterion("relocation_time <", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeLessThanOrEqualTo(Integer value) {
            addCriterion("relocation_time <=", value, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeIn(List<Integer> values) {
            addCriterion("relocation_time in", values, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeNotIn(List<Integer> values) {
            addCriterion("relocation_time not in", values, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeBetween(Integer value1, Integer value2) {
            addCriterion("relocation_time between", value1, value2, "relocationTime");
            return (Criteria) this;
        }

        public Criteria andRelocationTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("relocation_time not between", value1, value2, "relocationTime");
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