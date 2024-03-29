package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.List;

public class StationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StationExample() {
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

        public Criteria andLongtitudeIsNull() {
            addCriterion("longtitude is null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIsNotNull() {
            addCriterion("longtitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongtitudeEqualTo(Double value) {
            addCriterion("longtitude =", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotEqualTo(Double value) {
            addCriterion("longtitude <>", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThan(Double value) {
            addCriterion("longtitude >", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("longtitude >=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThan(Double value) {
            addCriterion("longtitude <", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeLessThanOrEqualTo(Double value) {
            addCriterion("longtitude <=", value, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeIn(List<Double> values) {
            addCriterion("longtitude in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotIn(List<Double> values) {
            addCriterion("longtitude not in", values, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeBetween(Double value1, Double value2) {
            addCriterion("longtitude between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLongtitudeNotBetween(Double value1, Double value2) {
            addCriterion("longtitude not between", value1, value2, "longtitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(Double value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(Double value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(Double value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(Double value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(Double value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<Double> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<Double> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(Double value1, Double value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(Double value1, Double value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andCurrlevelIsNull() {
            addCriterion("currLevel is null");
            return (Criteria) this;
        }

        public Criteria andCurrlevelIsNotNull() {
            addCriterion("currLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCurrlevelEqualTo(Integer value) {
            addCriterion("currLevel =", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelNotEqualTo(Integer value) {
            addCriterion("currLevel <>", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelGreaterThan(Integer value) {
            addCriterion("currLevel >", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("currLevel >=", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelLessThan(Integer value) {
            addCriterion("currLevel <", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelLessThanOrEqualTo(Integer value) {
            addCriterion("currLevel <=", value, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelIn(List<Integer> values) {
            addCriterion("currLevel in", values, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelNotIn(List<Integer> values) {
            addCriterion("currLevel not in", values, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelBetween(Integer value1, Integer value2) {
            addCriterion("currLevel between", value1, value2, "currlevel");
            return (Criteria) this;
        }

        public Criteria andCurrlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("currLevel not between", value1, value2, "currlevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelIsNull() {
            addCriterion("preLevel is null");
            return (Criteria) this;
        }

        public Criteria andPrelevelIsNotNull() {
            addCriterion("preLevel is not null");
            return (Criteria) this;
        }

        public Criteria andPrelevelEqualTo(Integer value) {
            addCriterion("preLevel =", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelNotEqualTo(Integer value) {
            addCriterion("preLevel <>", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelGreaterThan(Integer value) {
            addCriterion("preLevel >", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("preLevel >=", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelLessThan(Integer value) {
            addCriterion("preLevel <", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelLessThanOrEqualTo(Integer value) {
            addCriterion("preLevel <=", value, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelIn(List<Integer> values) {
            addCriterion("preLevel in", values, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelNotIn(List<Integer> values) {
            addCriterion("preLevel not in", values, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelBetween(Integer value1, Integer value2) {
            addCriterion("preLevel between", value1, value2, "prelevel");
            return (Criteria) this;
        }

        public Criteria andPrelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("preLevel not between", value1, value2, "prelevel");
            return (Criteria) this;
        }

        public Criteria andResponsibleIsNull() {
            addCriterion("responsible is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIsNotNull() {
            addCriterion("responsible is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleEqualTo(String value) {
            addCriterion("responsible =", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotEqualTo(String value) {
            addCriterion("responsible <>", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleGreaterThan(String value) {
            addCriterion("responsible >", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleGreaterThanOrEqualTo(String value) {
            addCriterion("responsible >=", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLessThan(String value) {
            addCriterion("responsible <", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLessThanOrEqualTo(String value) {
            addCriterion("responsible <=", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLike(String value) {
            addCriterion("responsible like", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotLike(String value) {
            addCriterion("responsible not like", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleIn(List<String> values) {
            addCriterion("responsible in", values, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotIn(List<String> values) {
            addCriterion("responsible not in", values, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleBetween(String value1, String value2) {
            addCriterion("responsible between", value1, value2, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotBetween(String value1, String value2) {
            addCriterion("responsible not between", value1, value2, "responsible");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdIsNull() {
            addCriterion("upstream_id is null");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdIsNotNull() {
            addCriterion("upstream_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdEqualTo(String value) {
            addCriterion("upstream_id =", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdNotEqualTo(String value) {
            addCriterion("upstream_id <>", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdGreaterThan(String value) {
            addCriterion("upstream_id >", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdGreaterThanOrEqualTo(String value) {
            addCriterion("upstream_id >=", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdLessThan(String value) {
            addCriterion("upstream_id <", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdLessThanOrEqualTo(String value) {
            addCriterion("upstream_id <=", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdLike(String value) {
            addCriterion("upstream_id like", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdNotLike(String value) {
            addCriterion("upstream_id not like", value, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdIn(List<String> values) {
            addCriterion("upstream_id in", values, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdNotIn(List<String> values) {
            addCriterion("upstream_id not in", values, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdBetween(String value1, String value2) {
            addCriterion("upstream_id between", value1, value2, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andUpstreamIdNotBetween(String value1, String value2) {
            addCriterion("upstream_id not between", value1, value2, "upstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdIsNull() {
            addCriterion("downstream_id is null");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdIsNotNull() {
            addCriterion("downstream_id is not null");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdEqualTo(String value) {
            addCriterion("downstream_id =", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdNotEqualTo(String value) {
            addCriterion("downstream_id <>", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdGreaterThan(String value) {
            addCriterion("downstream_id >", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdGreaterThanOrEqualTo(String value) {
            addCriterion("downstream_id >=", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdLessThan(String value) {
            addCriterion("downstream_id <", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdLessThanOrEqualTo(String value) {
            addCriterion("downstream_id <=", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdLike(String value) {
            addCriterion("downstream_id like", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdNotLike(String value) {
            addCriterion("downstream_id not like", value, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdIn(List<String> values) {
            addCriterion("downstream_id in", values, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdNotIn(List<String> values) {
            addCriterion("downstream_id not in", values, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdBetween(String value1, String value2) {
            addCriterion("downstream_id between", value1, value2, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andDownstreamIdNotBetween(String value1, String value2) {
            addCriterion("downstream_id not between", value1, value2, "downstreamId");
            return (Criteria) this;
        }

        public Criteria andIsAlertIsNull() {
            addCriterion("is_alert is null");
            return (Criteria) this;
        }

        public Criteria andIsAlertIsNotNull() {
            addCriterion("is_alert is not null");
            return (Criteria) this;
        }

        public Criteria andIsAlertEqualTo(Integer value) {
            addCriterion("is_alert =", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotEqualTo(Integer value) {
            addCriterion("is_alert <>", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThan(Integer value) {
            addCriterion("is_alert >", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_alert >=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThan(Integer value) {
            addCriterion("is_alert <", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertLessThanOrEqualTo(Integer value) {
            addCriterion("is_alert <=", value, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertIn(List<Integer> values) {
            addCriterion("is_alert in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotIn(List<Integer> values) {
            addCriterion("is_alert not in", values, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertBetween(Integer value1, Integer value2) {
            addCriterion("is_alert between", value1, value2, "isAlert");
            return (Criteria) this;
        }

        public Criteria andIsAlertNotBetween(Integer value1, Integer value2) {
            addCriterion("is_alert not between", value1, value2, "isAlert");
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