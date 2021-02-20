package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplexKgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComplexKgExample() {
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

        public Criteria andKgIdIsNull() {
            addCriterion("kg_id is null");
            return (Criteria) this;
        }

        public Criteria andKgIdIsNotNull() {
            addCriterion("kg_id is not null");
            return (Criteria) this;
        }

        public Criteria andKgIdEqualTo(String value) {
            addCriterion("kg_id =", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdNotEqualTo(String value) {
            addCriterion("kg_id <>", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdGreaterThan(String value) {
            addCriterion("kg_id >", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdGreaterThanOrEqualTo(String value) {
            addCriterion("kg_id >=", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdLessThan(String value) {
            addCriterion("kg_id <", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdLessThanOrEqualTo(String value) {
            addCriterion("kg_id <=", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdLike(String value) {
            addCriterion("kg_id like", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdNotLike(String value) {
            addCriterion("kg_id not like", value, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdIn(List<String> values) {
            addCriterion("kg_id in", values, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdNotIn(List<String> values) {
            addCriterion("kg_id not in", values, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdBetween(String value1, String value2) {
            addCriterion("kg_id between", value1, value2, "kgId");
            return (Criteria) this;
        }

        public Criteria andKgIdNotBetween(String value1, String value2) {
            addCriterion("kg_id not between", value1, value2, "kgId");
            return (Criteria) this;
        }

        public Criteria andEntityIsNull() {
            addCriterion("entity is null");
            return (Criteria) this;
        }

        public Criteria andEntityIsNotNull() {
            addCriterion("entity is not null");
            return (Criteria) this;
        }

        public Criteria andEntityEqualTo(String value) {
            addCriterion("entity =", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityNotEqualTo(String value) {
            addCriterion("entity <>", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityGreaterThan(String value) {
            addCriterion("entity >", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityGreaterThanOrEqualTo(String value) {
            addCriterion("entity >=", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityLessThan(String value) {
            addCriterion("entity <", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityLessThanOrEqualTo(String value) {
            addCriterion("entity <=", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityLike(String value) {
            addCriterion("entity like", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityNotLike(String value) {
            addCriterion("entity not like", value, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityIn(List<String> values) {
            addCriterion("entity in", values, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityNotIn(List<String> values) {
            addCriterion("entity not in", values, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityBetween(String value1, String value2) {
            addCriterion("entity between", value1, value2, "entity");
            return (Criteria) this;
        }

        public Criteria andEntityNotBetween(String value1, String value2) {
            addCriterion("entity not between", value1, value2, "entity");
            return (Criteria) this;
        }

        public Criteria andRealtionIsNull() {
            addCriterion("realtion is null");
            return (Criteria) this;
        }

        public Criteria andRealtionIsNotNull() {
            addCriterion("realtion is not null");
            return (Criteria) this;
        }

        public Criteria andRealtionEqualTo(String value) {
            addCriterion("realtion =", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionNotEqualTo(String value) {
            addCriterion("realtion <>", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionGreaterThan(String value) {
            addCriterion("realtion >", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionGreaterThanOrEqualTo(String value) {
            addCriterion("realtion >=", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionLessThan(String value) {
            addCriterion("realtion <", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionLessThanOrEqualTo(String value) {
            addCriterion("realtion <=", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionLike(String value) {
            addCriterion("realtion like", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionNotLike(String value) {
            addCriterion("realtion not like", value, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionIn(List<String> values) {
            addCriterion("realtion in", values, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionNotIn(List<String> values) {
            addCriterion("realtion not in", values, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionBetween(String value1, String value2) {
            addCriterion("realtion between", value1, value2, "realtion");
            return (Criteria) this;
        }

        public Criteria andRealtionNotBetween(String value1, String value2) {
            addCriterion("realtion not between", value1, value2, "realtion");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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