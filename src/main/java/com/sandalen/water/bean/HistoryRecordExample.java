package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.List;

public class HistoryRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryRecordExample() {
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

        public Criteria andCurrLevelIsNull() {
            addCriterion("curr_level is null");
            return (Criteria) this;
        }

        public Criteria andCurrLevelIsNotNull() {
            addCriterion("curr_level is not null");
            return (Criteria) this;
        }

        public Criteria andCurrLevelEqualTo(Integer value) {
            addCriterion("curr_level =", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelNotEqualTo(Integer value) {
            addCriterion("curr_level <>", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelGreaterThan(Integer value) {
            addCriterion("curr_level >", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("curr_level >=", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelLessThan(Integer value) {
            addCriterion("curr_level <", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelLessThanOrEqualTo(Integer value) {
            addCriterion("curr_level <=", value, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelIn(List<Integer> values) {
            addCriterion("curr_level in", values, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelNotIn(List<Integer> values) {
            addCriterion("curr_level not in", values, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelBetween(Integer value1, Integer value2) {
            addCriterion("curr_level between", value1, value2, "currLevel");
            return (Criteria) this;
        }

        public Criteria andCurrLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("curr_level not between", value1, value2, "currLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelIsNull() {
            addCriterion("pre_level is null");
            return (Criteria) this;
        }

        public Criteria andPreLevelIsNotNull() {
            addCriterion("pre_level is not null");
            return (Criteria) this;
        }

        public Criteria andPreLevelEqualTo(Integer value) {
            addCriterion("pre_level =", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelNotEqualTo(Integer value) {
            addCriterion("pre_level <>", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelGreaterThan(Integer value) {
            addCriterion("pre_level >", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("pre_level >=", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelLessThan(Integer value) {
            addCriterion("pre_level <", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelLessThanOrEqualTo(Integer value) {
            addCriterion("pre_level <=", value, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelIn(List<Integer> values) {
            addCriterion("pre_level in", values, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelNotIn(List<Integer> values) {
            addCriterion("pre_level not in", values, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelBetween(Integer value1, Integer value2) {
            addCriterion("pre_level between", value1, value2, "preLevel");
            return (Criteria) this;
        }

        public Criteria andPreLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("pre_level not between", value1, value2, "preLevel");
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

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(String value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(String value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(String value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(String value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(String value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(String value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLike(String value) {
            addCriterion("did like", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotLike(String value) {
            addCriterion("did not like", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<String> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<String> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(String value1, String value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(String value1, String value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDnameIsNull() {
            addCriterion("dname is null");
            return (Criteria) this;
        }

        public Criteria andDnameIsNotNull() {
            addCriterion("dname is not null");
            return (Criteria) this;
        }

        public Criteria andDnameEqualTo(String value) {
            addCriterion("dname =", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotEqualTo(String value) {
            addCriterion("dname <>", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThan(String value) {
            addCriterion("dname >", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThanOrEqualTo(String value) {
            addCriterion("dname >=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThan(String value) {
            addCriterion("dname <", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThanOrEqualTo(String value) {
            addCriterion("dname <=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLike(String value) {
            addCriterion("dname like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotLike(String value) {
            addCriterion("dname not like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameIn(List<String> values) {
            addCriterion("dname in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotIn(List<String> values) {
            addCriterion("dname not in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameBetween(String value1, String value2) {
            addCriterion("dname between", value1, value2, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotBetween(String value1, String value2) {
            addCriterion("dname not between", value1, value2, "dname");
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

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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