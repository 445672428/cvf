package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FILESExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FILESExample() {
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

        public Criteria andFileIdIsNull() {
            addCriterion("FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Long value) {
            addCriterion("FILE_ID =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Long value) {
            addCriterion("FILE_ID <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Long value) {
            addCriterion("FILE_ID >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("FILE_ID >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Long value) {
            addCriterion("FILE_ID <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Long value) {
            addCriterion("FILE_ID <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Long> values) {
            addCriterion("FILE_ID in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Long> values) {
            addCriterion("FILE_ID not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Long value1, Long value2) {
            addCriterion("FILE_ID between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Long value1, Long value2) {
            addCriterion("FILE_ID not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("FILE_TYPE =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("FILE_TYPE <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("FILE_TYPE >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("FILE_TYPE <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("FILE_TYPE like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("FILE_TYPE not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("FILE_TYPE in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("FILE_TYPE not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("FILE_TYPE between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("FILE_TYPE not between", value1, value2, "fileType");
            return (Criteria) this;
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

        public Criteria andTableCatalogIsNull() {
            addCriterion("TABLE_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andTableCatalogIsNotNull() {
            addCriterion("TABLE_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andTableCatalogEqualTo(String value) {
            addCriterion("TABLE_CATALOG =", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotEqualTo(String value) {
            addCriterion("TABLE_CATALOG <>", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogGreaterThan(String value) {
            addCriterion("TABLE_CATALOG >", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_CATALOG >=", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLessThan(String value) {
            addCriterion("TABLE_CATALOG <", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLessThanOrEqualTo(String value) {
            addCriterion("TABLE_CATALOG <=", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogLike(String value) {
            addCriterion("TABLE_CATALOG like", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotLike(String value) {
            addCriterion("TABLE_CATALOG not like", value, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogIn(List<String> values) {
            addCriterion("TABLE_CATALOG in", values, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotIn(List<String> values) {
            addCriterion("TABLE_CATALOG not in", values, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogBetween(String value1, String value2) {
            addCriterion("TABLE_CATALOG between", value1, value2, "tableCatalog");
            return (Criteria) this;
        }

        public Criteria andTableCatalogNotBetween(String value1, String value2) {
            addCriterion("TABLE_CATALOG not between", value1, value2, "tableCatalog");
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

        public Criteria andLogfileGroupNumberIsNull() {
            addCriterion("LOGFILE_GROUP_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberIsNotNull() {
            addCriterion("LOGFILE_GROUP_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberEqualTo(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER =", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberNotEqualTo(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER <>", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberGreaterThan(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER >", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER >=", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberLessThan(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER <", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberLessThanOrEqualTo(Long value) {
            addCriterion("LOGFILE_GROUP_NUMBER <=", value, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberIn(List<Long> values) {
            addCriterion("LOGFILE_GROUP_NUMBER in", values, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberNotIn(List<Long> values) {
            addCriterion("LOGFILE_GROUP_NUMBER not in", values, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberBetween(Long value1, Long value2) {
            addCriterion("LOGFILE_GROUP_NUMBER between", value1, value2, "logfileGroupNumber");
            return (Criteria) this;
        }

        public Criteria andLogfileGroupNumberNotBetween(Long value1, Long value2) {
            addCriterion("LOGFILE_GROUP_NUMBER not between", value1, value2, "logfileGroupNumber");
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

        public Criteria andFulltextKeysIsNull() {
            addCriterion("FULLTEXT_KEYS is null");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysIsNotNull() {
            addCriterion("FULLTEXT_KEYS is not null");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysEqualTo(String value) {
            addCriterion("FULLTEXT_KEYS =", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysNotEqualTo(String value) {
            addCriterion("FULLTEXT_KEYS <>", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysGreaterThan(String value) {
            addCriterion("FULLTEXT_KEYS >", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysGreaterThanOrEqualTo(String value) {
            addCriterion("FULLTEXT_KEYS >=", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysLessThan(String value) {
            addCriterion("FULLTEXT_KEYS <", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysLessThanOrEqualTo(String value) {
            addCriterion("FULLTEXT_KEYS <=", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysLike(String value) {
            addCriterion("FULLTEXT_KEYS like", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysNotLike(String value) {
            addCriterion("FULLTEXT_KEYS not like", value, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysIn(List<String> values) {
            addCriterion("FULLTEXT_KEYS in", values, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysNotIn(List<String> values) {
            addCriterion("FULLTEXT_KEYS not in", values, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysBetween(String value1, String value2) {
            addCriterion("FULLTEXT_KEYS between", value1, value2, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andFulltextKeysNotBetween(String value1, String value2) {
            addCriterion("FULLTEXT_KEYS not between", value1, value2, "fulltextKeys");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsIsNull() {
            addCriterion("DELETED_ROWS is null");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsIsNotNull() {
            addCriterion("DELETED_ROWS is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsEqualTo(Long value) {
            addCriterion("DELETED_ROWS =", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsNotEqualTo(Long value) {
            addCriterion("DELETED_ROWS <>", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsGreaterThan(Long value) {
            addCriterion("DELETED_ROWS >", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsGreaterThanOrEqualTo(Long value) {
            addCriterion("DELETED_ROWS >=", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsLessThan(Long value) {
            addCriterion("DELETED_ROWS <", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsLessThanOrEqualTo(Long value) {
            addCriterion("DELETED_ROWS <=", value, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsIn(List<Long> values) {
            addCriterion("DELETED_ROWS in", values, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsNotIn(List<Long> values) {
            addCriterion("DELETED_ROWS not in", values, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsBetween(Long value1, Long value2) {
            addCriterion("DELETED_ROWS between", value1, value2, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andDeletedRowsNotBetween(Long value1, Long value2) {
            addCriterion("DELETED_ROWS not between", value1, value2, "deletedRows");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIsNull() {
            addCriterion("UPDATE_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIsNotNull() {
            addCriterion("UPDATE_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateCountEqualTo(Long value) {
            addCriterion("UPDATE_COUNT =", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotEqualTo(Long value) {
            addCriterion("UPDATE_COUNT <>", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountGreaterThan(Long value) {
            addCriterion("UPDATE_COUNT >", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountGreaterThanOrEqualTo(Long value) {
            addCriterion("UPDATE_COUNT >=", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountLessThan(Long value) {
            addCriterion("UPDATE_COUNT <", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountLessThanOrEqualTo(Long value) {
            addCriterion("UPDATE_COUNT <=", value, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountIn(List<Long> values) {
            addCriterion("UPDATE_COUNT in", values, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotIn(List<Long> values) {
            addCriterion("UPDATE_COUNT not in", values, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountBetween(Long value1, Long value2) {
            addCriterion("UPDATE_COUNT between", value1, value2, "updateCount");
            return (Criteria) this;
        }

        public Criteria andUpdateCountNotBetween(Long value1, Long value2) {
            addCriterion("UPDATE_COUNT not between", value1, value2, "updateCount");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsIsNull() {
            addCriterion("FREE_EXTENTS is null");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsIsNotNull() {
            addCriterion("FREE_EXTENTS is not null");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsEqualTo(Long value) {
            addCriterion("FREE_EXTENTS =", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsNotEqualTo(Long value) {
            addCriterion("FREE_EXTENTS <>", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsGreaterThan(Long value) {
            addCriterion("FREE_EXTENTS >", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsGreaterThanOrEqualTo(Long value) {
            addCriterion("FREE_EXTENTS >=", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsLessThan(Long value) {
            addCriterion("FREE_EXTENTS <", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsLessThanOrEqualTo(Long value) {
            addCriterion("FREE_EXTENTS <=", value, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsIn(List<Long> values) {
            addCriterion("FREE_EXTENTS in", values, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsNotIn(List<Long> values) {
            addCriterion("FREE_EXTENTS not in", values, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsBetween(Long value1, Long value2) {
            addCriterion("FREE_EXTENTS between", value1, value2, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andFreeExtentsNotBetween(Long value1, Long value2) {
            addCriterion("FREE_EXTENTS not between", value1, value2, "freeExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsIsNull() {
            addCriterion("TOTAL_EXTENTS is null");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsIsNotNull() {
            addCriterion("TOTAL_EXTENTS is not null");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsEqualTo(Long value) {
            addCriterion("TOTAL_EXTENTS =", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsNotEqualTo(Long value) {
            addCriterion("TOTAL_EXTENTS <>", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsGreaterThan(Long value) {
            addCriterion("TOTAL_EXTENTS >", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsGreaterThanOrEqualTo(Long value) {
            addCriterion("TOTAL_EXTENTS >=", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsLessThan(Long value) {
            addCriterion("TOTAL_EXTENTS <", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsLessThanOrEqualTo(Long value) {
            addCriterion("TOTAL_EXTENTS <=", value, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsIn(List<Long> values) {
            addCriterion("TOTAL_EXTENTS in", values, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsNotIn(List<Long> values) {
            addCriterion("TOTAL_EXTENTS not in", values, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsBetween(Long value1, Long value2) {
            addCriterion("TOTAL_EXTENTS between", value1, value2, "totalExtents");
            return (Criteria) this;
        }

        public Criteria andTotalExtentsNotBetween(Long value1, Long value2) {
            addCriterion("TOTAL_EXTENTS not between", value1, value2, "totalExtents");
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

        public Criteria andInitialSizeIsNull() {
            addCriterion("INITIAL_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andInitialSizeIsNotNull() {
            addCriterion("INITIAL_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andInitialSizeEqualTo(Long value) {
            addCriterion("INITIAL_SIZE =", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotEqualTo(Long value) {
            addCriterion("INITIAL_SIZE <>", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeGreaterThan(Long value) {
            addCriterion("INITIAL_SIZE >", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("INITIAL_SIZE >=", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeLessThan(Long value) {
            addCriterion("INITIAL_SIZE <", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeLessThanOrEqualTo(Long value) {
            addCriterion("INITIAL_SIZE <=", value, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeIn(List<Long> values) {
            addCriterion("INITIAL_SIZE in", values, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotIn(List<Long> values) {
            addCriterion("INITIAL_SIZE not in", values, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeBetween(Long value1, Long value2) {
            addCriterion("INITIAL_SIZE between", value1, value2, "initialSize");
            return (Criteria) this;
        }

        public Criteria andInitialSizeNotBetween(Long value1, Long value2) {
            addCriterion("INITIAL_SIZE not between", value1, value2, "initialSize");
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

        public Criteria andCreationTimeIsNull() {
            addCriterion("CREATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIsNotNull() {
            addCriterion("CREATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreationTimeEqualTo(Date value) {
            addCriterion("CREATION_TIME =", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotEqualTo(Date value) {
            addCriterion("CREATION_TIME <>", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThan(Date value) {
            addCriterion("CREATION_TIME >", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATION_TIME >=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThan(Date value) {
            addCriterion("CREATION_TIME <", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATION_TIME <=", value, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeIn(List<Date> values) {
            addCriterion("CREATION_TIME in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotIn(List<Date> values) {
            addCriterion("CREATION_TIME not in", values, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeBetween(Date value1, Date value2) {
            addCriterion("CREATION_TIME between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andCreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATION_TIME not between", value1, value2, "creationTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("LAST_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("LAST_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("LAST_UPDATE_TIME >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("LAST_UPDATE_TIME <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_UPDATE_TIME <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("LAST_UPDATE_TIME not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_UPDATE_TIME not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNull() {
            addCriterion("LAST_ACCESS_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNotNull() {
            addCriterion("LAST_ACCESS_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeEqualTo(Date value) {
            addCriterion("LAST_ACCESS_TIME =", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotEqualTo(Date value) {
            addCriterion("LAST_ACCESS_TIME <>", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThan(Date value) {
            addCriterion("LAST_ACCESS_TIME >", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_ACCESS_TIME >=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThan(Date value) {
            addCriterion("LAST_ACCESS_TIME <", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_ACCESS_TIME <=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIn(List<Date> values) {
            addCriterion("LAST_ACCESS_TIME in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotIn(List<Date> values) {
            addCriterion("LAST_ACCESS_TIME not in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_ACCESS_TIME between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_ACCESS_TIME not between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIsNull() {
            addCriterion("RECOVER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIsNotNull() {
            addCriterion("RECOVER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeEqualTo(Long value) {
            addCriterion("RECOVER_TIME =", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotEqualTo(Long value) {
            addCriterion("RECOVER_TIME <>", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeGreaterThan(Long value) {
            addCriterion("RECOVER_TIME >", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("RECOVER_TIME >=", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeLessThan(Long value) {
            addCriterion("RECOVER_TIME <", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeLessThanOrEqualTo(Long value) {
            addCriterion("RECOVER_TIME <=", value, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeIn(List<Long> values) {
            addCriterion("RECOVER_TIME in", values, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotIn(List<Long> values) {
            addCriterion("RECOVER_TIME not in", values, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeBetween(Long value1, Long value2) {
            addCriterion("RECOVER_TIME between", value1, value2, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andRecoverTimeNotBetween(Long value1, Long value2) {
            addCriterion("RECOVER_TIME not between", value1, value2, "recoverTime");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterIsNull() {
            addCriterion("TRANSACTION_COUNTER is null");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterIsNotNull() {
            addCriterion("TRANSACTION_COUNTER is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterEqualTo(Long value) {
            addCriterion("TRANSACTION_COUNTER =", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterNotEqualTo(Long value) {
            addCriterion("TRANSACTION_COUNTER <>", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterGreaterThan(Long value) {
            addCriterion("TRANSACTION_COUNTER >", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterGreaterThanOrEqualTo(Long value) {
            addCriterion("TRANSACTION_COUNTER >=", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterLessThan(Long value) {
            addCriterion("TRANSACTION_COUNTER <", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterLessThanOrEqualTo(Long value) {
            addCriterion("TRANSACTION_COUNTER <=", value, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterIn(List<Long> values) {
            addCriterion("TRANSACTION_COUNTER in", values, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterNotIn(List<Long> values) {
            addCriterion("TRANSACTION_COUNTER not in", values, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterBetween(Long value1, Long value2) {
            addCriterion("TRANSACTION_COUNTER between", value1, value2, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andTransactionCounterNotBetween(Long value1, Long value2) {
            addCriterion("TRANSACTION_COUNTER not between", value1, value2, "transactionCounter");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andRowFormatIsNull() {
            addCriterion("ROW_FORMAT is null");
            return (Criteria) this;
        }

        public Criteria andRowFormatIsNotNull() {
            addCriterion("ROW_FORMAT is not null");
            return (Criteria) this;
        }

        public Criteria andRowFormatEqualTo(String value) {
            addCriterion("ROW_FORMAT =", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatNotEqualTo(String value) {
            addCriterion("ROW_FORMAT <>", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatGreaterThan(String value) {
            addCriterion("ROW_FORMAT >", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatGreaterThanOrEqualTo(String value) {
            addCriterion("ROW_FORMAT >=", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatLessThan(String value) {
            addCriterion("ROW_FORMAT <", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatLessThanOrEqualTo(String value) {
            addCriterion("ROW_FORMAT <=", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatLike(String value) {
            addCriterion("ROW_FORMAT like", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatNotLike(String value) {
            addCriterion("ROW_FORMAT not like", value, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatIn(List<String> values) {
            addCriterion("ROW_FORMAT in", values, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatNotIn(List<String> values) {
            addCriterion("ROW_FORMAT not in", values, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatBetween(String value1, String value2) {
            addCriterion("ROW_FORMAT between", value1, value2, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andRowFormatNotBetween(String value1, String value2) {
            addCriterion("ROW_FORMAT not between", value1, value2, "rowFormat");
            return (Criteria) this;
        }

        public Criteria andTableRowsIsNull() {
            addCriterion("TABLE_ROWS is null");
            return (Criteria) this;
        }

        public Criteria andTableRowsIsNotNull() {
            addCriterion("TABLE_ROWS is not null");
            return (Criteria) this;
        }

        public Criteria andTableRowsEqualTo(Long value) {
            addCriterion("TABLE_ROWS =", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotEqualTo(Long value) {
            addCriterion("TABLE_ROWS <>", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsGreaterThan(Long value) {
            addCriterion("TABLE_ROWS >", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsGreaterThanOrEqualTo(Long value) {
            addCriterion("TABLE_ROWS >=", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsLessThan(Long value) {
            addCriterion("TABLE_ROWS <", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsLessThanOrEqualTo(Long value) {
            addCriterion("TABLE_ROWS <=", value, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsIn(List<Long> values) {
            addCriterion("TABLE_ROWS in", values, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotIn(List<Long> values) {
            addCriterion("TABLE_ROWS not in", values, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsBetween(Long value1, Long value2) {
            addCriterion("TABLE_ROWS between", value1, value2, "tableRows");
            return (Criteria) this;
        }

        public Criteria andTableRowsNotBetween(Long value1, Long value2) {
            addCriterion("TABLE_ROWS not between", value1, value2, "tableRows");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthIsNull() {
            addCriterion("AVG_ROW_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthIsNotNull() {
            addCriterion("AVG_ROW_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthEqualTo(Long value) {
            addCriterion("AVG_ROW_LENGTH =", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthNotEqualTo(Long value) {
            addCriterion("AVG_ROW_LENGTH <>", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthGreaterThan(Long value) {
            addCriterion("AVG_ROW_LENGTH >", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("AVG_ROW_LENGTH >=", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthLessThan(Long value) {
            addCriterion("AVG_ROW_LENGTH <", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthLessThanOrEqualTo(Long value) {
            addCriterion("AVG_ROW_LENGTH <=", value, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthIn(List<Long> values) {
            addCriterion("AVG_ROW_LENGTH in", values, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthNotIn(List<Long> values) {
            addCriterion("AVG_ROW_LENGTH not in", values, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthBetween(Long value1, Long value2) {
            addCriterion("AVG_ROW_LENGTH between", value1, value2, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andAvgRowLengthNotBetween(Long value1, Long value2) {
            addCriterion("AVG_ROW_LENGTH not between", value1, value2, "avgRowLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthIsNull() {
            addCriterion("DATA_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andDataLengthIsNotNull() {
            addCriterion("DATA_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andDataLengthEqualTo(Long value) {
            addCriterion("DATA_LENGTH =", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthNotEqualTo(Long value) {
            addCriterion("DATA_LENGTH <>", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthGreaterThan(Long value) {
            addCriterion("DATA_LENGTH >", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_LENGTH >=", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthLessThan(Long value) {
            addCriterion("DATA_LENGTH <", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthLessThanOrEqualTo(Long value) {
            addCriterion("DATA_LENGTH <=", value, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthIn(List<Long> values) {
            addCriterion("DATA_LENGTH in", values, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthNotIn(List<Long> values) {
            addCriterion("DATA_LENGTH not in", values, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthBetween(Long value1, Long value2) {
            addCriterion("DATA_LENGTH between", value1, value2, "dataLength");
            return (Criteria) this;
        }

        public Criteria andDataLengthNotBetween(Long value1, Long value2) {
            addCriterion("DATA_LENGTH not between", value1, value2, "dataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthIsNull() {
            addCriterion("MAX_DATA_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthIsNotNull() {
            addCriterion("MAX_DATA_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthEqualTo(Long value) {
            addCriterion("MAX_DATA_LENGTH =", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthNotEqualTo(Long value) {
            addCriterion("MAX_DATA_LENGTH <>", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthGreaterThan(Long value) {
            addCriterion("MAX_DATA_LENGTH >", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("MAX_DATA_LENGTH >=", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthLessThan(Long value) {
            addCriterion("MAX_DATA_LENGTH <", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthLessThanOrEqualTo(Long value) {
            addCriterion("MAX_DATA_LENGTH <=", value, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthIn(List<Long> values) {
            addCriterion("MAX_DATA_LENGTH in", values, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthNotIn(List<Long> values) {
            addCriterion("MAX_DATA_LENGTH not in", values, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthBetween(Long value1, Long value2) {
            addCriterion("MAX_DATA_LENGTH between", value1, value2, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andMaxDataLengthNotBetween(Long value1, Long value2) {
            addCriterion("MAX_DATA_LENGTH not between", value1, value2, "maxDataLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthIsNull() {
            addCriterion("INDEX_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andIndexLengthIsNotNull() {
            addCriterion("INDEX_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andIndexLengthEqualTo(Long value) {
            addCriterion("INDEX_LENGTH =", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthNotEqualTo(Long value) {
            addCriterion("INDEX_LENGTH <>", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthGreaterThan(Long value) {
            addCriterion("INDEX_LENGTH >", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthGreaterThanOrEqualTo(Long value) {
            addCriterion("INDEX_LENGTH >=", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthLessThan(Long value) {
            addCriterion("INDEX_LENGTH <", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthLessThanOrEqualTo(Long value) {
            addCriterion("INDEX_LENGTH <=", value, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthIn(List<Long> values) {
            addCriterion("INDEX_LENGTH in", values, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthNotIn(List<Long> values) {
            addCriterion("INDEX_LENGTH not in", values, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthBetween(Long value1, Long value2) {
            addCriterion("INDEX_LENGTH between", value1, value2, "indexLength");
            return (Criteria) this;
        }

        public Criteria andIndexLengthNotBetween(Long value1, Long value2) {
            addCriterion("INDEX_LENGTH not between", value1, value2, "indexLength");
            return (Criteria) this;
        }

        public Criteria andDataFreeIsNull() {
            addCriterion("DATA_FREE is null");
            return (Criteria) this;
        }

        public Criteria andDataFreeIsNotNull() {
            addCriterion("DATA_FREE is not null");
            return (Criteria) this;
        }

        public Criteria andDataFreeEqualTo(Long value) {
            addCriterion("DATA_FREE =", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeNotEqualTo(Long value) {
            addCriterion("DATA_FREE <>", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeGreaterThan(Long value) {
            addCriterion("DATA_FREE >", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeGreaterThanOrEqualTo(Long value) {
            addCriterion("DATA_FREE >=", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeLessThan(Long value) {
            addCriterion("DATA_FREE <", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeLessThanOrEqualTo(Long value) {
            addCriterion("DATA_FREE <=", value, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeIn(List<Long> values) {
            addCriterion("DATA_FREE in", values, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeNotIn(List<Long> values) {
            addCriterion("DATA_FREE not in", values, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeBetween(Long value1, Long value2) {
            addCriterion("DATA_FREE between", value1, value2, "dataFree");
            return (Criteria) this;
        }

        public Criteria andDataFreeNotBetween(Long value1, Long value2) {
            addCriterion("DATA_FREE not between", value1, value2, "dataFree");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("CHECK_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("CHECK_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("CHECK_TIME =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("CHECK_TIME <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("CHECK_TIME >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("CHECK_TIME <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_TIME <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("CHECK_TIME in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("CHECK_TIME not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_TIME not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNull() {
            addCriterion("CHECKSUM is null");
            return (Criteria) this;
        }

        public Criteria andChecksumIsNotNull() {
            addCriterion("CHECKSUM is not null");
            return (Criteria) this;
        }

        public Criteria andChecksumEqualTo(Long value) {
            addCriterion("CHECKSUM =", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotEqualTo(Long value) {
            addCriterion("CHECKSUM <>", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThan(Long value) {
            addCriterion("CHECKSUM >", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumGreaterThanOrEqualTo(Long value) {
            addCriterion("CHECKSUM >=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThan(Long value) {
            addCriterion("CHECKSUM <", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumLessThanOrEqualTo(Long value) {
            addCriterion("CHECKSUM <=", value, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumIn(List<Long> values) {
            addCriterion("CHECKSUM in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotIn(List<Long> values) {
            addCriterion("CHECKSUM not in", values, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumBetween(Long value1, Long value2) {
            addCriterion("CHECKSUM between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andChecksumNotBetween(Long value1, Long value2) {
            addCriterion("CHECKSUM not between", value1, value2, "checksum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExtraIsNull() {
            addCriterion("EXTRA is null");
            return (Criteria) this;
        }

        public Criteria andExtraIsNotNull() {
            addCriterion("EXTRA is not null");
            return (Criteria) this;
        }

        public Criteria andExtraEqualTo(String value) {
            addCriterion("EXTRA =", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraNotEqualTo(String value) {
            addCriterion("EXTRA <>", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraGreaterThan(String value) {
            addCriterion("EXTRA >", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraGreaterThanOrEqualTo(String value) {
            addCriterion("EXTRA >=", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraLessThan(String value) {
            addCriterion("EXTRA <", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraLessThanOrEqualTo(String value) {
            addCriterion("EXTRA <=", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraLike(String value) {
            addCriterion("EXTRA like", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraNotLike(String value) {
            addCriterion("EXTRA not like", value, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraIn(List<String> values) {
            addCriterion("EXTRA in", values, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraNotIn(List<String> values) {
            addCriterion("EXTRA not in", values, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraBetween(String value1, String value2) {
            addCriterion("EXTRA between", value1, value2, "extra");
            return (Criteria) this;
        }

        public Criteria andExtraNotBetween(String value1, String value2) {
            addCriterion("EXTRA not between", value1, value2, "extra");
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