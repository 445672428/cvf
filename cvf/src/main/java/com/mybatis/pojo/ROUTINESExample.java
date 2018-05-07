package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ROUTINESExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ROUTINESExample() {
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

        public Criteria andRoutineCatalogIsNull() {
            addCriterion("ROUTINE_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogIsNotNull() {
            addCriterion("ROUTINE_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogEqualTo(String value) {
            addCriterion("ROUTINE_CATALOG =", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogNotEqualTo(String value) {
            addCriterion("ROUTINE_CATALOG <>", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogGreaterThan(String value) {
            addCriterion("ROUTINE_CATALOG >", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTINE_CATALOG >=", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogLessThan(String value) {
            addCriterion("ROUTINE_CATALOG <", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogLessThanOrEqualTo(String value) {
            addCriterion("ROUTINE_CATALOG <=", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogLike(String value) {
            addCriterion("ROUTINE_CATALOG like", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogNotLike(String value) {
            addCriterion("ROUTINE_CATALOG not like", value, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogIn(List<String> values) {
            addCriterion("ROUTINE_CATALOG in", values, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogNotIn(List<String> values) {
            addCriterion("ROUTINE_CATALOG not in", values, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogBetween(String value1, String value2) {
            addCriterion("ROUTINE_CATALOG between", value1, value2, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineCatalogNotBetween(String value1, String value2) {
            addCriterion("ROUTINE_CATALOG not between", value1, value2, "routineCatalog");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaIsNull() {
            addCriterion("ROUTINE_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaIsNotNull() {
            addCriterion("ROUTINE_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaEqualTo(String value) {
            addCriterion("ROUTINE_SCHEMA =", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaNotEqualTo(String value) {
            addCriterion("ROUTINE_SCHEMA <>", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaGreaterThan(String value) {
            addCriterion("ROUTINE_SCHEMA >", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTINE_SCHEMA >=", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaLessThan(String value) {
            addCriterion("ROUTINE_SCHEMA <", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaLessThanOrEqualTo(String value) {
            addCriterion("ROUTINE_SCHEMA <=", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaLike(String value) {
            addCriterion("ROUTINE_SCHEMA like", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaNotLike(String value) {
            addCriterion("ROUTINE_SCHEMA not like", value, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaIn(List<String> values) {
            addCriterion("ROUTINE_SCHEMA in", values, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaNotIn(List<String> values) {
            addCriterion("ROUTINE_SCHEMA not in", values, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaBetween(String value1, String value2) {
            addCriterion("ROUTINE_SCHEMA between", value1, value2, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineSchemaNotBetween(String value1, String value2) {
            addCriterion("ROUTINE_SCHEMA not between", value1, value2, "routineSchema");
            return (Criteria) this;
        }

        public Criteria andRoutineNameIsNull() {
            addCriterion("ROUTINE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoutineNameIsNotNull() {
            addCriterion("ROUTINE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineNameEqualTo(String value) {
            addCriterion("ROUTINE_NAME =", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameNotEqualTo(String value) {
            addCriterion("ROUTINE_NAME <>", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameGreaterThan(String value) {
            addCriterion("ROUTINE_NAME >", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTINE_NAME >=", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameLessThan(String value) {
            addCriterion("ROUTINE_NAME <", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameLessThanOrEqualTo(String value) {
            addCriterion("ROUTINE_NAME <=", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameLike(String value) {
            addCriterion("ROUTINE_NAME like", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameNotLike(String value) {
            addCriterion("ROUTINE_NAME not like", value, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameIn(List<String> values) {
            addCriterion("ROUTINE_NAME in", values, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameNotIn(List<String> values) {
            addCriterion("ROUTINE_NAME not in", values, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameBetween(String value1, String value2) {
            addCriterion("ROUTINE_NAME between", value1, value2, "routineName");
            return (Criteria) this;
        }

        public Criteria andRoutineNameNotBetween(String value1, String value2) {
            addCriterion("ROUTINE_NAME not between", value1, value2, "routineName");
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

        public Criteria andRoutineBodyIsNull() {
            addCriterion("ROUTINE_BODY is null");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyIsNotNull() {
            addCriterion("ROUTINE_BODY is not null");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyEqualTo(String value) {
            addCriterion("ROUTINE_BODY =", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyNotEqualTo(String value) {
            addCriterion("ROUTINE_BODY <>", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyGreaterThan(String value) {
            addCriterion("ROUTINE_BODY >", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyGreaterThanOrEqualTo(String value) {
            addCriterion("ROUTINE_BODY >=", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyLessThan(String value) {
            addCriterion("ROUTINE_BODY <", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyLessThanOrEqualTo(String value) {
            addCriterion("ROUTINE_BODY <=", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyLike(String value) {
            addCriterion("ROUTINE_BODY like", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyNotLike(String value) {
            addCriterion("ROUTINE_BODY not like", value, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyIn(List<String> values) {
            addCriterion("ROUTINE_BODY in", values, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyNotIn(List<String> values) {
            addCriterion("ROUTINE_BODY not in", values, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyBetween(String value1, String value2) {
            addCriterion("ROUTINE_BODY between", value1, value2, "routineBody");
            return (Criteria) this;
        }

        public Criteria andRoutineBodyNotBetween(String value1, String value2) {
            addCriterion("ROUTINE_BODY not between", value1, value2, "routineBody");
            return (Criteria) this;
        }

        public Criteria andExternalNameIsNull() {
            addCriterion("EXTERNAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExternalNameIsNotNull() {
            addCriterion("EXTERNAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExternalNameEqualTo(String value) {
            addCriterion("EXTERNAL_NAME =", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotEqualTo(String value) {
            addCriterion("EXTERNAL_NAME <>", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameGreaterThan(String value) {
            addCriterion("EXTERNAL_NAME >", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_NAME >=", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLessThan(String value) {
            addCriterion("EXTERNAL_NAME <", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_NAME <=", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameLike(String value) {
            addCriterion("EXTERNAL_NAME like", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotLike(String value) {
            addCriterion("EXTERNAL_NAME not like", value, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameIn(List<String> values) {
            addCriterion("EXTERNAL_NAME in", values, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotIn(List<String> values) {
            addCriterion("EXTERNAL_NAME not in", values, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameBetween(String value1, String value2) {
            addCriterion("EXTERNAL_NAME between", value1, value2, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalNameNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_NAME not between", value1, value2, "externalName");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageIsNull() {
            addCriterion("EXTERNAL_LANGUAGE is null");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageIsNotNull() {
            addCriterion("EXTERNAL_LANGUAGE is not null");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageEqualTo(String value) {
            addCriterion("EXTERNAL_LANGUAGE =", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageNotEqualTo(String value) {
            addCriterion("EXTERNAL_LANGUAGE <>", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageGreaterThan(String value) {
            addCriterion("EXTERNAL_LANGUAGE >", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_LANGUAGE >=", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageLessThan(String value) {
            addCriterion("EXTERNAL_LANGUAGE <", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageLessThanOrEqualTo(String value) {
            addCriterion("EXTERNAL_LANGUAGE <=", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageLike(String value) {
            addCriterion("EXTERNAL_LANGUAGE like", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageNotLike(String value) {
            addCriterion("EXTERNAL_LANGUAGE not like", value, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageIn(List<String> values) {
            addCriterion("EXTERNAL_LANGUAGE in", values, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageNotIn(List<String> values) {
            addCriterion("EXTERNAL_LANGUAGE not in", values, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageBetween(String value1, String value2) {
            addCriterion("EXTERNAL_LANGUAGE between", value1, value2, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andExternalLanguageNotBetween(String value1, String value2) {
            addCriterion("EXTERNAL_LANGUAGE not between", value1, value2, "externalLanguage");
            return (Criteria) this;
        }

        public Criteria andParameterStyleIsNull() {
            addCriterion("PARAMETER_STYLE is null");
            return (Criteria) this;
        }

        public Criteria andParameterStyleIsNotNull() {
            addCriterion("PARAMETER_STYLE is not null");
            return (Criteria) this;
        }

        public Criteria andParameterStyleEqualTo(String value) {
            addCriterion("PARAMETER_STYLE =", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleNotEqualTo(String value) {
            addCriterion("PARAMETER_STYLE <>", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleGreaterThan(String value) {
            addCriterion("PARAMETER_STYLE >", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMETER_STYLE >=", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleLessThan(String value) {
            addCriterion("PARAMETER_STYLE <", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleLessThanOrEqualTo(String value) {
            addCriterion("PARAMETER_STYLE <=", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleLike(String value) {
            addCriterion("PARAMETER_STYLE like", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleNotLike(String value) {
            addCriterion("PARAMETER_STYLE not like", value, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleIn(List<String> values) {
            addCriterion("PARAMETER_STYLE in", values, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleNotIn(List<String> values) {
            addCriterion("PARAMETER_STYLE not in", values, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleBetween(String value1, String value2) {
            addCriterion("PARAMETER_STYLE between", value1, value2, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andParameterStyleNotBetween(String value1, String value2) {
            addCriterion("PARAMETER_STYLE not between", value1, value2, "parameterStyle");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicIsNull() {
            addCriterion("IS_DETERMINISTIC is null");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicIsNotNull() {
            addCriterion("IS_DETERMINISTIC is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicEqualTo(String value) {
            addCriterion("IS_DETERMINISTIC =", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicNotEqualTo(String value) {
            addCriterion("IS_DETERMINISTIC <>", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicGreaterThan(String value) {
            addCriterion("IS_DETERMINISTIC >", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DETERMINISTIC >=", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicLessThan(String value) {
            addCriterion("IS_DETERMINISTIC <", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicLessThanOrEqualTo(String value) {
            addCriterion("IS_DETERMINISTIC <=", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicLike(String value) {
            addCriterion("IS_DETERMINISTIC like", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicNotLike(String value) {
            addCriterion("IS_DETERMINISTIC not like", value, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicIn(List<String> values) {
            addCriterion("IS_DETERMINISTIC in", values, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicNotIn(List<String> values) {
            addCriterion("IS_DETERMINISTIC not in", values, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicBetween(String value1, String value2) {
            addCriterion("IS_DETERMINISTIC between", value1, value2, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andIsDeterministicNotBetween(String value1, String value2) {
            addCriterion("IS_DETERMINISTIC not between", value1, value2, "isDeterministic");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessIsNull() {
            addCriterion("SQL_DATA_ACCESS is null");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessIsNotNull() {
            addCriterion("SQL_DATA_ACCESS is not null");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessEqualTo(String value) {
            addCriterion("SQL_DATA_ACCESS =", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessNotEqualTo(String value) {
            addCriterion("SQL_DATA_ACCESS <>", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessGreaterThan(String value) {
            addCriterion("SQL_DATA_ACCESS >", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessGreaterThanOrEqualTo(String value) {
            addCriterion("SQL_DATA_ACCESS >=", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessLessThan(String value) {
            addCriterion("SQL_DATA_ACCESS <", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessLessThanOrEqualTo(String value) {
            addCriterion("SQL_DATA_ACCESS <=", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessLike(String value) {
            addCriterion("SQL_DATA_ACCESS like", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessNotLike(String value) {
            addCriterion("SQL_DATA_ACCESS not like", value, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessIn(List<String> values) {
            addCriterion("SQL_DATA_ACCESS in", values, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessNotIn(List<String> values) {
            addCriterion("SQL_DATA_ACCESS not in", values, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessBetween(String value1, String value2) {
            addCriterion("SQL_DATA_ACCESS between", value1, value2, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlDataAccessNotBetween(String value1, String value2) {
            addCriterion("SQL_DATA_ACCESS not between", value1, value2, "sqlDataAccess");
            return (Criteria) this;
        }

        public Criteria andSqlPathIsNull() {
            addCriterion("SQL_PATH is null");
            return (Criteria) this;
        }

        public Criteria andSqlPathIsNotNull() {
            addCriterion("SQL_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andSqlPathEqualTo(String value) {
            addCriterion("SQL_PATH =", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathNotEqualTo(String value) {
            addCriterion("SQL_PATH <>", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathGreaterThan(String value) {
            addCriterion("SQL_PATH >", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathGreaterThanOrEqualTo(String value) {
            addCriterion("SQL_PATH >=", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathLessThan(String value) {
            addCriterion("SQL_PATH <", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathLessThanOrEqualTo(String value) {
            addCriterion("SQL_PATH <=", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathLike(String value) {
            addCriterion("SQL_PATH like", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathNotLike(String value) {
            addCriterion("SQL_PATH not like", value, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathIn(List<String> values) {
            addCriterion("SQL_PATH in", values, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathNotIn(List<String> values) {
            addCriterion("SQL_PATH not in", values, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathBetween(String value1, String value2) {
            addCriterion("SQL_PATH between", value1, value2, "sqlPath");
            return (Criteria) this;
        }

        public Criteria andSqlPathNotBetween(String value1, String value2) {
            addCriterion("SQL_PATH not between", value1, value2, "sqlPath");
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

        public Criteria andCreatedIsNull() {
            addCriterion("CREATED is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("CREATED =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("CREATED <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("CREATED >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("CREATED <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("CREATED <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("CREATED in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("CREATED not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("CREATED between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("CREATED not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andLastAlteredIsNull() {
            addCriterion("LAST_ALTERED is null");
            return (Criteria) this;
        }

        public Criteria andLastAlteredIsNotNull() {
            addCriterion("LAST_ALTERED is not null");
            return (Criteria) this;
        }

        public Criteria andLastAlteredEqualTo(Date value) {
            addCriterion("LAST_ALTERED =", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredNotEqualTo(Date value) {
            addCriterion("LAST_ALTERED <>", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredGreaterThan(Date value) {
            addCriterion("LAST_ALTERED >", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_ALTERED >=", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredLessThan(Date value) {
            addCriterion("LAST_ALTERED <", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredLessThanOrEqualTo(Date value) {
            addCriterion("LAST_ALTERED <=", value, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredIn(List<Date> values) {
            addCriterion("LAST_ALTERED in", values, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredNotIn(List<Date> values) {
            addCriterion("LAST_ALTERED not in", values, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredBetween(Date value1, Date value2) {
            addCriterion("LAST_ALTERED between", value1, value2, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andLastAlteredNotBetween(Date value1, Date value2) {
            addCriterion("LAST_ALTERED not between", value1, value2, "lastAltered");
            return (Criteria) this;
        }

        public Criteria andSqlModeIsNull() {
            addCriterion("SQL_MODE is null");
            return (Criteria) this;
        }

        public Criteria andSqlModeIsNotNull() {
            addCriterion("SQL_MODE is not null");
            return (Criteria) this;
        }

        public Criteria andSqlModeEqualTo(String value) {
            addCriterion("SQL_MODE =", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeNotEqualTo(String value) {
            addCriterion("SQL_MODE <>", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeGreaterThan(String value) {
            addCriterion("SQL_MODE >", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeGreaterThanOrEqualTo(String value) {
            addCriterion("SQL_MODE >=", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeLessThan(String value) {
            addCriterion("SQL_MODE <", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeLessThanOrEqualTo(String value) {
            addCriterion("SQL_MODE <=", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeLike(String value) {
            addCriterion("SQL_MODE like", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeNotLike(String value) {
            addCriterion("SQL_MODE not like", value, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeIn(List<String> values) {
            addCriterion("SQL_MODE in", values, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeNotIn(List<String> values) {
            addCriterion("SQL_MODE not in", values, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeBetween(String value1, String value2) {
            addCriterion("SQL_MODE between", value1, value2, "sqlMode");
            return (Criteria) this;
        }

        public Criteria andSqlModeNotBetween(String value1, String value2) {
            addCriterion("SQL_MODE not between", value1, value2, "sqlMode");
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

        public Criteria andDatabaseCollationIsNull() {
            addCriterion("DATABASE_COLLATION is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationIsNotNull() {
            addCriterion("DATABASE_COLLATION is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationEqualTo(String value) {
            addCriterion("DATABASE_COLLATION =", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationNotEqualTo(String value) {
            addCriterion("DATABASE_COLLATION <>", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationGreaterThan(String value) {
            addCriterion("DATABASE_COLLATION >", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationGreaterThanOrEqualTo(String value) {
            addCriterion("DATABASE_COLLATION >=", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationLessThan(String value) {
            addCriterion("DATABASE_COLLATION <", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationLessThanOrEqualTo(String value) {
            addCriterion("DATABASE_COLLATION <=", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationLike(String value) {
            addCriterion("DATABASE_COLLATION like", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationNotLike(String value) {
            addCriterion("DATABASE_COLLATION not like", value, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationIn(List<String> values) {
            addCriterion("DATABASE_COLLATION in", values, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationNotIn(List<String> values) {
            addCriterion("DATABASE_COLLATION not in", values, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationBetween(String value1, String value2) {
            addCriterion("DATABASE_COLLATION between", value1, value2, "databaseCollation");
            return (Criteria) this;
        }

        public Criteria andDatabaseCollationNotBetween(String value1, String value2) {
            addCriterion("DATABASE_COLLATION not between", value1, value2, "databaseCollation");
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