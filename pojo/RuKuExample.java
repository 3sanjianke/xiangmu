package org.shop.pojo;

import java.util.ArrayList;
import java.util.List;

public class RuKuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RuKuExample() {
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

        public Criteria andRukuIdIsNull() {
            addCriterion("ruku_id is null");
            return (Criteria) this;
        }

        public Criteria andRukuIdIsNotNull() {
            addCriterion("ruku_id is not null");
            return (Criteria) this;
        }

        public Criteria andRukuIdEqualTo(Integer value) {
            addCriterion("ruku_id =", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdNotEqualTo(Integer value) {
            addCriterion("ruku_id <>", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdGreaterThan(Integer value) {
            addCriterion("ruku_id >", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ruku_id >=", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdLessThan(Integer value) {
            addCriterion("ruku_id <", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdLessThanOrEqualTo(Integer value) {
            addCriterion("ruku_id <=", value, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdIn(List<Integer> values) {
            addCriterion("ruku_id in", values, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdNotIn(List<Integer> values) {
            addCriterion("ruku_id not in", values, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdBetween(Integer value1, Integer value2) {
            addCriterion("ruku_id between", value1, value2, "rukuId");
            return (Criteria) this;
        }

        public Criteria andRukuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ruku_id not between", value1, value2, "rukuId");
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

        public Criteria andRukuShuliangIsNull() {
            addCriterion("ruku_shuliang is null");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangIsNotNull() {
            addCriterion("ruku_shuliang is not null");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangEqualTo(Integer value) {
            addCriterion("ruku_shuliang =", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangNotEqualTo(Integer value) {
            addCriterion("ruku_shuliang <>", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangGreaterThan(Integer value) {
            addCriterion("ruku_shuliang >", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("ruku_shuliang >=", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangLessThan(Integer value) {
            addCriterion("ruku_shuliang <", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangLessThanOrEqualTo(Integer value) {
            addCriterion("ruku_shuliang <=", value, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangIn(List<Integer> values) {
            addCriterion("ruku_shuliang in", values, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangNotIn(List<Integer> values) {
            addCriterion("ruku_shuliang not in", values, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangBetween(Integer value1, Integer value2) {
            addCriterion("ruku_shuliang between", value1, value2, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuShuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("ruku_shuliang not between", value1, value2, "rukuShuliang");
            return (Criteria) this;
        }

        public Criteria andRukuDataIsNull() {
            addCriterion("ruku_data is null");
            return (Criteria) this;
        }

        public Criteria andRukuDataIsNotNull() {
            addCriterion("ruku_data is not null");
            return (Criteria) this;
        }

        public Criteria andRukuDataEqualTo(String value) {
            addCriterion("ruku_data =", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataNotEqualTo(String value) {
            addCriterion("ruku_data <>", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataGreaterThan(String value) {
            addCriterion("ruku_data >", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataGreaterThanOrEqualTo(String value) {
            addCriterion("ruku_data >=", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataLessThan(String value) {
            addCriterion("ruku_data <", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataLessThanOrEqualTo(String value) {
            addCriterion("ruku_data <=", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataLike(String value) {
            addCriterion("ruku_data like", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataNotLike(String value) {
            addCriterion("ruku_data not like", value, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataIn(List<String> values) {
            addCriterion("ruku_data in", values, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataNotIn(List<String> values) {
            addCriterion("ruku_data not in", values, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataBetween(String value1, String value2) {
            addCriterion("ruku_data between", value1, value2, "rukuData");
            return (Criteria) this;
        }

        public Criteria andRukuDataNotBetween(String value1, String value2) {
            addCriterion("ruku_data not between", value1, value2, "rukuData");
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