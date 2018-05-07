package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class STATISTICSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public STATISTICSExample() {
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

        public Criteria andNonUniqueIsNull() {
            addCriterion("NON_UNIQUE is null");
            return (Criteria) this;
        }

        public Criteria andNonUniqueIsNotNull() {
            addCriterion("NON_UNIQUE is not null");
            return (Criteria) this;
        }

        public Criteria andNonUniqueEqualTo(Long value) {
            addCriterion("NON_UNIQUE =", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueNotEqualTo(Long value) {
            addCriterion("NON_UNIQUE <>", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueGreaterThan(Long value) {
            addCriterion("NON_UNIQUE >", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueGreaterThanOrEqualTo(Long value) {
            addCriterion("NON_UNIQUE >=", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueLessThan(Long value) {
            addCriterion("NON_UNIQUE <", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueLessThanOrEqualTo(Long value) {
            addCriterion("NON_UNIQUE <=", value, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueIn(List<Long> values) {
            addCriterion("NON_UNIQUE in", values, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueNotIn(List<Long> values) {
            addCriterion("NON_UNIQUE not in", values, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueBetween(Long value1, Long value2) {
            addCriterion("NON_UNIQUE between", value1, value2, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andNonUniqueNotBetween(Long value1, Long value2) {
            addCriterion("NON_UNIQUE not between", value1, value2, "nonUnique");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaIsNull() {
            addCriterion("INDEX_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaIsNotNull() {
            addCriterion("INDEX_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaEqualTo(String value) {
            addCriterion("INDEX_SCHEMA =", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaNotEqualTo(String value) {
            addCriterion("INDEX_SCHEMA <>", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaGreaterThan(String value) {
            addCriterion("INDEX_SCHEMA >", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_SCHEMA >=", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaLessThan(String value) {
            addCriterion("INDEX_SCHEMA <", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaLessThanOrEqualTo(String value) {
            addCriterion("INDEX_SCHEMA <=", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaLike(String value) {
            addCriterion("INDEX_SCHEMA like", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaNotLike(String value) {
            addCriterion("INDEX_SCHEMA not like", value, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaIn(List<String> values) {
            addCriterion("INDEX_SCHEMA in", values, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaNotIn(List<String> values) {
            addCriterion("INDEX_SCHEMA not in", values, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaBetween(String value1, String value2) {
            addCriterion("INDEX_SCHEMA between", value1, value2, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexSchemaNotBetween(String value1, String value2) {
            addCriterion("INDEX_SCHEMA not between", value1, value2, "indexSchema");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNull() {
            addCriterion("INDEX_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIndexNameIsNotNull() {
            addCriterion("INDEX_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndexNameEqualTo(String value) {
            addCriterion("INDEX_NAME =", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotEqualTo(String value) {
            addCriterion("INDEX_NAME <>", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThan(String value) {
            addCriterion("INDEX_NAME >", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_NAME >=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThan(String value) {
            addCriterion("INDEX_NAME <", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLessThanOrEqualTo(String value) {
            addCriterion("INDEX_NAME <=", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameLike(String value) {
            addCriterion("INDEX_NAME like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotLike(String value) {
            addCriterion("INDEX_NAME not like", value, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameIn(List<String> values) {
            addCriterion("INDEX_NAME in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotIn(List<String> values) {
            addCriterion("INDEX_NAME not in", values, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameBetween(String value1, String value2) {
            addCriterion("INDEX_NAME between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andIndexNameNotBetween(String value1, String value2) {
            addCriterion("INDEX_NAME not between", value1, value2, "indexName");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexIsNull() {
            addCriterion("SEQ_IN_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexIsNotNull() {
            addCriterion("SEQ_IN_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexEqualTo(Long value) {
            addCriterion("SEQ_IN_INDEX =", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexNotEqualTo(Long value) {
            addCriterion("SEQ_IN_INDEX <>", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexGreaterThan(Long value) {
            addCriterion("SEQ_IN_INDEX >", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexGreaterThanOrEqualTo(Long value) {
            addCriterion("SEQ_IN_INDEX >=", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexLessThan(Long value) {
            addCriterion("SEQ_IN_INDEX <", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexLessThanOrEqualTo(Long value) {
            addCriterion("SEQ_IN_INDEX <=", value, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexIn(List<Long> values) {
            addCriterion("SEQ_IN_INDEX in", values, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexNotIn(List<Long> values) {
            addCriterion("SEQ_IN_INDEX not in", values, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexBetween(Long value1, Long value2) {
            addCriterion("SEQ_IN_INDEX between", value1, value2, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andSeqInIndexNotBetween(Long value1, Long value2) {
            addCriterion("SEQ_IN_INDEX not between", value1, value2, "seqInIndex");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNull() {
            addCriterion("COLUMN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andColumnNameIsNotNull() {
            addCriterion("COLUMN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andColumnNameEqualTo(String value) {
            addCriterion("COLUMN_NAME =", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotEqualTo(String value) {
            addCriterion("COLUMN_NAME <>", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThan(String value) {
            addCriterion("COLUMN_NAME >", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME >=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThan(String value) {
            addCriterion("COLUMN_NAME <", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLessThanOrEqualTo(String value) {
            addCriterion("COLUMN_NAME <=", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameLike(String value) {
            addCriterion("COLUMN_NAME like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotLike(String value) {
            addCriterion("COLUMN_NAME not like", value, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameIn(List<String> values) {
            addCriterion("COLUMN_NAME in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotIn(List<String> values) {
            addCriterion("COLUMN_NAME not in", values, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andColumnNameNotBetween(String value1, String value2) {
            addCriterion("COLUMN_NAME not between", value1, value2, "columnName");
            return (Criteria) this;
        }

        public Criteria andCollationIsNull() {
            addCriterion("COLLATION is null");
            return (Criteria) this;
        }

        public Criteria andCollationIsNotNull() {
            addCriterion("COLLATION is not null");
            return (Criteria) this;
        }

        public Criteria andCollationEqualTo(String value) {
            addCriterion("COLLATION =", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationNotEqualTo(String value) {
            addCriterion("COLLATION <>", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationGreaterThan(String value) {
            addCriterion("COLLATION >", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationGreaterThanOrEqualTo(String value) {
            addCriterion("COLLATION >=", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationLessThan(String value) {
            addCriterion("COLLATION <", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationLessThanOrEqualTo(String value) {
            addCriterion("COLLATION <=", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationLike(String value) {
            addCriterion("COLLATION like", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationNotLike(String value) {
            addCriterion("COLLATION not like", value, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationIn(List<String> values) {
            addCriterion("COLLATION in", values, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationNotIn(List<String> values) {
            addCriterion("COLLATION not in", values, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationBetween(String value1, String value2) {
            addCriterion("COLLATION between", value1, value2, "collation");
            return (Criteria) this;
        }

        public Criteria andCollationNotBetween(String value1, String value2) {
            addCriterion("COLLATION not between", value1, value2, "collation");
            return (Criteria) this;
        }

        public Criteria andCardinalityIsNull() {
            addCriterion("CARDINALITY is null");
            return (Criteria) this;
        }

        public Criteria andCardinalityIsNotNull() {
            addCriterion("CARDINALITY is not null");
            return (Criteria) this;
        }

        public Criteria andCardinalityEqualTo(Long value) {
            addCriterion("CARDINALITY =", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityNotEqualTo(Long value) {
            addCriterion("CARDINALITY <>", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityGreaterThan(Long value) {
            addCriterion("CARDINALITY >", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityGreaterThanOrEqualTo(Long value) {
            addCriterion("CARDINALITY >=", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityLessThan(Long value) {
            addCriterion("CARDINALITY <", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityLessThanOrEqualTo(Long value) {
            addCriterion("CARDINALITY <=", value, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityIn(List<Long> values) {
            addCriterion("CARDINALITY in", values, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityNotIn(List<Long> values) {
            addCriterion("CARDINALITY not in", values, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityBetween(Long value1, Long value2) {
            addCriterion("CARDINALITY between", value1, value2, "cardinality");
            return (Criteria) this;
        }

        public Criteria andCardinalityNotBetween(Long value1, Long value2) {
            addCriterion("CARDINALITY not between", value1, value2, "cardinality");
            return (Criteria) this;
        }

        public Criteria andSubPartIsNull() {
            addCriterion("SUB_PART is null");
            return (Criteria) this;
        }

        public Criteria andSubPartIsNotNull() {
            addCriterion("SUB_PART is not null");
            return (Criteria) this;
        }

        public Criteria andSubPartEqualTo(Long value) {
            addCriterion("SUB_PART =", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartNotEqualTo(Long value) {
            addCriterion("SUB_PART <>", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartGreaterThan(Long value) {
            addCriterion("SUB_PART >", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartGreaterThanOrEqualTo(Long value) {
            addCriterion("SUB_PART >=", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartLessThan(Long value) {
            addCriterion("SUB_PART <", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartLessThanOrEqualTo(Long value) {
            addCriterion("SUB_PART <=", value, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartIn(List<Long> values) {
            addCriterion("SUB_PART in", values, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartNotIn(List<Long> values) {
            addCriterion("SUB_PART not in", values, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartBetween(Long value1, Long value2) {
            addCriterion("SUB_PART between", value1, value2, "subPart");
            return (Criteria) this;
        }

        public Criteria andSubPartNotBetween(Long value1, Long value2) {
            addCriterion("SUB_PART not between", value1, value2, "subPart");
            return (Criteria) this;
        }

        public Criteria andPackedIsNull() {
            addCriterion("PACKED is null");
            return (Criteria) this;
        }

        public Criteria andPackedIsNotNull() {
            addCriterion("PACKED is not null");
            return (Criteria) this;
        }

        public Criteria andPackedEqualTo(String value) {
            addCriterion("PACKED =", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedNotEqualTo(String value) {
            addCriterion("PACKED <>", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedGreaterThan(String value) {
            addCriterion("PACKED >", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedGreaterThanOrEqualTo(String value) {
            addCriterion("PACKED >=", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedLessThan(String value) {
            addCriterion("PACKED <", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedLessThanOrEqualTo(String value) {
            addCriterion("PACKED <=", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedLike(String value) {
            addCriterion("PACKED like", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedNotLike(String value) {
            addCriterion("PACKED not like", value, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedIn(List<String> values) {
            addCriterion("PACKED in", values, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedNotIn(List<String> values) {
            addCriterion("PACKED not in", values, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedBetween(String value1, String value2) {
            addCriterion("PACKED between", value1, value2, "packed");
            return (Criteria) this;
        }

        public Criteria andPackedNotBetween(String value1, String value2) {
            addCriterion("PACKED not between", value1, value2, "packed");
            return (Criteria) this;
        }

        public Criteria andNullableIsNull() {
            addCriterion("NULLABLE is null");
            return (Criteria) this;
        }

        public Criteria andNullableIsNotNull() {
            addCriterion("NULLABLE is not null");
            return (Criteria) this;
        }

        public Criteria andNullableEqualTo(String value) {
            addCriterion("NULLABLE =", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableNotEqualTo(String value) {
            addCriterion("NULLABLE <>", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableGreaterThan(String value) {
            addCriterion("NULLABLE >", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableGreaterThanOrEqualTo(String value) {
            addCriterion("NULLABLE >=", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableLessThan(String value) {
            addCriterion("NULLABLE <", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableLessThanOrEqualTo(String value) {
            addCriterion("NULLABLE <=", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableLike(String value) {
            addCriterion("NULLABLE like", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableNotLike(String value) {
            addCriterion("NULLABLE not like", value, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableIn(List<String> values) {
            addCriterion("NULLABLE in", values, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableNotIn(List<String> values) {
            addCriterion("NULLABLE not in", values, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableBetween(String value1, String value2) {
            addCriterion("NULLABLE between", value1, value2, "nullable");
            return (Criteria) this;
        }

        public Criteria andNullableNotBetween(String value1, String value2) {
            addCriterion("NULLABLE not between", value1, value2, "nullable");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIsNull() {
            addCriterion("INDEX_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIsNotNull() {
            addCriterion("INDEX_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andIndexTypeEqualTo(String value) {
            addCriterion("INDEX_TYPE =", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotEqualTo(String value) {
            addCriterion("INDEX_TYPE <>", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeGreaterThan(String value) {
            addCriterion("INDEX_TYPE >", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_TYPE >=", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLessThan(String value) {
            addCriterion("INDEX_TYPE <", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLessThanOrEqualTo(String value) {
            addCriterion("INDEX_TYPE <=", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeLike(String value) {
            addCriterion("INDEX_TYPE like", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotLike(String value) {
            addCriterion("INDEX_TYPE not like", value, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeIn(List<String> values) {
            addCriterion("INDEX_TYPE in", values, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotIn(List<String> values) {
            addCriterion("INDEX_TYPE not in", values, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeBetween(String value1, String value2) {
            addCriterion("INDEX_TYPE between", value1, value2, "indexType");
            return (Criteria) this;
        }

        public Criteria andIndexTypeNotBetween(String value1, String value2) {
            addCriterion("INDEX_TYPE not between", value1, value2, "indexType");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("COMMENT =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("COMMENT <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("COMMENT >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("COMMENT >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("COMMENT <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("COMMENT <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("COMMENT like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("COMMENT not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("COMMENT in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("COMMENT not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("COMMENT between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("COMMENT not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentIsNull() {
            addCriterion("INDEX_COMMENT is null");
            return (Criteria) this;
        }

        public Criteria andIndexCommentIsNotNull() {
            addCriterion("INDEX_COMMENT is not null");
            return (Criteria) this;
        }

        public Criteria andIndexCommentEqualTo(String value) {
            addCriterion("INDEX_COMMENT =", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentNotEqualTo(String value) {
            addCriterion("INDEX_COMMENT <>", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentGreaterThan(String value) {
            addCriterion("INDEX_COMMENT >", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentGreaterThanOrEqualTo(String value) {
            addCriterion("INDEX_COMMENT >=", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentLessThan(String value) {
            addCriterion("INDEX_COMMENT <", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentLessThanOrEqualTo(String value) {
            addCriterion("INDEX_COMMENT <=", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentLike(String value) {
            addCriterion("INDEX_COMMENT like", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentNotLike(String value) {
            addCriterion("INDEX_COMMENT not like", value, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentIn(List<String> values) {
            addCriterion("INDEX_COMMENT in", values, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentNotIn(List<String> values) {
            addCriterion("INDEX_COMMENT not in", values, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentBetween(String value1, String value2) {
            addCriterion("INDEX_COMMENT between", value1, value2, "indexComment");
            return (Criteria) this;
        }

        public Criteria andIndexCommentNotBetween(String value1, String value2) {
            addCriterion("INDEX_COMMENT not between", value1, value2, "indexComment");
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