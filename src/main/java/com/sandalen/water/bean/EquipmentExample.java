package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EquipmentExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIsNull() {
            addCriterion("productionTime is null");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIsNotNull() {
            addCriterion("productionTime is not null");
            return (Criteria) this;
        }

        public Criteria andProductiontimeEqualTo(Date value) {
            addCriterion("productionTime =", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotEqualTo(Date value) {
            addCriterion("productionTime <>", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeGreaterThan(Date value) {
            addCriterion("productionTime >", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeGreaterThanOrEqualTo(Date value) {
            addCriterion("productionTime >=", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeLessThan(Date value) {
            addCriterion("productionTime <", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeLessThanOrEqualTo(Date value) {
            addCriterion("productionTime <=", value, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeIn(List<Date> values) {
            addCriterion("productionTime in", values, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotIn(List<Date> values) {
            addCriterion("productionTime not in", values, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeBetween(Date value1, Date value2) {
            addCriterion("productionTime between", value1, value2, "productiontime");
            return (Criteria) this;
        }

        public Criteria andProductiontimeNotBetween(Date value1, Date value2) {
            addCriterion("productionTime not between", value1, value2, "productiontime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeIsNull() {
            addCriterion("availableTime is null");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeIsNotNull() {
            addCriterion("availableTime is not null");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeEqualTo(Integer value) {
            addCriterion("availableTime =", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeNotEqualTo(Integer value) {
            addCriterion("availableTime <>", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeGreaterThan(Integer value) {
            addCriterion("availableTime >", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("availableTime >=", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeLessThan(Integer value) {
            addCriterion("availableTime <", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeLessThanOrEqualTo(Integer value) {
            addCriterion("availableTime <=", value, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeIn(List<Integer> values) {
            addCriterion("availableTime in", values, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeNotIn(List<Integer> values) {
            addCriterion("availableTime not in", values, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeBetween(Integer value1, Integer value2) {
            addCriterion("availableTime between", value1, value2, "availabletime");
            return (Criteria) this;
        }

        public Criteria andAvailabletimeNotBetween(Integer value1, Integer value2) {
            addCriterion("availableTime not between", value1, value2, "availabletime");
            return (Criteria) this;
        }

        public Criteria andProductionplaceIsNull() {
            addCriterion("productionPlace is null");
            return (Criteria) this;
        }

        public Criteria andProductionplaceIsNotNull() {
            addCriterion("productionPlace is not null");
            return (Criteria) this;
        }

        public Criteria andProductionplaceEqualTo(String value) {
            addCriterion("productionPlace =", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceNotEqualTo(String value) {
            addCriterion("productionPlace <>", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceGreaterThan(String value) {
            addCriterion("productionPlace >", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceGreaterThanOrEqualTo(String value) {
            addCriterion("productionPlace >=", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceLessThan(String value) {
            addCriterion("productionPlace <", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceLessThanOrEqualTo(String value) {
            addCriterion("productionPlace <=", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceLike(String value) {
            addCriterion("productionPlace like", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceNotLike(String value) {
            addCriterion("productionPlace not like", value, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceIn(List<String> values) {
            addCriterion("productionPlace in", values, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceNotIn(List<String> values) {
            addCriterion("productionPlace not in", values, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceBetween(String value1, String value2) {
            addCriterion("productionPlace between", value1, value2, "productionplace");
            return (Criteria) this;
        }

        public Criteria andProductionplaceNotBetween(String value1, String value2) {
            addCriterion("productionPlace not between", value1, value2, "productionplace");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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