package org.shop.pojo;

import java.util.ArrayList;
import java.util.List;

public class FenLeiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FenLeiExample() {
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

        public Criteria andSortIdIsNull() {
            addCriterion("sort_id is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("sort_id is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Integer value) {
            addCriterion("sort_id =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Integer value) {
            addCriterion("sort_id <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Integer value) {
            addCriterion("sort_id >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_id >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Integer value) {
            addCriterion("sort_id <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("sort_id <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Integer> values) {
            addCriterion("sort_id in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Integer> values) {
            addCriterion("sort_id not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Integer value1, Integer value2) {
            addCriterion("sort_id between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_id not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNull() {
            addCriterion("sort_name is null");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNotNull() {
            addCriterion("sort_name is not null");
            return (Criteria) this;
        }

        public Criteria andSortNameEqualTo(String value) {
            addCriterion("sort_name =", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotEqualTo(String value) {
            addCriterion("sort_name <>", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThan(String value) {
            addCriterion("sort_name >", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThanOrEqualTo(String value) {
            addCriterion("sort_name >=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThan(String value) {
            addCriterion("sort_name <", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThanOrEqualTo(String value) {
            addCriterion("sort_name <=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLike(String value) {
            addCriterion("sort_name like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotLike(String value) {
            addCriterion("sort_name not like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameIn(List<String> values) {
            addCriterion("sort_name in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotIn(List<String> values) {
            addCriterion("sort_name not in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameBetween(String value1, String value2) {
            addCriterion("sort_name between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotBetween(String value1, String value2) {
            addCriterion("sort_name not between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortDescribeIsNull() {
            addCriterion("sort_describe is null");
            return (Criteria) this;
        }

        public Criteria andSortDescribeIsNotNull() {
            addCriterion("sort_describe is not null");
            return (Criteria) this;
        }

        public Criteria andSortDescribeEqualTo(String value) {
            addCriterion("sort_describe =", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeNotEqualTo(String value) {
            addCriterion("sort_describe <>", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeGreaterThan(String value) {
            addCriterion("sort_describe >", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("sort_describe >=", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeLessThan(String value) {
            addCriterion("sort_describe <", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeLessThanOrEqualTo(String value) {
            addCriterion("sort_describe <=", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeLike(String value) {
            addCriterion("sort_describe like", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeNotLike(String value) {
            addCriterion("sort_describe not like", value, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeIn(List<String> values) {
            addCriterion("sort_describe in", values, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeNotIn(List<String> values) {
            addCriterion("sort_describe not in", values, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeBetween(String value1, String value2) {
            addCriterion("sort_describe between", value1, value2, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortDescribeNotBetween(String value1, String value2) {
            addCriterion("sort_describe not between", value1, value2, "sortDescribe");
            return (Criteria) this;
        }

        public Criteria andSortRemarkIsNull() {
            addCriterion("sort_remark is null");
            return (Criteria) this;
        }

        public Criteria andSortRemarkIsNotNull() {
            addCriterion("sort_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSortRemarkEqualTo(String value) {
            addCriterion("sort_remark =", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkNotEqualTo(String value) {
            addCriterion("sort_remark <>", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkGreaterThan(String value) {
            addCriterion("sort_remark >", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sort_remark >=", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkLessThan(String value) {
            addCriterion("sort_remark <", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkLessThanOrEqualTo(String value) {
            addCriterion("sort_remark <=", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkLike(String value) {
            addCriterion("sort_remark like", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkNotLike(String value) {
            addCriterion("sort_remark not like", value, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkIn(List<String> values) {
            addCriterion("sort_remark in", values, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkNotIn(List<String> values) {
            addCriterion("sort_remark not in", values, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkBetween(String value1, String value2) {
            addCriterion("sort_remark between", value1, value2, "sortRemark");
            return (Criteria) this;
        }

        public Criteria andSortRemarkNotBetween(String value1, String value2) {
            addCriterion("sort_remark not between", value1, value2, "sortRemark");
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