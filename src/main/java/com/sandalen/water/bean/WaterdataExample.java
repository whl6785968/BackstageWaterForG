package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaterdataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterdataExample() {
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

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(Double value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(Double value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(Double value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(Double value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(Double value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(Double value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<Double> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<Double> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(Double value1, Double value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(Double value1, Double value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andDissloveIsNull() {
            addCriterion("disslove is null");
            return (Criteria) this;
        }

        public Criteria andDissloveIsNotNull() {
            addCriterion("disslove is not null");
            return (Criteria) this;
        }

        public Criteria andDissloveEqualTo(Double value) {
            addCriterion("disslove =", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveNotEqualTo(Double value) {
            addCriterion("disslove <>", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveGreaterThan(Double value) {
            addCriterion("disslove >", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveGreaterThanOrEqualTo(Double value) {
            addCriterion("disslove >=", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveLessThan(Double value) {
            addCriterion("disslove <", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveLessThanOrEqualTo(Double value) {
            addCriterion("disslove <=", value, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveIn(List<Double> values) {
            addCriterion("disslove in", values, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveNotIn(List<Double> values) {
            addCriterion("disslove not in", values, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveBetween(Double value1, Double value2) {
            addCriterion("disslove between", value1, value2, "disslove");
            return (Criteria) this;
        }

        public Criteria andDissloveNotBetween(Double value1, Double value2) {
            addCriterion("disslove not between", value1, value2, "disslove");
            return (Criteria) this;
        }

        public Criteria andNhIsNull() {
            addCriterion("nh is null");
            return (Criteria) this;
        }

        public Criteria andNhIsNotNull() {
            addCriterion("nh is not null");
            return (Criteria) this;
        }

        public Criteria andNhEqualTo(Double value) {
            addCriterion("nh =", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhNotEqualTo(Double value) {
            addCriterion("nh <>", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhGreaterThan(Double value) {
            addCriterion("nh >", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhGreaterThanOrEqualTo(Double value) {
            addCriterion("nh >=", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhLessThan(Double value) {
            addCriterion("nh <", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhLessThanOrEqualTo(Double value) {
            addCriterion("nh <=", value, "nh");
            return (Criteria) this;
        }

        public Criteria andNhIn(List<Double> values) {
            addCriterion("nh in", values, "nh");
            return (Criteria) this;
        }

        public Criteria andNhNotIn(List<Double> values) {
            addCriterion("nh not in", values, "nh");
            return (Criteria) this;
        }

        public Criteria andNhBetween(Double value1, Double value2) {
            addCriterion("nh between", value1, value2, "nh");
            return (Criteria) this;
        }

        public Criteria andNhNotBetween(Double value1, Double value2) {
            addCriterion("nh not between", value1, value2, "nh");
            return (Criteria) this;
        }

        public Criteria andKmnoIsNull() {
            addCriterion("kmno is null");
            return (Criteria) this;
        }

        public Criteria andKmnoIsNotNull() {
            addCriterion("kmno is not null");
            return (Criteria) this;
        }

        public Criteria andKmnoEqualTo(Double value) {
            addCriterion("kmno =", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoNotEqualTo(Double value) {
            addCriterion("kmno <>", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoGreaterThan(Double value) {
            addCriterion("kmno >", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoGreaterThanOrEqualTo(Double value) {
            addCriterion("kmno >=", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoLessThan(Double value) {
            addCriterion("kmno <", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoLessThanOrEqualTo(Double value) {
            addCriterion("kmno <=", value, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoIn(List<Double> values) {
            addCriterion("kmno in", values, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoNotIn(List<Double> values) {
            addCriterion("kmno not in", values, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoBetween(Double value1, Double value2) {
            addCriterion("kmno between", value1, value2, "kmno");
            return (Criteria) this;
        }

        public Criteria andKmnoNotBetween(Double value1, Double value2) {
            addCriterion("kmno not between", value1, value2, "kmno");
            return (Criteria) this;
        }

        public Criteria andTotalpIsNull() {
            addCriterion("totalp is null");
            return (Criteria) this;
        }

        public Criteria andTotalpIsNotNull() {
            addCriterion("totalp is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpEqualTo(Double value) {
            addCriterion("totalp =", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpNotEqualTo(Double value) {
            addCriterion("totalp <>", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpGreaterThan(Double value) {
            addCriterion("totalp >", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpGreaterThanOrEqualTo(Double value) {
            addCriterion("totalp >=", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpLessThan(Double value) {
            addCriterion("totalp <", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpLessThanOrEqualTo(Double value) {
            addCriterion("totalp <=", value, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpIn(List<Double> values) {
            addCriterion("totalp in", values, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpNotIn(List<Double> values) {
            addCriterion("totalp not in", values, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpBetween(Double value1, Double value2) {
            addCriterion("totalp between", value1, value2, "totalp");
            return (Criteria) this;
        }

        public Criteria andTotalpNotBetween(Double value1, Double value2) {
            addCriterion("totalp not between", value1, value2, "totalp");
            return (Criteria) this;
        }

        public Criteria andCreateTameIsNull() {
            addCriterion("create_tame is null");
            return (Criteria) this;
        }

        public Criteria andCreateTameIsNotNull() {
            addCriterion("create_tame is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTameEqualTo(Date value) {
            addCriterion("create_tame =", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameNotEqualTo(Date value) {
            addCriterion("create_tame <>", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameGreaterThan(Date value) {
            addCriterion("create_tame >", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameGreaterThanOrEqualTo(Date value) {
            addCriterion("create_tame >=", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameLessThan(Date value) {
            addCriterion("create_tame <", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameLessThanOrEqualTo(Date value) {
            addCriterion("create_tame <=", value, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameIn(List<Date> values) {
            addCriterion("create_tame in", values, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameNotIn(List<Date> values) {
            addCriterion("create_tame not in", values, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameBetween(Date value1, Date value2) {
            addCriterion("create_tame between", value1, value2, "createTame");
            return (Criteria) this;
        }

        public Criteria andCreateTameNotBetween(Date value1, Date value2) {
            addCriterion("create_tame not between", value1, value2, "createTame");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("eid is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("eid is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(String value) {
            addCriterion("eid =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(String value) {
            addCriterion("eid <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(String value) {
            addCriterion("eid >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(String value) {
            addCriterion("eid >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(String value) {
            addCriterion("eid <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(String value) {
            addCriterion("eid <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLike(String value) {
            addCriterion("eid like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotLike(String value) {
            addCriterion("eid not like", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<String> values) {
            addCriterion("eid in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<String> values) {
            addCriterion("eid not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(String value1, String value2) {
            addCriterion("eid between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(String value1, String value2) {
            addCriterion("eid not between", value1, value2, "eid");
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