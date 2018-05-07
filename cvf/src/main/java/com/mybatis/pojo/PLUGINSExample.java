package com.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class PLUGINSExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PLUGINSExample() {
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

        public Criteria andPluginNameIsNull() {
            addCriterion("PLUGIN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPluginNameIsNotNull() {
            addCriterion("PLUGIN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPluginNameEqualTo(String value) {
            addCriterion("PLUGIN_NAME =", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotEqualTo(String value) {
            addCriterion("PLUGIN_NAME <>", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameGreaterThan(String value) {
            addCriterion("PLUGIN_NAME >", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_NAME >=", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLessThan(String value) {
            addCriterion("PLUGIN_NAME <", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_NAME <=", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameLike(String value) {
            addCriterion("PLUGIN_NAME like", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotLike(String value) {
            addCriterion("PLUGIN_NAME not like", value, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameIn(List<String> values) {
            addCriterion("PLUGIN_NAME in", values, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotIn(List<String> values) {
            addCriterion("PLUGIN_NAME not in", values, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameBetween(String value1, String value2) {
            addCriterion("PLUGIN_NAME between", value1, value2, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginNameNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_NAME not between", value1, value2, "pluginName");
            return (Criteria) this;
        }

        public Criteria andPluginVersionIsNull() {
            addCriterion("PLUGIN_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andPluginVersionIsNotNull() {
            addCriterion("PLUGIN_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andPluginVersionEqualTo(String value) {
            addCriterion("PLUGIN_VERSION =", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionNotEqualTo(String value) {
            addCriterion("PLUGIN_VERSION <>", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionGreaterThan(String value) {
            addCriterion("PLUGIN_VERSION >", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_VERSION >=", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionLessThan(String value) {
            addCriterion("PLUGIN_VERSION <", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_VERSION <=", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionLike(String value) {
            addCriterion("PLUGIN_VERSION like", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionNotLike(String value) {
            addCriterion("PLUGIN_VERSION not like", value, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionIn(List<String> values) {
            addCriterion("PLUGIN_VERSION in", values, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionNotIn(List<String> values) {
            addCriterion("PLUGIN_VERSION not in", values, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionBetween(String value1, String value2) {
            addCriterion("PLUGIN_VERSION between", value1, value2, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginVersionNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_VERSION not between", value1, value2, "pluginVersion");
            return (Criteria) this;
        }

        public Criteria andPluginStatusIsNull() {
            addCriterion("PLUGIN_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPluginStatusIsNotNull() {
            addCriterion("PLUGIN_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPluginStatusEqualTo(String value) {
            addCriterion("PLUGIN_STATUS =", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusNotEqualTo(String value) {
            addCriterion("PLUGIN_STATUS <>", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusGreaterThan(String value) {
            addCriterion("PLUGIN_STATUS >", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_STATUS >=", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusLessThan(String value) {
            addCriterion("PLUGIN_STATUS <", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_STATUS <=", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusLike(String value) {
            addCriterion("PLUGIN_STATUS like", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusNotLike(String value) {
            addCriterion("PLUGIN_STATUS not like", value, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusIn(List<String> values) {
            addCriterion("PLUGIN_STATUS in", values, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusNotIn(List<String> values) {
            addCriterion("PLUGIN_STATUS not in", values, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusBetween(String value1, String value2) {
            addCriterion("PLUGIN_STATUS between", value1, value2, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginStatusNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_STATUS not between", value1, value2, "pluginStatus");
            return (Criteria) this;
        }

        public Criteria andPluginTypeIsNull() {
            addCriterion("PLUGIN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPluginTypeIsNotNull() {
            addCriterion("PLUGIN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPluginTypeEqualTo(String value) {
            addCriterion("PLUGIN_TYPE =", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeNotEqualTo(String value) {
            addCriterion("PLUGIN_TYPE <>", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeGreaterThan(String value) {
            addCriterion("PLUGIN_TYPE >", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_TYPE >=", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeLessThan(String value) {
            addCriterion("PLUGIN_TYPE <", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_TYPE <=", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeLike(String value) {
            addCriterion("PLUGIN_TYPE like", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeNotLike(String value) {
            addCriterion("PLUGIN_TYPE not like", value, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeIn(List<String> values) {
            addCriterion("PLUGIN_TYPE in", values, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeNotIn(List<String> values) {
            addCriterion("PLUGIN_TYPE not in", values, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeBetween(String value1, String value2) {
            addCriterion("PLUGIN_TYPE between", value1, value2, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_TYPE not between", value1, value2, "pluginType");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionIsNull() {
            addCriterion("PLUGIN_TYPE_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionIsNotNull() {
            addCriterion("PLUGIN_TYPE_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionEqualTo(String value) {
            addCriterion("PLUGIN_TYPE_VERSION =", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionNotEqualTo(String value) {
            addCriterion("PLUGIN_TYPE_VERSION <>", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionGreaterThan(String value) {
            addCriterion("PLUGIN_TYPE_VERSION >", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_TYPE_VERSION >=", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionLessThan(String value) {
            addCriterion("PLUGIN_TYPE_VERSION <", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_TYPE_VERSION <=", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionLike(String value) {
            addCriterion("PLUGIN_TYPE_VERSION like", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionNotLike(String value) {
            addCriterion("PLUGIN_TYPE_VERSION not like", value, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionIn(List<String> values) {
            addCriterion("PLUGIN_TYPE_VERSION in", values, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionNotIn(List<String> values) {
            addCriterion("PLUGIN_TYPE_VERSION not in", values, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionBetween(String value1, String value2) {
            addCriterion("PLUGIN_TYPE_VERSION between", value1, value2, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginTypeVersionNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_TYPE_VERSION not between", value1, value2, "pluginTypeVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryIsNull() {
            addCriterion("PLUGIN_LIBRARY is null");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryIsNotNull() {
            addCriterion("PLUGIN_LIBRARY is not null");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY =", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryNotEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY <>", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryGreaterThan(String value) {
            addCriterion("PLUGIN_LIBRARY >", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY >=", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryLessThan(String value) {
            addCriterion("PLUGIN_LIBRARY <", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY <=", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryLike(String value) {
            addCriterion("PLUGIN_LIBRARY like", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryNotLike(String value) {
            addCriterion("PLUGIN_LIBRARY not like", value, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryIn(List<String> values) {
            addCriterion("PLUGIN_LIBRARY in", values, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryNotIn(List<String> values) {
            addCriterion("PLUGIN_LIBRARY not in", values, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryBetween(String value1, String value2) {
            addCriterion("PLUGIN_LIBRARY between", value1, value2, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_LIBRARY not between", value1, value2, "pluginLibrary");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionIsNull() {
            addCriterion("PLUGIN_LIBRARY_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionIsNotNull() {
            addCriterion("PLUGIN_LIBRARY_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION =", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionNotEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION <>", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionGreaterThan(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION >", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION >=", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionLessThan(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION <", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION <=", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionLike(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION like", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionNotLike(String value) {
            addCriterion("PLUGIN_LIBRARY_VERSION not like", value, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionIn(List<String> values) {
            addCriterion("PLUGIN_LIBRARY_VERSION in", values, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionNotIn(List<String> values) {
            addCriterion("PLUGIN_LIBRARY_VERSION not in", values, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionBetween(String value1, String value2) {
            addCriterion("PLUGIN_LIBRARY_VERSION between", value1, value2, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginLibraryVersionNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_LIBRARY_VERSION not between", value1, value2, "pluginLibraryVersion");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorIsNull() {
            addCriterion("PLUGIN_AUTHOR is null");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorIsNotNull() {
            addCriterion("PLUGIN_AUTHOR is not null");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorEqualTo(String value) {
            addCriterion("PLUGIN_AUTHOR =", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorNotEqualTo(String value) {
            addCriterion("PLUGIN_AUTHOR <>", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorGreaterThan(String value) {
            addCriterion("PLUGIN_AUTHOR >", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_AUTHOR >=", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorLessThan(String value) {
            addCriterion("PLUGIN_AUTHOR <", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_AUTHOR <=", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorLike(String value) {
            addCriterion("PLUGIN_AUTHOR like", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorNotLike(String value) {
            addCriterion("PLUGIN_AUTHOR not like", value, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorIn(List<String> values) {
            addCriterion("PLUGIN_AUTHOR in", values, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorNotIn(List<String> values) {
            addCriterion("PLUGIN_AUTHOR not in", values, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorBetween(String value1, String value2) {
            addCriterion("PLUGIN_AUTHOR between", value1, value2, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginAuthorNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_AUTHOR not between", value1, value2, "pluginAuthor");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseIsNull() {
            addCriterion("PLUGIN_LICENSE is null");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseIsNotNull() {
            addCriterion("PLUGIN_LICENSE is not null");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseEqualTo(String value) {
            addCriterion("PLUGIN_LICENSE =", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseNotEqualTo(String value) {
            addCriterion("PLUGIN_LICENSE <>", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseGreaterThan(String value) {
            addCriterion("PLUGIN_LICENSE >", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LICENSE >=", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseLessThan(String value) {
            addCriterion("PLUGIN_LICENSE <", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseLessThanOrEqualTo(String value) {
            addCriterion("PLUGIN_LICENSE <=", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseLike(String value) {
            addCriterion("PLUGIN_LICENSE like", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseNotLike(String value) {
            addCriterion("PLUGIN_LICENSE not like", value, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseIn(List<String> values) {
            addCriterion("PLUGIN_LICENSE in", values, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseNotIn(List<String> values) {
            addCriterion("PLUGIN_LICENSE not in", values, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseBetween(String value1, String value2) {
            addCriterion("PLUGIN_LICENSE between", value1, value2, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andPluginLicenseNotBetween(String value1, String value2) {
            addCriterion("PLUGIN_LICENSE not between", value1, value2, "pluginLicense");
            return (Criteria) this;
        }

        public Criteria andLoadOptionIsNull() {
            addCriterion("LOAD_OPTION is null");
            return (Criteria) this;
        }

        public Criteria andLoadOptionIsNotNull() {
            addCriterion("LOAD_OPTION is not null");
            return (Criteria) this;
        }

        public Criteria andLoadOptionEqualTo(String value) {
            addCriterion("LOAD_OPTION =", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionNotEqualTo(String value) {
            addCriterion("LOAD_OPTION <>", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionGreaterThan(String value) {
            addCriterion("LOAD_OPTION >", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionGreaterThanOrEqualTo(String value) {
            addCriterion("LOAD_OPTION >=", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionLessThan(String value) {
            addCriterion("LOAD_OPTION <", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionLessThanOrEqualTo(String value) {
            addCriterion("LOAD_OPTION <=", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionLike(String value) {
            addCriterion("LOAD_OPTION like", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionNotLike(String value) {
            addCriterion("LOAD_OPTION not like", value, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionIn(List<String> values) {
            addCriterion("LOAD_OPTION in", values, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionNotIn(List<String> values) {
            addCriterion("LOAD_OPTION not in", values, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionBetween(String value1, String value2) {
            addCriterion("LOAD_OPTION between", value1, value2, "loadOption");
            return (Criteria) this;
        }

        public Criteria andLoadOptionNotBetween(String value1, String value2) {
            addCriterion("LOAD_OPTION not between", value1, value2, "loadOption");
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