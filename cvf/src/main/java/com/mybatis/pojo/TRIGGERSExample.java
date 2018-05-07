package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TRIGGERSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TRIGGERSExample() {
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

        public Criteria andTriggerCatalogIsNull() {
            addCriterion("TRIGGER_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogIsNotNull() {
            addCriterion("TRIGGER_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogEqualTo(String value) {
            addCriterion("TRIGGER_CATALOG =", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogNotEqualTo(String value) {
            addCriterion("TRIGGER_CATALOG <>", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogGreaterThan(String value) {
            addCriterion("TRIGGER_CATALOG >", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("TRIGGER_CATALOG >=", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogLessThan(String value) {
            addCriterion("TRIGGER_CATALOG <", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogLessThanOrEqualTo(String value) {
            addCriterion("TRIGGER_CATALOG <=", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogLike(String value) {
            addCriterion("TRIGGER_CATALOG like", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogNotLike(String value) {
            addCriterion("TRIGGER_CATALOG not like", value, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogIn(List<String> values) {
            addCriterion("TRIGGER_CATALOG in", values, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogNotIn(List<String> values) {
            addCriterion("TRIGGER_CATALOG not in", values, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogBetween(String value1, String value2) {
            addCriterion("TRIGGER_CATALOG between", value1, value2, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerCatalogNotBetween(String value1, String value2) {
            addCriterion("TRIGGER_CATALOG not between", value1, value2, "triggerCatalog");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaIsNull() {
            addCriterion("TRIGGER_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaIsNotNull() {
            addCriterion("TRIGGER_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaEqualTo(String value) {
            addCriterion("TRIGGER_SCHEMA =", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaNotEqualTo(String value) {
            addCriterion("TRIGGER_SCHEMA <>", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaGreaterThan(String value) {
            addCriterion("TRIGGER_SCHEMA >", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("TRIGGER_SCHEMA >=", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaLessThan(String value) {
            addCriterion("TRIGGER_SCHEMA <", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaLessThanOrEqualTo(String value) {
            addCriterion("TRIGGER_SCHEMA <=", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaLike(String value) {
            addCriterion("TRIGGER_SCHEMA like", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaNotLike(String value) {
            addCriterion("TRIGGER_SCHEMA not like", value, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaIn(List<String> values) {
            addCriterion("TRIGGER_SCHEMA in", values, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaNotIn(List<String> values) {
            addCriterion("TRIGGER_SCHEMA not in", values, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaBetween(String value1, String value2) {
            addCriterion("TRIGGER_SCHEMA between", value1, value2, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerSchemaNotBetween(String value1, String value2) {
            addCriterion("TRIGGER_SCHEMA not between", value1, value2, "triggerSchema");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIsNull() {
            addCriterion("TRIGGER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIsNotNull() {
            addCriterion("TRIGGER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerNameEqualTo(String value) {
            addCriterion("TRIGGER_NAME =", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotEqualTo(String value) {
            addCriterion("TRIGGER_NAME <>", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameGreaterThan(String value) {
            addCriterion("TRIGGER_NAME >", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameGreaterThanOrEqualTo(String value) {
            addCriterion("TRIGGER_NAME >=", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLessThan(String value) {
            addCriterion("TRIGGER_NAME <", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLessThanOrEqualTo(String value) {
            addCriterion("TRIGGER_NAME <=", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLike(String value) {
            addCriterion("TRIGGER_NAME like", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotLike(String value) {
            addCriterion("TRIGGER_NAME not like", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIn(List<String> values) {
            addCriterion("TRIGGER_NAME in", values, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotIn(List<String> values) {
            addCriterion("TRIGGER_NAME not in", values, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameBetween(String value1, String value2) {
            addCriterion("TRIGGER_NAME between", value1, value2, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotBetween(String value1, String value2) {
            addCriterion("TRIGGER_NAME not between", value1, value2, "triggerName");
            return (Criteria) this;
        }

        public Criteria andEventManipulationIsNull() {
            addCriterion("EVENT_MANIPULATION is null");
            return (Criteria) this;
        }

        public Criteria andEventManipulationIsNotNull() {
            addCriterion("EVENT_MANIPULATION is not null");
            return (Criteria) this;
        }

        public Criteria andEventManipulationEqualTo(String value) {
            addCriterion("EVENT_MANIPULATION =", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationNotEqualTo(String value) {
            addCriterion("EVENT_MANIPULATION <>", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationGreaterThan(String value) {
            addCriterion("EVENT_MANIPULATION >", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_MANIPULATION >=", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationLessThan(String value) {
            addCriterion("EVENT_MANIPULATION <", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationLessThanOrEqualTo(String value) {
            addCriterion("EVENT_MANIPULATION <=", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationLike(String value) {
            addCriterion("EVENT_MANIPULATION like", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationNotLike(String value) {
            addCriterion("EVENT_MANIPULATION not like", value, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationIn(List<String> values) {
            addCriterion("EVENT_MANIPULATION in", values, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationNotIn(List<String> values) {
            addCriterion("EVENT_MANIPULATION not in", values, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationBetween(String value1, String value2) {
            addCriterion("EVENT_MANIPULATION between", value1, value2, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventManipulationNotBetween(String value1, String value2) {
            addCriterion("EVENT_MANIPULATION not between", value1, value2, "eventManipulation");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogIsNull() {
            addCriterion("EVENT_OBJECT_CATALOG is null");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogIsNotNull() {
            addCriterion("EVENT_OBJECT_CATALOG is not null");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogEqualTo(String value) {
            addCriterion("EVENT_OBJECT_CATALOG =", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogNotEqualTo(String value) {
            addCriterion("EVENT_OBJECT_CATALOG <>", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogGreaterThan(String value) {
            addCriterion("EVENT_OBJECT_CATALOG >", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_CATALOG >=", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogLessThan(String value) {
            addCriterion("EVENT_OBJECT_CATALOG <", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogLessThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_CATALOG <=", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogLike(String value) {
            addCriterion("EVENT_OBJECT_CATALOG like", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogNotLike(String value) {
            addCriterion("EVENT_OBJECT_CATALOG not like", value, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogIn(List<String> values) {
            addCriterion("EVENT_OBJECT_CATALOG in", values, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogNotIn(List<String> values) {
            addCriterion("EVENT_OBJECT_CATALOG not in", values, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_CATALOG between", value1, value2, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectCatalogNotBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_CATALOG not between", value1, value2, "eventObjectCatalog");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaIsNull() {
            addCriterion("EVENT_OBJECT_SCHEMA is null");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaIsNotNull() {
            addCriterion("EVENT_OBJECT_SCHEMA is not null");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaEqualTo(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA =", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaNotEqualTo(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA <>", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaGreaterThan(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA >", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA >=", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaLessThan(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA <", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaLessThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA <=", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaLike(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA like", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaNotLike(String value) {
            addCriterion("EVENT_OBJECT_SCHEMA not like", value, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaIn(List<String> values) {
            addCriterion("EVENT_OBJECT_SCHEMA in", values, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaNotIn(List<String> values) {
            addCriterion("EVENT_OBJECT_SCHEMA not in", values, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_SCHEMA between", value1, value2, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectSchemaNotBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_SCHEMA not between", value1, value2, "eventObjectSchema");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableIsNull() {
            addCriterion("EVENT_OBJECT_TABLE is null");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableIsNotNull() {
            addCriterion("EVENT_OBJECT_TABLE is not null");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableEqualTo(String value) {
            addCriterion("EVENT_OBJECT_TABLE =", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableNotEqualTo(String value) {
            addCriterion("EVENT_OBJECT_TABLE <>", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableGreaterThan(String value) {
            addCriterion("EVENT_OBJECT_TABLE >", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_TABLE >=", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableLessThan(String value) {
            addCriterion("EVENT_OBJECT_TABLE <", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableLessThanOrEqualTo(String value) {
            addCriterion("EVENT_OBJECT_TABLE <=", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableLike(String value) {
            addCriterion("EVENT_OBJECT_TABLE like", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableNotLike(String value) {
            addCriterion("EVENT_OBJECT_TABLE not like", value, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableIn(List<String> values) {
            addCriterion("EVENT_OBJECT_TABLE in", values, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableNotIn(List<String> values) {
            addCriterion("EVENT_OBJECT_TABLE not in", values, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_TABLE between", value1, value2, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andEventObjectTableNotBetween(String value1, String value2) {
            addCriterion("EVENT_OBJECT_TABLE not between", value1, value2, "eventObjectTable");
            return (Criteria) this;
        }

        public Criteria andActionOrderIsNull() {
            addCriterion("ACTION_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andActionOrderIsNotNull() {
            addCriterion("ACTION_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andActionOrderEqualTo(Long value) {
            addCriterion("ACTION_ORDER =", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderNotEqualTo(Long value) {
            addCriterion("ACTION_ORDER <>", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderGreaterThan(Long value) {
            addCriterion("ACTION_ORDER >", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("ACTION_ORDER >=", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderLessThan(Long value) {
            addCriterion("ACTION_ORDER <", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderLessThanOrEqualTo(Long value) {
            addCriterion("ACTION_ORDER <=", value, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderIn(List<Long> values) {
            addCriterion("ACTION_ORDER in", values, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderNotIn(List<Long> values) {
            addCriterion("ACTION_ORDER not in", values, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderBetween(Long value1, Long value2) {
            addCriterion("ACTION_ORDER between", value1, value2, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrderNotBetween(Long value1, Long value2) {
            addCriterion("ACTION_ORDER not between", value1, value2, "actionOrder");
            return (Criteria) this;
        }

        public Criteria andActionOrientationIsNull() {
            addCriterion("ACTION_ORIENTATION is null");
            return (Criteria) this;
        }

        public Criteria andActionOrientationIsNotNull() {
            addCriterion("ACTION_ORIENTATION is not null");
            return (Criteria) this;
        }

        public Criteria andActionOrientationEqualTo(String value) {
            addCriterion("ACTION_ORIENTATION =", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationNotEqualTo(String value) {
            addCriterion("ACTION_ORIENTATION <>", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationGreaterThan(String value) {
            addCriterion("ACTION_ORIENTATION >", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_ORIENTATION >=", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationLessThan(String value) {
            addCriterion("ACTION_ORIENTATION <", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationLessThanOrEqualTo(String value) {
            addCriterion("ACTION_ORIENTATION <=", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationLike(String value) {
            addCriterion("ACTION_ORIENTATION like", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationNotLike(String value) {
            addCriterion("ACTION_ORIENTATION not like", value, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationIn(List<String> values) {
            addCriterion("ACTION_ORIENTATION in", values, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationNotIn(List<String> values) {
            addCriterion("ACTION_ORIENTATION not in", values, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationBetween(String value1, String value2) {
            addCriterion("ACTION_ORIENTATION between", value1, value2, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionOrientationNotBetween(String value1, String value2) {
            addCriterion("ACTION_ORIENTATION not between", value1, value2, "actionOrientation");
            return (Criteria) this;
        }

        public Criteria andActionTimingIsNull() {
            addCriterion("ACTION_TIMING is null");
            return (Criteria) this;
        }

        public Criteria andActionTimingIsNotNull() {
            addCriterion("ACTION_TIMING is not null");
            return (Criteria) this;
        }

        public Criteria andActionTimingEqualTo(String value) {
            addCriterion("ACTION_TIMING =", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingNotEqualTo(String value) {
            addCriterion("ACTION_TIMING <>", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingGreaterThan(String value) {
            addCriterion("ACTION_TIMING >", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_TIMING >=", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingLessThan(String value) {
            addCriterion("ACTION_TIMING <", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingLessThanOrEqualTo(String value) {
            addCriterion("ACTION_TIMING <=", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingLike(String value) {
            addCriterion("ACTION_TIMING like", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingNotLike(String value) {
            addCriterion("ACTION_TIMING not like", value, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingIn(List<String> values) {
            addCriterion("ACTION_TIMING in", values, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingNotIn(List<String> values) {
            addCriterion("ACTION_TIMING not in", values, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingBetween(String value1, String value2) {
            addCriterion("ACTION_TIMING between", value1, value2, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionTimingNotBetween(String value1, String value2) {
            addCriterion("ACTION_TIMING not between", value1, value2, "actionTiming");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableIsNull() {
            addCriterion("ACTION_REFERENCE_OLD_TABLE is null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableIsNotNull() {
            addCriterion("ACTION_REFERENCE_OLD_TABLE is not null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE =", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableNotEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE <>", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableGreaterThan(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE >", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE >=", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableLessThan(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE <", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableLessThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE <=", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableLike(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE like", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableNotLike(String value) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE not like", value, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE in", values, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableNotIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE not in", values, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE between", value1, value2, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldTableNotBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_OLD_TABLE not between", value1, value2, "actionReferenceOldTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableIsNull() {
            addCriterion("ACTION_REFERENCE_NEW_TABLE is null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableIsNotNull() {
            addCriterion("ACTION_REFERENCE_NEW_TABLE is not null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE =", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableNotEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE <>", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableGreaterThan(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE >", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE >=", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableLessThan(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE <", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableLessThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE <=", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableLike(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE like", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableNotLike(String value) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE not like", value, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE in", values, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableNotIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE not in", values, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE between", value1, value2, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewTableNotBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_NEW_TABLE not between", value1, value2, "actionReferenceNewTable");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowIsNull() {
            addCriterion("ACTION_REFERENCE_OLD_ROW is null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowIsNotNull() {
            addCriterion("ACTION_REFERENCE_OLD_ROW is not null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW =", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowNotEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW <>", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowGreaterThan(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW >", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW >=", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowLessThan(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW <", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowLessThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW <=", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowLike(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW like", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowNotLike(String value) {
            addCriterion("ACTION_REFERENCE_OLD_ROW not like", value, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_OLD_ROW in", values, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowNotIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_OLD_ROW not in", values, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_OLD_ROW between", value1, value2, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceOldRowNotBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_OLD_ROW not between", value1, value2, "actionReferenceOldRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowIsNull() {
            addCriterion("ACTION_REFERENCE_NEW_ROW is null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowIsNotNull() {
            addCriterion("ACTION_REFERENCE_NEW_ROW is not null");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW =", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowNotEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW <>", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowGreaterThan(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW >", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW >=", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowLessThan(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW <", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowLessThanOrEqualTo(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW <=", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowLike(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW like", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowNotLike(String value) {
            addCriterion("ACTION_REFERENCE_NEW_ROW not like", value, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_NEW_ROW in", values, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowNotIn(List<String> values) {
            addCriterion("ACTION_REFERENCE_NEW_ROW not in", values, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_NEW_ROW between", value1, value2, "actionReferenceNewRow");
            return (Criteria) this;
        }

        public Criteria andActionReferenceNewRowNotBetween(String value1, String value2) {
            addCriterion("ACTION_REFERENCE_NEW_ROW not between", value1, value2, "actionReferenceNewRow");
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