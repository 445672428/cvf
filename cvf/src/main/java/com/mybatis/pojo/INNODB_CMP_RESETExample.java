package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class INNODB_CMP_RESETExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public INNODB_CMP_RESETExample() {
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

        public Criteria andCompressOpsIsNull() {
            addCriterion("compress_ops is null");
            return (Criteria) this;
        }

        public Criteria andCompressOpsIsNotNull() {
            addCriterion("compress_ops is not null");
            return (Criteria) this;
        }

        public Criteria andCompressOpsEqualTo(Integer value) {
            addCriterion("compress_ops =", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsNotEqualTo(Integer value) {
            addCriterion("compress_ops <>", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsGreaterThan(Integer value) {
            addCriterion("compress_ops >", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsGreaterThanOrEqualTo(Integer value) {
            addCriterion("compress_ops >=", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsLessThan(Integer value) {
            addCriterion("compress_ops <", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsLessThanOrEqualTo(Integer value) {
            addCriterion("compress_ops <=", value, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsIn(List<Integer> values) {
            addCriterion("compress_ops in", values, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsNotIn(List<Integer> values) {
            addCriterion("compress_ops not in", values, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsBetween(Integer value1, Integer value2) {
            addCriterion("compress_ops between", value1, value2, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsNotBetween(Integer value1, Integer value2) {
            addCriterion("compress_ops not between", value1, value2, "compressOps");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkIsNull() {
            addCriterion("compress_ops_ok is null");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkIsNotNull() {
            addCriterion("compress_ops_ok is not null");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkEqualTo(Integer value) {
            addCriterion("compress_ops_ok =", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkNotEqualTo(Integer value) {
            addCriterion("compress_ops_ok <>", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkGreaterThan(Integer value) {
            addCriterion("compress_ops_ok >", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkGreaterThanOrEqualTo(Integer value) {
            addCriterion("compress_ops_ok >=", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkLessThan(Integer value) {
            addCriterion("compress_ops_ok <", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkLessThanOrEqualTo(Integer value) {
            addCriterion("compress_ops_ok <=", value, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkIn(List<Integer> values) {
            addCriterion("compress_ops_ok in", values, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkNotIn(List<Integer> values) {
            addCriterion("compress_ops_ok not in", values, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkBetween(Integer value1, Integer value2) {
            addCriterion("compress_ops_ok between", value1, value2, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressOpsOkNotBetween(Integer value1, Integer value2) {
            addCriterion("compress_ops_ok not between", value1, value2, "compressOpsOk");
            return (Criteria) this;
        }

        public Criteria andCompressTimeIsNull() {
            addCriterion("compress_time is null");
            return (Criteria) this;
        }

        public Criteria andCompressTimeIsNotNull() {
            addCriterion("compress_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompressTimeEqualTo(Integer value) {
            addCriterion("compress_time =", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeNotEqualTo(Integer value) {
            addCriterion("compress_time <>", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeGreaterThan(Integer value) {
            addCriterion("compress_time >", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("compress_time >=", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeLessThan(Integer value) {
            addCriterion("compress_time <", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeLessThanOrEqualTo(Integer value) {
            addCriterion("compress_time <=", value, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeIn(List<Integer> values) {
            addCriterion("compress_time in", values, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeNotIn(List<Integer> values) {
            addCriterion("compress_time not in", values, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeBetween(Integer value1, Integer value2) {
            addCriterion("compress_time between", value1, value2, "compressTime");
            return (Criteria) this;
        }

        public Criteria andCompressTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("compress_time not between", value1, value2, "compressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsIsNull() {
            addCriterion("uncompress_ops is null");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsIsNotNull() {
            addCriterion("uncompress_ops is not null");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsEqualTo(Integer value) {
            addCriterion("uncompress_ops =", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsNotEqualTo(Integer value) {
            addCriterion("uncompress_ops <>", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsGreaterThan(Integer value) {
            addCriterion("uncompress_ops >", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsGreaterThanOrEqualTo(Integer value) {
            addCriterion("uncompress_ops >=", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsLessThan(Integer value) {
            addCriterion("uncompress_ops <", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsLessThanOrEqualTo(Integer value) {
            addCriterion("uncompress_ops <=", value, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsIn(List<Integer> values) {
            addCriterion("uncompress_ops in", values, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsNotIn(List<Integer> values) {
            addCriterion("uncompress_ops not in", values, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsBetween(Integer value1, Integer value2) {
            addCriterion("uncompress_ops between", value1, value2, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressOpsNotBetween(Integer value1, Integer value2) {
            addCriterion("uncompress_ops not between", value1, value2, "uncompressOps");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeIsNull() {
            addCriterion("uncompress_time is null");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeIsNotNull() {
            addCriterion("uncompress_time is not null");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeEqualTo(Integer value) {
            addCriterion("uncompress_time =", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeNotEqualTo(Integer value) {
            addCriterion("uncompress_time <>", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeGreaterThan(Integer value) {
            addCriterion("uncompress_time >", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("uncompress_time >=", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeLessThan(Integer value) {
            addCriterion("uncompress_time <", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeLessThanOrEqualTo(Integer value) {
            addCriterion("uncompress_time <=", value, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeIn(List<Integer> values) {
            addCriterion("uncompress_time in", values, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeNotIn(List<Integer> values) {
            addCriterion("uncompress_time not in", values, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeBetween(Integer value1, Integer value2) {
            addCriterion("uncompress_time between", value1, value2, "uncompressTime");
            return (Criteria) this;
        }

        public Criteria andUncompressTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("uncompress_time not between", value1, value2, "uncompressTime");
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