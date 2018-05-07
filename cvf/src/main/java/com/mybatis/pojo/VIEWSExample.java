package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class VIEWSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VIEWSExample() {
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

        public Criteria andCheckOptionIsNull() {
            addCriterion("CHECK_OPTION is null");
            return (Criteria) this;
        }

        public Criteria andCheckOptionIsNotNull() {
            addCriterion("CHECK_OPTION is not null");
            return (Criteria) this;
        }

        public Criteria andCheckOptionEqualTo(String value) {
            addCriterion("CHECK_OPTION =", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionNotEqualTo(String value) {
            addCriterion("CHECK_OPTION <>", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionGreaterThan(String value) {
            addCriterion("CHECK_OPTION >", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_OPTION >=", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionLessThan(String value) {
            addCriterion("CHECK_OPTION <", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionLessThanOrEqualTo(String value) {
            addCriterion("CHECK_OPTION <=", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionLike(String value) {
            addCriterion("CHECK_OPTION like", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionNotLike(String value) {
            addCriterion("CHECK_OPTION not like", value, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionIn(List<String> values) {
            addCriterion("CHECK_OPTION in", values, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionNotIn(List<String> values) {
            addCriterion("CHECK_OPTION not in", values, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionBetween(String value1, String value2) {
            addCriterion("CHECK_OPTION between", value1, value2, "checkOption");
            return (Criteria) this;
        }

        public Criteria andCheckOptionNotBetween(String value1, String value2) {
            addCriterion("CHECK_OPTION not between", value1, value2, "checkOption");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableIsNull() {
            addCriterion("IS_UPDATABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableIsNotNull() {
            addCriterion("IS_UPDATABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableEqualTo(String value) {
            addCriterion("IS_UPDATABLE =", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableNotEqualTo(String value) {
            addCriterion("IS_UPDATABLE <>", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableGreaterThan(String value) {
            addCriterion("IS_UPDATABLE >", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableGreaterThanOrEqualTo(String value) {
            addCriterion("IS_UPDATABLE >=", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableLessThan(String value) {
            addCriterion("IS_UPDATABLE <", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableLessThanOrEqualTo(String value) {
            addCriterion("IS_UPDATABLE <=", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableLike(String value) {
            addCriterion("IS_UPDATABLE like", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableNotLike(String value) {
            addCriterion("IS_UPDATABLE not like", value, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableIn(List<String> values) {
            addCriterion("IS_UPDATABLE in", values, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableNotIn(List<String> values) {
            addCriterion("IS_UPDATABLE not in", values, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableBetween(String value1, String value2) {
            addCriterion("IS_UPDATABLE between", value1, value2, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andIsUpdatableNotBetween(String value1, String value2) {
            addCriterion("IS_UPDATABLE not between", value1, value2, "isUpdatable");
            return (Criteria) this;
        }

        public Criteria andDefinerIsNull() {
            addCriterion("DEFINER is null");
            return (Criteria) this;
        }

        public Criteria andDefinerIsNotNull() {
            addCriterion("DEFINER is not null");
            return (Criteria) this;
        }

        public Criteria andDefinerEqualTo(String value) {
            addCriterion("DEFINER =", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotEqualTo(String value) {
            addCriterion("DEFINER <>", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerGreaterThan(String value) {
            addCriterion("DEFINER >", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerGreaterThanOrEqualTo(String value) {
            addCriterion("DEFINER >=", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLessThan(String value) {
            addCriterion("DEFINER <", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLessThanOrEqualTo(String value) {
            addCriterion("DEFINER <=", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerLike(String value) {
            addCriterion("DEFINER like", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotLike(String value) {
            addCriterion("DEFINER not like", value, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerIn(List<String> values) {
            addCriterion("DEFINER in", values, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotIn(List<String> values) {
            addCriterion("DEFINER not in", values, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerBetween(String value1, String value2) {
            addCriterion("DEFINER between", value1, value2, "definer");
            return (Criteria) this;
        }

        public Criteria andDefinerNotBetween(String value1, String value2) {
            addCriterion("DEFINER not between", value1, value2, "definer");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIsNull() {
            addCriterion("SECURITY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIsNotNull() {
            addCriterion("SECURITY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeEqualTo(String value) {
            addCriterion("SECURITY_TYPE =", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotEqualTo(String value) {
            addCriterion("SECURITY_TYPE <>", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeGreaterThan(String value) {
            addCriterion("SECURITY_TYPE >", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SECURITY_TYPE >=", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLessThan(String value) {
            addCriterion("SECURITY_TYPE <", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLessThanOrEqualTo(String value) {
            addCriterion("SECURITY_TYPE <=", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeLike(String value) {
            addCriterion("SECURITY_TYPE like", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotLike(String value) {
            addCriterion("SECURITY_TYPE not like", value, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeIn(List<String> values) {
            addCriterion("SECURITY_TYPE in", values, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotIn(List<String> values) {
            addCriterion("SECURITY_TYPE not in", values, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeBetween(String value1, String value2) {
            addCriterion("SECURITY_TYPE between", value1, value2, "securityType");
            return (Criteria) this;
        }

        public Criteria andSecurityTypeNotBetween(String value1, String value2) {
            addCriterion("SECURITY_TYPE not between", value1, value2, "securityType");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientIsNull() {
            addCriterion("CHARACTER_SET_CLIENT is null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientIsNotNull() {
            addCriterion("CHARACTER_SET_CLIENT is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientEqualTo(String value) {
            addCriterion("CHARACTER_SET_CLIENT =", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientNotEqualTo(String value) {
            addCriterion("CHARACTER_SET_CLIENT <>", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientGreaterThan(String value) {
            addCriterion("CHARACTER_SET_CLIENT >", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientGreaterThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_CLIENT >=", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientLessThan(String value) {
            addCriterion("CHARACTER_SET_CLIENT <", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientLessThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_CLIENT <=", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientLike(String value) {
            addCriterion("CHARACTER_SET_CLIENT like", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientNotLike(String value) {
            addCriterion("CHARACTER_SET_CLIENT not like", value, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientIn(List<String> values) {
            addCriterion("CHARACTER_SET_CLIENT in", values, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientNotIn(List<String> values) {
            addCriterion("CHARACTER_SET_CLIENT not in", values, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_CLIENT between", value1, value2, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCharacterSetClientNotBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_CLIENT not between", value1, value2, "characterSetClient");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionIsNull() {
            addCriterion("COLLATION_CONNECTION is null");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionIsNotNull() {
            addCriterion("COLLATION_CONNECTION is not null");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionEqualTo(String value) {
            addCriterion("COLLATION_CONNECTION =", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionNotEqualTo(String value) {
            addCriterion("COLLATION_CONNECTION <>", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionGreaterThan(String value) {
            addCriterion("COLLATION_CONNECTION >", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionGreaterThanOrEqualTo(String value) {
            addCriterion("COLLATION_CONNECTION >=", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionLessThan(String value) {
            addCriterion("COLLATION_CONNECTION <", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionLessThanOrEqualTo(String value) {
            addCriterion("COLLATION_CONNECTION <=", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionLike(String value) {
            addCriterion("COLLATION_CONNECTION like", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionNotLike(String value) {
            addCriterion("COLLATION_CONNECTION not like", value, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionIn(List<String> values) {
            addCriterion("COLLATION_CONNECTION in", values, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionNotIn(List<String> values) {
            addCriterion("COLLATION_CONNECTION not in", values, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionBetween(String value1, String value2) {
            addCriterion("COLLATION_CONNECTION between", value1, value2, "collationConnection");
            return (Criteria) this;
        }

        public Criteria andCollationConnectionNotBetween(String value1, String value2) {
            addCriterion("COLLATION_CONNECTION not between", value1, value2, "collationConnection");
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