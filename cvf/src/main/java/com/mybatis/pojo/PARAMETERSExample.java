package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class PARAMETERSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PARAMETERSExample() {
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

        public Criteria andSpecificCatalogIsNull() {
            addCriterion("SPECIFIC_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogIsNotNull() {
            addCriterion("SPECIFIC_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogEqualTo(String value) {
            addCriterion("SPECIFIC_CATALOG =", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogNotEqualTo(String value) {
            addCriterion("SPECIFIC_CATALOG <>", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogGreaterThan(String value) {
            addCriterion("SPECIFIC_CATALOG >", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_CATALOG >=", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogLessThan(String value) {
            addCriterion("SPECIFIC_CATALOG <", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogLessThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_CATALOG <=", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogLike(String value) {
            addCriterion("SPECIFIC_CATALOG like", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogNotLike(String value) {
            addCriterion("SPECIFIC_CATALOG not like", value, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogIn(List<String> values) {
            addCriterion("SPECIFIC_CATALOG in", values, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogNotIn(List<String> values) {
            addCriterion("SPECIFIC_CATALOG not in", values, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogBetween(String value1, String value2) {
            addCriterion("SPECIFIC_CATALOG between", value1, value2, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificCatalogNotBetween(String value1, String value2) {
            addCriterion("SPECIFIC_CATALOG not between", value1, value2, "specificCatalog");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaIsNull() {
            addCriterion("SPECIFIC_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaIsNotNull() {
            addCriterion("SPECIFIC_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaEqualTo(String value) {
            addCriterion("SPECIFIC_SCHEMA =", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaNotEqualTo(String value) {
            addCriterion("SPECIFIC_SCHEMA <>", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaGreaterThan(String value) {
            addCriterion("SPECIFIC_SCHEMA >", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_SCHEMA >=", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaLessThan(String value) {
            addCriterion("SPECIFIC_SCHEMA <", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaLessThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_SCHEMA <=", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaLike(String value) {
            addCriterion("SPECIFIC_SCHEMA like", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaNotLike(String value) {
            addCriterion("SPECIFIC_SCHEMA not like", value, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaIn(List<String> values) {
            addCriterion("SPECIFIC_SCHEMA in", values, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaNotIn(List<String> values) {
            addCriterion("SPECIFIC_SCHEMA not in", values, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaBetween(String value1, String value2) {
            addCriterion("SPECIFIC_SCHEMA between", value1, value2, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificSchemaNotBetween(String value1, String value2) {
            addCriterion("SPECIFIC_SCHEMA not between", value1, value2, "specificSchema");
            return (Criteria) this;
        }

        public Criteria andSpecificNameIsNull() {
            addCriterion("SPECIFIC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSpecificNameIsNotNull() {
            addCriterion("SPECIFIC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificNameEqualTo(String value) {
            addCriterion("SPECIFIC_NAME =", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameNotEqualTo(String value) {
            addCriterion("SPECIFIC_NAME <>", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameGreaterThan(String value) {
            addCriterion("SPECIFIC_NAME >", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_NAME >=", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameLessThan(String value) {
            addCriterion("SPECIFIC_NAME <", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameLessThanOrEqualTo(String value) {
            addCriterion("SPECIFIC_NAME <=", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameLike(String value) {
            addCriterion("SPECIFIC_NAME like", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameNotLike(String value) {
            addCriterion("SPECIFIC_NAME not like", value, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameIn(List<String> values) {
            addCriterion("SPECIFIC_NAME in", values, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameNotIn(List<String> values) {
            addCriterion("SPECIFIC_NAME not in", values, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameBetween(String value1, String value2) {
            addCriterion("SPECIFIC_NAME between", value1, value2, "specificName");
            return (Criteria) this;
        }

        public Criteria andSpecificNameNotBetween(String value1, String value2) {
            addCriterion("SPECIFIC_NAME not between", value1, value2, "specificName");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionIsNull() {
            addCriterion("ORDINAL_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionIsNotNull() {
            addCriterion("ORDINAL_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionEqualTo(Integer value) {
            addCriterion("ORDINAL_POSITION =", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotEqualTo(Integer value) {
            addCriterion("ORDINAL_POSITION <>", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionGreaterThan(Integer value) {
            addCriterion("ORDINAL_POSITION >", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDINAL_POSITION >=", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionLessThan(Integer value) {
            addCriterion("ORDINAL_POSITION <", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionLessThanOrEqualTo(Integer value) {
            addCriterion("ORDINAL_POSITION <=", value, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionIn(List<Integer> values) {
            addCriterion("ORDINAL_POSITION in", values, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotIn(List<Integer> values) {
            addCriterion("ORDINAL_POSITION not in", values, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionBetween(Integer value1, Integer value2) {
            addCriterion("ORDINAL_POSITION between", value1, value2, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andOrdinalPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDINAL_POSITION not between", value1, value2, "ordinalPosition");
            return (Criteria) this;
        }

        public Criteria andParameterModeIsNull() {
            addCriterion("PARAMETER_MODE is null");
            return (Criteria) this;
        }

        public Criteria andParameterModeIsNotNull() {
            addCriterion("PARAMETER_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andParameterModeEqualTo(String value) {
            addCriterion("PARAMETER_MODE =", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeNotEqualTo(String value) {
            addCriterion("PARAMETER_MODE <>", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeGreaterThan(String value) {
            addCriterion("PARAMETER_MODE >", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMETER_MODE >=", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeLessThan(String value) {
            addCriterion("PARAMETER_MODE <", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeLessThanOrEqualTo(String value) {
            addCriterion("PARAMETER_MODE <=", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeLike(String value) {
            addCriterion("PARAMETER_MODE like", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeNotLike(String value) {
            addCriterion("PARAMETER_MODE not like", value, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeIn(List<String> values) {
            addCriterion("PARAMETER_MODE in", values, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeNotIn(List<String> values) {
            addCriterion("PARAMETER_MODE not in", values, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeBetween(String value1, String value2) {
            addCriterion("PARAMETER_MODE between", value1, value2, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterModeNotBetween(String value1, String value2) {
            addCriterion("PARAMETER_MODE not between", value1, value2, "parameterMode");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNull() {
            addCriterion("PARAMETER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andParameterNameIsNotNull() {
            addCriterion("PARAMETER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andParameterNameEqualTo(String value) {
            addCriterion("PARAMETER_NAME =", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotEqualTo(String value) {
            addCriterion("PARAMETER_NAME <>", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThan(String value) {
            addCriterion("PARAMETER_NAME >", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMETER_NAME >=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThan(String value) {
            addCriterion("PARAMETER_NAME <", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLessThanOrEqualTo(String value) {
            addCriterion("PARAMETER_NAME <=", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameLike(String value) {
            addCriterion("PARAMETER_NAME like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotLike(String value) {
            addCriterion("PARAMETER_NAME not like", value, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameIn(List<String> values) {
            addCriterion("PARAMETER_NAME in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotIn(List<String> values) {
            addCriterion("PARAMETER_NAME not in", values, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameBetween(String value1, String value2) {
            addCriterion("PARAMETER_NAME between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andParameterNameNotBetween(String value1, String value2) {
            addCriterion("PARAMETER_NAME not between", value1, value2, "parameterName");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthIsNull() {
            addCriterion("CHARACTER_MAXIMUM_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthIsNotNull() {
            addCriterion("CHARACTER_MAXIMUM_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthEqualTo(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH =", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthNotEqualTo(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH <>", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthGreaterThan(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH >", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH >=", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthLessThan(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH <", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthLessThanOrEqualTo(Integer value) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH <=", value, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthIn(List<Integer> values) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH in", values, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthNotIn(List<Integer> values) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH not in", values, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthBetween(Integer value1, Integer value2) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH between", value1, value2, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterMaximumLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARACTER_MAXIMUM_LENGTH not between", value1, value2, "characterMaximumLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthIsNull() {
            addCriterion("CHARACTER_OCTET_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthIsNotNull() {
            addCriterion("CHARACTER_OCTET_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthEqualTo(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH =", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthNotEqualTo(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH <>", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthGreaterThan(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH >", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH >=", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthLessThan(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH <", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthLessThanOrEqualTo(Integer value) {
            addCriterion("CHARACTER_OCTET_LENGTH <=", value, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthIn(List<Integer> values) {
            addCriterion("CHARACTER_OCTET_LENGTH in", values, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthNotIn(List<Integer> values) {
            addCriterion("CHARACTER_OCTET_LENGTH not in", values, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthBetween(Integer value1, Integer value2) {
            addCriterion("CHARACTER_OCTET_LENGTH between", value1, value2, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andCharacterOctetLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("CHARACTER_OCTET_LENGTH not between", value1, value2, "characterOctetLength");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionIsNull() {
            addCriterion("NUMERIC_PRECISION is null");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionIsNotNull() {
            addCriterion("NUMERIC_PRECISION is not null");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionEqualTo(Integer value) {
            addCriterion("NUMERIC_PRECISION =", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionNotEqualTo(Integer value) {
            addCriterion("NUMERIC_PRECISION <>", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionGreaterThan(Integer value) {
            addCriterion("NUMERIC_PRECISION >", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUMERIC_PRECISION >=", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionLessThan(Integer value) {
            addCriterion("NUMERIC_PRECISION <", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionLessThanOrEqualTo(Integer value) {
            addCriterion("NUMERIC_PRECISION <=", value, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionIn(List<Integer> values) {
            addCriterion("NUMERIC_PRECISION in", values, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionNotIn(List<Integer> values) {
            addCriterion("NUMERIC_PRECISION not in", values, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionBetween(Integer value1, Integer value2) {
            addCriterion("NUMERIC_PRECISION between", value1, value2, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericPrecisionNotBetween(Integer value1, Integer value2) {
            addCriterion("NUMERIC_PRECISION not between", value1, value2, "numericPrecision");
            return (Criteria) this;
        }

        public Criteria andNumericScaleIsNull() {
            addCriterion("NUMERIC_SCALE is null");
            return (Criteria) this;
        }

        public Criteria andNumericScaleIsNotNull() {
            addCriterion("NUMERIC_SCALE is not null");
            return (Criteria) this;
        }

        public Criteria andNumericScaleEqualTo(Integer value) {
            addCriterion("NUMERIC_SCALE =", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleNotEqualTo(Integer value) {
            addCriterion("NUMERIC_SCALE <>", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleGreaterThan(Integer value) {
            addCriterion("NUMERIC_SCALE >", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("NUMERIC_SCALE >=", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleLessThan(Integer value) {
            addCriterion("NUMERIC_SCALE <", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleLessThanOrEqualTo(Integer value) {
            addCriterion("NUMERIC_SCALE <=", value, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleIn(List<Integer> values) {
            addCriterion("NUMERIC_SCALE in", values, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleNotIn(List<Integer> values) {
            addCriterion("NUMERIC_SCALE not in", values, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleBetween(Integer value1, Integer value2) {
            addCriterion("NUMERIC_SCALE between", value1, value2, "numericScale");
            return (Criteria) this;
        }

        public Criteria andNumericScaleNotBetween(Integer value1, Integer value2) {
            addCriterion("NUMERIC_SCALE not between", value1, value2, "numericScale");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIsNull() {
            addCriterion("CHARACTER_SET_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIsNotNull() {
            addCriterion("CHARACTER_SET_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME =", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME <>", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameGreaterThan(String value) {
            addCriterion("CHARACTER_SET_NAME >", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME >=", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLessThan(String value) {
            addCriterion("CHARACTER_SET_NAME <", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLessThanOrEqualTo(String value) {
            addCriterion("CHARACTER_SET_NAME <=", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameLike(String value) {
            addCriterion("CHARACTER_SET_NAME like", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotLike(String value) {
            addCriterion("CHARACTER_SET_NAME not like", value, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameIn(List<String> values) {
            addCriterion("CHARACTER_SET_NAME in", values, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotIn(List<String> values) {
            addCriterion("CHARACTER_SET_NAME not in", values, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_NAME between", value1, value2, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCharacterSetNameNotBetween(String value1, String value2) {
            addCriterion("CHARACTER_SET_NAME not between", value1, value2, "characterSetName");
            return (Criteria) this;
        }

        public Criteria andCollationNameIsNull() {
            addCriterion("COLLATION_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCollationNameIsNotNull() {
            addCriterion("COLLATION_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCollationNameEqualTo(String value) {
            addCriterion("COLLATION_NAME =", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotEqualTo(String value) {
            addCriterion("COLLATION_NAME <>", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameGreaterThan(String value) {
            addCriterion("COLLATION_NAME >", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameGreaterThanOrEqualTo(String value) {
            addCriterion("COLLATION_NAME >=", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLessThan(String value) {
            addCriterion("COLLATION_NAME <", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLessThanOrEqualTo(String value) {
            addCriterion("COLLATION_NAME <=", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameLike(String value) {
            addCriterion("COLLATION_NAME like", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotLike(String value) {
            addCriterion("COLLATION_NAME not like", value, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameIn(List<String> values) {
            addCriterion("COLLATION_NAME in", values, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotIn(List<String> values) {
            addCriterion("COLLATION_NAME not in", values, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameBetween(String value1, String value2) {
            addCriterion("COLLATION_NAME between", value1, value2, "collationName");
            return (Criteria) this;
        }

        public Criteria andCollationNameNotBetween(String value1, String value2) {
            addCriterion("COLLATION_NAME not between", value1, value2, "collationName");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeIsNull() {
            addCriterion("ROUTINE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeIsNotNull() {
            addCriterion("ROUTINE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeEqualTo(String value) {
            addCriterion("ROUTINE_TYPE =", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeNotEqualTo(String value) {
            addCriterion("ROUTINE_TYPE <>", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeGreaterThan(String value) {
            addCriterion("ROUTINE_TYPE >", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTINE_TYPE >=", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeLessThan(String value) {
            addCriterion("ROUTINE_TYPE <", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeLessThanOrEqualTo(String value) {
            addCriterion("ROUTINE_TYPE <=", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeLike(String value) {
            addCriterion("ROUTINE_TYPE like", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeNotLike(String value) {
            addCriterion("ROUTINE_TYPE not like", value, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeIn(List<String> values) {
            addCriterion("ROUTINE_TYPE in", values, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeNotIn(List<String> values) {
            addCriterion("ROUTINE_TYPE not in", values, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeBetween(String value1, String value2) {
            addCriterion("ROUTINE_TYPE between", value1, value2, "routineType");
            return (Criteria) this;
        }

        public Criteria andRoutineTypeNotBetween(String value1, String value2) {
            addCriterion("ROUTINE_TYPE not between", value1, value2, "routineType");
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