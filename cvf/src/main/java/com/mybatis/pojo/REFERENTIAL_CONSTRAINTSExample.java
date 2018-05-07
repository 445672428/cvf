package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class REFERENTIAL_CONSTRAINTSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public REFERENTIAL_CONSTRAINTSExample() {
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

        public Criteria andUniqueConstraintCatalogIsNull() {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogIsNotNull() {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG =", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogNotEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG <>", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogGreaterThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG >", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG >=", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogLessThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG <", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogLessThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG <=", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG like", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogNotLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG not like", value, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG in", values, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogNotIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG not in", values, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG between", value1, value2, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintCatalogNotBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_CATALOG not between", value1, value2, "uniqueConstraintCatalog");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaIsNull() {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaIsNotNull() {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA =", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaNotEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA <>", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaGreaterThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA >", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA >=", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaLessThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA <", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaLessThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA <=", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA like", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaNotLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA not like", value, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA in", values, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaNotIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA not in", values, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA between", value1, value2, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintSchemaNotBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_SCHEMA not between", value1, value2, "uniqueConstraintSchema");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameIsNull() {
            addCriterion("UNIQUE_CONSTRAINT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameIsNotNull() {
            addCriterion("UNIQUE_CONSTRAINT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME =", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameNotEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME <>", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameGreaterThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME >", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameGreaterThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME >=", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameLessThan(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME <", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameLessThanOrEqualTo(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME <=", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME like", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameNotLike(String value) {
            addCriterion("UNIQUE_CONSTRAINT_NAME not like", value, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_NAME in", values, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameNotIn(List<String> values) {
            addCriterion("UNIQUE_CONSTRAINT_NAME not in", values, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_NAME between", value1, value2, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andUniqueConstraintNameNotBetween(String value1, String value2) {
            addCriterion("UNIQUE_CONSTRAINT_NAME not between", value1, value2, "uniqueConstraintName");
            return (Criteria) this;
        }

        public Criteria andMatchOptionIsNull() {
            addCriterion("MATCH_OPTION is null");
            return (Criteria) this;
        }

        public Criteria andMatchOptionIsNotNull() {
            addCriterion("MATCH_OPTION is not null");
            return (Criteria) this;
        }

        public Criteria andMatchOptionEqualTo(String value) {
            addCriterion("MATCH_OPTION =", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionNotEqualTo(String value) {
            addCriterion("MATCH_OPTION <>", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionGreaterThan(String value) {
            addCriterion("MATCH_OPTION >", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionGreaterThanOrEqualTo(String value) {
            addCriterion("MATCH_OPTION >=", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionLessThan(String value) {
            addCriterion("MATCH_OPTION <", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionLessThanOrEqualTo(String value) {
            addCriterion("MATCH_OPTION <=", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionLike(String value) {
            addCriterion("MATCH_OPTION like", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionNotLike(String value) {
            addCriterion("MATCH_OPTION not like", value, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionIn(List<String> values) {
            addCriterion("MATCH_OPTION in", values, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionNotIn(List<String> values) {
            addCriterion("MATCH_OPTION not in", values, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionBetween(String value1, String value2) {
            addCriterion("MATCH_OPTION between", value1, value2, "matchOption");
            return (Criteria) this;
        }

        public Criteria andMatchOptionNotBetween(String value1, String value2) {
            addCriterion("MATCH_OPTION not between", value1, value2, "matchOption");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleIsNull() {
            addCriterion("UPDATE_RULE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleIsNotNull() {
            addCriterion("UPDATE_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleEqualTo(String value) {
            addCriterion("UPDATE_RULE =", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleNotEqualTo(String value) {
            addCriterion("UPDATE_RULE <>", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleGreaterThan(String value) {
            addCriterion("UPDATE_RULE >", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_RULE >=", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleLessThan(String value) {
            addCriterion("UPDATE_RULE <", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_RULE <=", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleLike(String value) {
            addCriterion("UPDATE_RULE like", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleNotLike(String value) {
            addCriterion("UPDATE_RULE not like", value, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleIn(List<String> values) {
            addCriterion("UPDATE_RULE in", values, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleNotIn(List<String> values) {
            addCriterion("UPDATE_RULE not in", values, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleBetween(String value1, String value2) {
            addCriterion("UPDATE_RULE between", value1, value2, "updateRule");
            return (Criteria) this;
        }

        public Criteria andUpdateRuleNotBetween(String value1, String value2) {
            addCriterion("UPDATE_RULE not between", value1, value2, "updateRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleIsNull() {
            addCriterion("DELETE_RULE is null");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleIsNotNull() {
            addCriterion("DELETE_RULE is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleEqualTo(String value) {
            addCriterion("DELETE_RULE =", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleNotEqualTo(String value) {
            addCriterion("DELETE_RULE <>", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleGreaterThan(String value) {
            addCriterion("DELETE_RULE >", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_RULE >=", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleLessThan(String value) {
            addCriterion("DELETE_RULE <", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleLessThanOrEqualTo(String value) {
            addCriterion("DELETE_RULE <=", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleLike(String value) {
            addCriterion("DELETE_RULE like", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleNotLike(String value) {
            addCriterion("DELETE_RULE not like", value, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleIn(List<String> values) {
            addCriterion("DELETE_RULE in", values, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleNotIn(List<String> values) {
            addCriterion("DELETE_RULE not in", values, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleBetween(String value1, String value2) {
            addCriterion("DELETE_RULE between", value1, value2, "deleteRule");
            return (Criteria) this;
        }

        public Criteria andDeleteRuleNotBetween(String value1, String value2) {
            addCriterion("DELETE_RULE not between", value1, value2, "deleteRule");
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

        public Criteria andReferencedTableNameIsNull() {
            addCriterion("REFERENCED_TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameIsNotNull() {
            addCriterion("REFERENCED_TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME =", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME <>", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameGreaterThan(String value) {
            addCriterion("REFERENCED_TABLE_NAME >", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME >=", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLessThan(String value) {
            addCriterion("REFERENCED_TABLE_NAME <", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLessThanOrEqualTo(String value) {
            addCriterion("REFERENCED_TABLE_NAME <=", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameLike(String value) {
            addCriterion("REFERENCED_TABLE_NAME like", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotLike(String value) {
            addCriterion("REFERENCED_TABLE_NAME not like", value, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_NAME in", values, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotIn(List<String> values) {
            addCriterion("REFERENCED_TABLE_NAME not in", values, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_NAME between", value1, value2, "referencedTableName");
            return (Criteria) this;
        }

        public Criteria andReferencedTableNameNotBetween(String value1, String value2) {
            addCriterion("REFERENCED_TABLE_NAME not between", value1, value2, "referencedTableName");
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