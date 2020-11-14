package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErrRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrRecordExample() {
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

        public Criteria andRecordIdIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecordIdIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecordIdEqualTo(String value) {
            addCriterion("record_id =", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotEqualTo(String value) {
            addCriterion("record_id <>", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThan(String value) {
            addCriterion("record_id >", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdGreaterThanOrEqualTo(String value) {
            addCriterion("record_id >=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThan(String value) {
            addCriterion("record_id <", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLessThanOrEqualTo(String value) {
            addCriterion("record_id <=", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdLike(String value) {
            addCriterion("record_id like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotLike(String value) {
            addCriterion("record_id not like", value, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdIn(List<String> values) {
            addCriterion("record_id in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotIn(List<String> values) {
            addCriterion("record_id not in", values, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdBetween(String value1, String value2) {
            addCriterion("record_id between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andRecordIdNotBetween(String value1, String value2) {
            addCriterion("record_id not between", value1, value2, "recordId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andEmergencyIsNull() {
            addCriterion("emergency is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyIsNotNull() {
            addCriterion("emergency is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyEqualTo(Integer value) {
            addCriterion("emergency =", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotEqualTo(Integer value) {
            addCriterion("emergency <>", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyGreaterThan(Integer value) {
            addCriterion("emergency >", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("emergency >=", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyLessThan(Integer value) {
            addCriterion("emergency <", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyLessThanOrEqualTo(Integer value) {
            addCriterion("emergency <=", value, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyIn(List<Integer> values) {
            addCriterion("emergency in", values, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotIn(List<Integer> values) {
            addCriterion("emergency not in", values, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyBetween(Integer value1, Integer value2) {
            addCriterion("emergency between", value1, value2, "emergency");
            return (Criteria) this;
        }

        public Criteria andEmergencyNotBetween(Integer value1, Integer value2) {
            addCriterion("emergency not between", value1, value2, "emergency");
            return (Criteria) this;
        }

        public Criteria andChargerIdIsNull() {
            addCriterion("charger_id is null");
            return (Criteria) this;
        }

        public Criteria andChargerIdIsNotNull() {
            addCriterion("charger_id is not null");
            return (Criteria) this;
        }

        public Criteria andChargerIdEqualTo(String value) {
            addCriterion("charger_id =", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotEqualTo(String value) {
            addCriterion("charger_id <>", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdGreaterThan(String value) {
            addCriterion("charger_id >", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdGreaterThanOrEqualTo(String value) {
            addCriterion("charger_id >=", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdLessThan(String value) {
            addCriterion("charger_id <", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdLessThanOrEqualTo(String value) {
            addCriterion("charger_id <=", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdLike(String value) {
            addCriterion("charger_id like", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotLike(String value) {
            addCriterion("charger_id not like", value, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdIn(List<String> values) {
            addCriterion("charger_id in", values, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotIn(List<String> values) {
            addCriterion("charger_id not in", values, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdBetween(String value1, String value2) {
            addCriterion("charger_id between", value1, value2, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerIdNotBetween(String value1, String value2) {
            addCriterion("charger_id not between", value1, value2, "chargerId");
            return (Criteria) this;
        }

        public Criteria andChargerNameIsNull() {
            addCriterion("charger_name is null");
            return (Criteria) this;
        }

        public Criteria andChargerNameIsNotNull() {
            addCriterion("charger_name is not null");
            return (Criteria) this;
        }

        public Criteria andChargerNameEqualTo(String value) {
            addCriterion("charger_name =", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameNotEqualTo(String value) {
            addCriterion("charger_name <>", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameGreaterThan(String value) {
            addCriterion("charger_name >", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameGreaterThanOrEqualTo(String value) {
            addCriterion("charger_name >=", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameLessThan(String value) {
            addCriterion("charger_name <", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameLessThanOrEqualTo(String value) {
            addCriterion("charger_name <=", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameLike(String value) {
            addCriterion("charger_name like", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameNotLike(String value) {
            addCriterion("charger_name not like", value, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameIn(List<String> values) {
            addCriterion("charger_name in", values, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameNotIn(List<String> values) {
            addCriterion("charger_name not in", values, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameBetween(String value1, String value2) {
            addCriterion("charger_name between", value1, value2, "chargerName");
            return (Criteria) this;
        }

        public Criteria andChargerNameNotBetween(String value1, String value2) {
            addCriterion("charger_name not between", value1, value2, "chargerName");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(Integer value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(Integer value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(Integer value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(Integer value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(Integer value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(Integer value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<Integer> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<Integer> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(Integer value1, Integer value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(Integer value1, Integer value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorIsNull() {
            addCriterion("serious_factor is null");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorIsNotNull() {
            addCriterion("serious_factor is not null");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorEqualTo(String value) {
            addCriterion("serious_factor =", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorNotEqualTo(String value) {
            addCriterion("serious_factor <>", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorGreaterThan(String value) {
            addCriterion("serious_factor >", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorGreaterThanOrEqualTo(String value) {
            addCriterion("serious_factor >=", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorLessThan(String value) {
            addCriterion("serious_factor <", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorLessThanOrEqualTo(String value) {
            addCriterion("serious_factor <=", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorLike(String value) {
            addCriterion("serious_factor like", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorNotLike(String value) {
            addCriterion("serious_factor not like", value, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorIn(List<String> values) {
            addCriterion("serious_factor in", values, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorNotIn(List<String> values) {
            addCriterion("serious_factor not in", values, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorBetween(String value1, String value2) {
            addCriterion("serious_factor between", value1, value2, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andSeriousFactorNotBetween(String value1, String value2) {
            addCriterion("serious_factor not between", value1, value2, "seriousFactor");
            return (Criteria) this;
        }

        public Criteria andIsSolveIsNull() {
            addCriterion("is_solve is null");
            return (Criteria) this;
        }

        public Criteria andIsSolveIsNotNull() {
            addCriterion("is_solve is not null");
            return (Criteria) this;
        }

        public Criteria andIsSolveEqualTo(Integer value) {
            addCriterion("is_solve =", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotEqualTo(Integer value) {
            addCriterion("is_solve <>", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveGreaterThan(Integer value) {
            addCriterion("is_solve >", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_solve >=", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveLessThan(Integer value) {
            addCriterion("is_solve <", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveLessThanOrEqualTo(Integer value) {
            addCriterion("is_solve <=", value, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveIn(List<Integer> values) {
            addCriterion("is_solve in", values, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotIn(List<Integer> values) {
            addCriterion("is_solve not in", values, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveBetween(Integer value1, Integer value2) {
            addCriterion("is_solve between", value1, value2, "isSolve");
            return (Criteria) this;
        }

        public Criteria andIsSolveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_solve not between", value1, value2, "isSolve");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
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