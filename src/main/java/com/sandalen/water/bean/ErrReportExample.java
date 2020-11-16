package com.sandalen.water.bean;

import java.util.ArrayList;
import java.util.List;

public class ErrReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ErrReportExample() {
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

        public Criteria andReportIdIsNull() {
            addCriterion("report_id is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("report_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("report_id =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("report_id <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("report_id >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("report_id >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("report_id <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("report_id <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("report_id like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("report_id not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("report_id in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("report_id not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("report_id between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("report_id not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andBasinErrorIsNull() {
            addCriterion("basin_error is null");
            return (Criteria) this;
        }

        public Criteria andBasinErrorIsNotNull() {
            addCriterion("basin_error is not null");
            return (Criteria) this;
        }

        public Criteria andBasinErrorEqualTo(String value) {
            addCriterion("basin_error =", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorNotEqualTo(String value) {
            addCriterion("basin_error <>", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorGreaterThan(String value) {
            addCriterion("basin_error >", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorGreaterThanOrEqualTo(String value) {
            addCriterion("basin_error >=", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorLessThan(String value) {
            addCriterion("basin_error <", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorLessThanOrEqualTo(String value) {
            addCriterion("basin_error <=", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorLike(String value) {
            addCriterion("basin_error like", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorNotLike(String value) {
            addCriterion("basin_error not like", value, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorIn(List<String> values) {
            addCriterion("basin_error in", values, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorNotIn(List<String> values) {
            addCriterion("basin_error not in", values, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorBetween(String value1, String value2) {
            addCriterion("basin_error between", value1, value2, "basinError");
            return (Criteria) this;
        }

        public Criteria andBasinErrorNotBetween(String value1, String value2) {
            addCriterion("basin_error not between", value1, value2, "basinError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorIsNull() {
            addCriterion("enterprise_error is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorIsNotNull() {
            addCriterion("enterprise_error is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorEqualTo(String value) {
            addCriterion("enterprise_error =", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorNotEqualTo(String value) {
            addCriterion("enterprise_error <>", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorGreaterThan(String value) {
            addCriterion("enterprise_error >", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_error >=", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorLessThan(String value) {
            addCriterion("enterprise_error <", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorLessThanOrEqualTo(String value) {
            addCriterion("enterprise_error <=", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorLike(String value) {
            addCriterion("enterprise_error like", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorNotLike(String value) {
            addCriterion("enterprise_error not like", value, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorIn(List<String> values) {
            addCriterion("enterprise_error in", values, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorNotIn(List<String> values) {
            addCriterion("enterprise_error not in", values, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorBetween(String value1, String value2) {
            addCriterion("enterprise_error between", value1, value2, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andEnterpriseErrorNotBetween(String value1, String value2) {
            addCriterion("enterprise_error not between", value1, value2, "enterpriseError");
            return (Criteria) this;
        }

        public Criteria andFactorResultIsNull() {
            addCriterion("factor_result is null");
            return (Criteria) this;
        }

        public Criteria andFactorResultIsNotNull() {
            addCriterion("factor_result is not null");
            return (Criteria) this;
        }

        public Criteria andFactorResultEqualTo(String value) {
            addCriterion("factor_result =", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultNotEqualTo(String value) {
            addCriterion("factor_result <>", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultGreaterThan(String value) {
            addCriterion("factor_result >", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultGreaterThanOrEqualTo(String value) {
            addCriterion("factor_result >=", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultLessThan(String value) {
            addCriterion("factor_result <", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultLessThanOrEqualTo(String value) {
            addCriterion("factor_result <=", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultLike(String value) {
            addCriterion("factor_result like", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultNotLike(String value) {
            addCriterion("factor_result not like", value, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultIn(List<String> values) {
            addCriterion("factor_result in", values, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultNotIn(List<String> values) {
            addCriterion("factor_result not in", values, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultBetween(String value1, String value2) {
            addCriterion("factor_result between", value1, value2, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorResultNotBetween(String value1, String value2) {
            addCriterion("factor_result not between", value1, value2, "factorResult");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionIsNull() {
            addCriterion("factor_solution is null");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionIsNotNull() {
            addCriterion("factor_solution is not null");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionEqualTo(String value) {
            addCriterion("factor_solution =", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionNotEqualTo(String value) {
            addCriterion("factor_solution <>", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionGreaterThan(String value) {
            addCriterion("factor_solution >", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionGreaterThanOrEqualTo(String value) {
            addCriterion("factor_solution >=", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionLessThan(String value) {
            addCriterion("factor_solution <", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionLessThanOrEqualTo(String value) {
            addCriterion("factor_solution <=", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionLike(String value) {
            addCriterion("factor_solution like", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionNotLike(String value) {
            addCriterion("factor_solution not like", value, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionIn(List<String> values) {
            addCriterion("factor_solution in", values, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionNotIn(List<String> values) {
            addCriterion("factor_solution not in", values, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionBetween(String value1, String value2) {
            addCriterion("factor_solution between", value1, value2, "factorSolution");
            return (Criteria) this;
        }

        public Criteria andFactorSolutionNotBetween(String value1, String value2) {
            addCriterion("factor_solution not between", value1, value2, "factorSolution");
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