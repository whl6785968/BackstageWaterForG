package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.List;

public class EnpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnpExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNumberIsNull() {
            addCriterion("contacts_number is null");
            return (Criteria) this;
        }

        public Criteria andContactsNumberIsNotNull() {
            addCriterion("contacts_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNumberEqualTo(String value) {
            addCriterion("contacts_number =", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberNotEqualTo(String value) {
            addCriterion("contacts_number <>", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberGreaterThan(String value) {
            addCriterion("contacts_number >", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_number >=", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberLessThan(String value) {
            addCriterion("contacts_number <", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberLessThanOrEqualTo(String value) {
            addCriterion("contacts_number <=", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberLike(String value) {
            addCriterion("contacts_number like", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberNotLike(String value) {
            addCriterion("contacts_number not like", value, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberIn(List<String> values) {
            addCriterion("contacts_number in", values, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberNotIn(List<String> values) {
            addCriterion("contacts_number not in", values, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberBetween(String value1, String value2) {
            addCriterion("contacts_number between", value1, value2, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andContactsNumberNotBetween(String value1, String value2) {
            addCriterion("contacts_number not between", value1, value2, "contactsNumber");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsIsNull() {
            addCriterion("main_pollutions is null");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsIsNotNull() {
            addCriterion("main_pollutions is not null");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsEqualTo(String value) {
            addCriterion("main_pollutions =", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsNotEqualTo(String value) {
            addCriterion("main_pollutions <>", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsGreaterThan(String value) {
            addCriterion("main_pollutions >", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsGreaterThanOrEqualTo(String value) {
            addCriterion("main_pollutions >=", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsLessThan(String value) {
            addCriterion("main_pollutions <", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsLessThanOrEqualTo(String value) {
            addCriterion("main_pollutions <=", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsLike(String value) {
            addCriterion("main_pollutions like", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsNotLike(String value) {
            addCriterion("main_pollutions not like", value, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsIn(List<String> values) {
            addCriterion("main_pollutions in", values, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsNotIn(List<String> values) {
            addCriterion("main_pollutions not in", values, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsBetween(String value1, String value2) {
            addCriterion("main_pollutions between", value1, value2, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andMainPollutionsNotBetween(String value1, String value2) {
            addCriterion("main_pollutions not between", value1, value2, "mainPollutions");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumIsNull() {
            addCriterion("pollutions_num is null");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumIsNotNull() {
            addCriterion("pollutions_num is not null");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumEqualTo(Double value) {
            addCriterion("pollutions_num =", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumNotEqualTo(Double value) {
            addCriterion("pollutions_num <>", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumGreaterThan(Double value) {
            addCriterion("pollutions_num >", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumGreaterThanOrEqualTo(Double value) {
            addCriterion("pollutions_num >=", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumLessThan(Double value) {
            addCriterion("pollutions_num <", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumLessThanOrEqualTo(Double value) {
            addCriterion("pollutions_num <=", value, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumIn(List<Double> values) {
            addCriterion("pollutions_num in", values, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumNotIn(List<Double> values) {
            addCriterion("pollutions_num not in", values, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumBetween(Double value1, Double value2) {
            addCriterion("pollutions_num between", value1, value2, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andPollutionsNumNotBetween(Double value1, Double value2) {
            addCriterion("pollutions_num not between", value1, value2, "pollutionsNum");
            return (Criteria) this;
        }

        public Criteria andIsExceedIsNull() {
            addCriterion("is_exceed is null");
            return (Criteria) this;
        }

        public Criteria andIsExceedIsNotNull() {
            addCriterion("is_exceed is not null");
            return (Criteria) this;
        }

        public Criteria andIsExceedEqualTo(Integer value) {
            addCriterion("is_exceed =", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedNotEqualTo(Integer value) {
            addCriterion("is_exceed <>", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedGreaterThan(Integer value) {
            addCriterion("is_exceed >", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_exceed >=", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedLessThan(Integer value) {
            addCriterion("is_exceed <", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedLessThanOrEqualTo(Integer value) {
            addCriterion("is_exceed <=", value, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedIn(List<Integer> values) {
            addCriterion("is_exceed in", values, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedNotIn(List<Integer> values) {
            addCriterion("is_exceed not in", values, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedBetween(Integer value1, Integer value2) {
            addCriterion("is_exceed between", value1, value2, "isExceed");
            return (Criteria) this;
        }

        public Criteria andIsExceedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_exceed not between", value1, value2, "isExceed");
            return (Criteria) this;
        }

        public Criteria andExceedFactorIsNull() {
            addCriterion("exceed_factor is null");
            return (Criteria) this;
        }

        public Criteria andExceedFactorIsNotNull() {
            addCriterion("exceed_factor is not null");
            return (Criteria) this;
        }

        public Criteria andExceedFactorEqualTo(String value) {
            addCriterion("exceed_factor =", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorNotEqualTo(String value) {
            addCriterion("exceed_factor <>", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorGreaterThan(String value) {
            addCriterion("exceed_factor >", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorGreaterThanOrEqualTo(String value) {
            addCriterion("exceed_factor >=", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorLessThan(String value) {
            addCriterion("exceed_factor <", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorLessThanOrEqualTo(String value) {
            addCriterion("exceed_factor <=", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorLike(String value) {
            addCriterion("exceed_factor like", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorNotLike(String value) {
            addCriterion("exceed_factor not like", value, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorIn(List<String> values) {
            addCriterion("exceed_factor in", values, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorNotIn(List<String> values) {
            addCriterion("exceed_factor not in", values, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorBetween(String value1, String value2) {
            addCriterion("exceed_factor between", value1, value2, "exceedFactor");
            return (Criteria) this;
        }

        public Criteria andExceedFactorNotBetween(String value1, String value2) {
            addCriterion("exceed_factor not between", value1, value2, "exceedFactor");
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