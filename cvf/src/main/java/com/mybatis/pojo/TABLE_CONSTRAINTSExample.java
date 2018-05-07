package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class TABLE_CONSTRAINTSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TABLE_CONSTRAINTSExample() {
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

        public Criteria andConstraintCatalogIsNull() {
            addCriterion("CONSTRAINT_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogIsNotNull() {
            addCriterion("CONSTRAINT_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG =", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG <>", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogGreaterThan(String value) {
            addCriterion("CONSTRAINT_CATALOG >", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG >=", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLessThan(String value) {
            addCriterion("CONSTRAINT_CATALOG <", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_CATALOG <=", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogLike(String value) {
            addCriterion("CONSTRAINT_CATALOG like", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotLike(String value) {
            addCriterion("CONSTRAINT_CATALOG not like", value, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogIn(List<String> values) {
            addCriterion("CONSTRAINT_CATALOG in", values, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotIn(List<String> values) {
            addCriterion("CONSTRAINT_CATALOG not in", values, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_CATALOG between", value1, value2, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintCatalogNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_CATALOG not between", value1, value2, "constraintCatalog");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIsNull() {
            addCriterion("CONSTRAINT_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIsNotNull() {
            addCriterion("CONSTRAINT_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA =", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA <>", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaGreaterThan(String value) {
            addCriterion("CONSTRAINT_SCHEMA >", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA >=", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLessThan(String value) {
            addCriterion("CONSTRAINT_SCHEMA <", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_SCHEMA <=", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaLike(String value) {
            addCriterion("CONSTRAINT_SCHEMA like", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotLike(String value) {
            addCriterion("CONSTRAINT_SCHEMA not like", value, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaIn(List<String> values) {
            addCriterion("CONSTRAINT_SCHEMA in", values, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotIn(List<String> values) {
            addCriterion("CONSTRAINT_SCHEMA not in", values, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_SCHEMA between", value1, value2, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintSchemaNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_SCHEMA not between", value1, value2, "constraintSchema");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIsNull() {
            addCriterion("CONSTRAINT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIsNotNull() {
            addCriterion("CONSTRAINT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintNameEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME =", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME <>", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameGreaterThan(String value) {
            addCriterion("CONSTRAINT_NAME >", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME >=", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLessThan(String value) {
            addCriterion("CONSTRAINT_NAME <", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_NAME <=", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameLike(String value) {
            addCriterion("CONSTRAINT_NAME like", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotLike(String value) {
            addCriterion("CONSTRAINT_NAME not like", value, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameIn(List<String> values) {
            addCriterion("CONSTRAINT_NAME in", values, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotIn(List<String> values) {
            addCriterion("CONSTRAINT_NAME not in", values, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_NAME between", value1, value2, "constraintName");
            return (Criteria) this;
        }

        public Criteria andConstraintNameNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_NAME not between", value1, value2, "constraintName");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIsNull() {
            addCriterion("TABLE_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIsNotNull() {
            addCriterion("TABLE_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andTableSchemaEqualTo(String value) {
            addCriterion("TABLE_SCHEMA =", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotEqualTo(String value) {
            addCriterion("TABLE_SCHEMA <>", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaGreaterThan(String value) {
            addCriterion("TABLE_SCHEMA >", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_SCHEMA >=", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLessThan(String value) {
            addCriterion("TABLE_SCHEMA <", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLessThanOrEqualTo(String value) {
            addCriterion("TABLE_SCHEMA <=", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaLike(String value) {
            addCriterion("TABLE_SCHEMA like", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotLike(String value) {
            addCriterion("TABLE_SCHEMA not like", value, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaIn(List<String> values) {
            addCriterion("TABLE_SCHEMA in", values, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotIn(List<String> values) {
            addCriterion("TABLE_SCHEMA not in", values, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaBetween(String value1, String value2) {
            addCriterion("TABLE_SCHEMA between", value1, value2, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableSchemaNotBetween(String value1, String value2) {
            addCriterion("TABLE_SCHEMA not between", value1, value2, "tableSchema");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTableNameIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTableNameEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThan(String value) {
            addCriterion("TABLE_NAME <", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameLike(String value) {
            addCriterion("TABLE_NAME like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andTableNameNotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "tableName");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeIsNull() {
            addCriterion("CONSTRAINT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeIsNotNull() {
            addCriterion("CONSTRAINT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeEqualTo(String value) {
            addCriterion("CONSTRAINT_TYPE =", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeNotEqualTo(String value) {
            addCriterion("CONSTRAINT_TYPE <>", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeGreaterThan(String value) {
            addCriterion("CONSTRAINT_TYPE >", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_TYPE >=", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeLessThan(String value) {
            addCriterion("CONSTRAINT_TYPE <", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeLessThanOrEqualTo(String value) {
            addCriterion("CONSTRAINT_TYPE <=", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeLike(String value) {
            addCriterion("CONSTRAINT_TYPE like", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeNotLike(String value) {
            addCriterion("CONSTRAINT_TYPE not like", value, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeIn(List<String> values) {
            addCriterion("CONSTRAINT_TYPE in", values, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeNotIn(List<String> values) {
            addCriterion("CONSTRAINT_TYPE not in", values, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_TYPE between", value1, value2, "constraintType");
            return (Criteria) this;
        }

        public Criteria andConstraintTypeNotBetween(String value1, String value2) {
            addCriterion("CONSTRAINT_TYPE not between", value1, value2, "constraintType");
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