package org.shop.pojo;

import java.util.ArrayList;
import java.util.List;

public class ChuKuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChuKuExample() {
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

        public Criteria andChukuIdIsNull() {
            addCriterion("chuku_id is null");
            return (Criteria) this;
        }

        public Criteria andChukuIdIsNotNull() {
            addCriterion("chuku_id is not null");
            return (Criteria) this;
        }

        public Criteria andChukuIdEqualTo(Integer value) {
            addCriterion("chuku_id =", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdNotEqualTo(Integer value) {
            addCriterion("chuku_id <>", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdGreaterThan(Integer value) {
            addCriterion("chuku_id >", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuku_id >=", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdLessThan(Integer value) {
            addCriterion("chuku_id <", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdLessThanOrEqualTo(Integer value) {
            addCriterion("chuku_id <=", value, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdIn(List<Integer> values) {
            addCriterion("chuku_id in", values, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdNotIn(List<Integer> values) {
            addCriterion("chuku_id not in", values, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdBetween(Integer value1, Integer value2) {
            addCriterion("chuku_id between", value1, value2, "chukuId");
            return (Criteria) this;
        }

        public Criteria andChukuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("chuku_id not between", value1, value2, "chukuId");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopFenleiIsNull() {
            addCriterion("shop_fenlei is null");
            return (Criteria) this;
        }

        public Criteria andShopFenleiIsNotNull() {
            addCriterion("shop_fenlei is not null");
            return (Criteria) this;
        }

        public Criteria andShopFenleiEqualTo(String value) {
            addCriterion("shop_fenlei =", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiNotEqualTo(String value) {
            addCriterion("shop_fenlei <>", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiGreaterThan(String value) {
            addCriterion("shop_fenlei >", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiGreaterThanOrEqualTo(String value) {
            addCriterion("shop_fenlei >=", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiLessThan(String value) {
            addCriterion("shop_fenlei <", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiLessThanOrEqualTo(String value) {
            addCriterion("shop_fenlei <=", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiLike(String value) {
            addCriterion("shop_fenlei like", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiNotLike(String value) {
            addCriterion("shop_fenlei not like", value, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiIn(List<String> values) {
            addCriterion("shop_fenlei in", values, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiNotIn(List<String> values) {
            addCriterion("shop_fenlei not in", values, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiBetween(String value1, String value2) {
            addCriterion("shop_fenlei between", value1, value2, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andShopFenleiNotBetween(String value1, String value2) {
            addCriterion("shop_fenlei not between", value1, value2, "shopFenlei");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangIsNull() {
            addCriterion("chuku_shuliang is null");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangIsNotNull() {
            addCriterion("chuku_shuliang is not null");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangEqualTo(Integer value) {
            addCriterion("chuku_shuliang =", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangNotEqualTo(Integer value) {
            addCriterion("chuku_shuliang <>", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangGreaterThan(Integer value) {
            addCriterion("chuku_shuliang >", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("chuku_shuliang >=", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangLessThan(Integer value) {
            addCriterion("chuku_shuliang <", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangLessThanOrEqualTo(Integer value) {
            addCriterion("chuku_shuliang <=", value, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangIn(List<Integer> values) {
            addCriterion("chuku_shuliang in", values, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangNotIn(List<Integer> values) {
            addCriterion("chuku_shuliang not in", values, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangBetween(Integer value1, Integer value2) {
            addCriterion("chuku_shuliang between", value1, value2, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuShuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("chuku_shuliang not between", value1, value2, "chukuShuliang");
            return (Criteria) this;
        }

        public Criteria andChukuDateIsNull() {
            addCriterion("chuku_date is null");
            return (Criteria) this;
        }

        public Criteria andChukuDateIsNotNull() {
            addCriterion("chuku_date is not null");
            return (Criteria) this;
        }

        public Criteria andChukuDateEqualTo(String value) {
            addCriterion("chuku_date =", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateNotEqualTo(String value) {
            addCriterion("chuku_date <>", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateGreaterThan(String value) {
            addCriterion("chuku_date >", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateGreaterThanOrEqualTo(String value) {
            addCriterion("chuku_date >=", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateLessThan(String value) {
            addCriterion("chuku_date <", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateLessThanOrEqualTo(String value) {
            addCriterion("chuku_date <=", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateLike(String value) {
            addCriterion("chuku_date like", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateNotLike(String value) {
            addCriterion("chuku_date not like", value, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateIn(List<String> values) {
            addCriterion("chuku_date in", values, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateNotIn(List<String> values) {
            addCriterion("chuku_date not in", values, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateBetween(String value1, String value2) {
            addCriterion("chuku_date between", value1, value2, "chukuDate");
            return (Criteria) this;
        }

        public Criteria andChukuDateNotBetween(String value1, String value2) {
            addCriterion("chuku_date not between", value1, value2, "chukuDate");
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