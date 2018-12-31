package org.shop.pojo;

import java.util.ArrayList;
import java.util.List;

public class YuJinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YuJinExample() {
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

        public Criteria andYujinIdIsNull() {
            addCriterion("yujin_id is null");
            return (Criteria) this;
        }

        public Criteria andYujinIdIsNotNull() {
            addCriterion("yujin_id is not null");
            return (Criteria) this;
        }

        public Criteria andYujinIdEqualTo(Integer value) {
            addCriterion("yujin_id =", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdNotEqualTo(Integer value) {
            addCriterion("yujin_id <>", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdGreaterThan(Integer value) {
            addCriterion("yujin_id >", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("yujin_id >=", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdLessThan(Integer value) {
            addCriterion("yujin_id <", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdLessThanOrEqualTo(Integer value) {
            addCriterion("yujin_id <=", value, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdIn(List<Integer> values) {
            addCriterion("yujin_id in", values, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdNotIn(List<Integer> values) {
            addCriterion("yujin_id not in", values, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdBetween(Integer value1, Integer value2) {
            addCriterion("yujin_id between", value1, value2, "yujinId");
            return (Criteria) this;
        }

        public Criteria andYujinIdNotBetween(Integer value1, Integer value2) {
            addCriterion("yujin_id not between", value1, value2, "yujinId");
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

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangIsNull() {
            addCriterion("yujing_shuliang is null");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangIsNotNull() {
            addCriterion("yujing_shuliang is not null");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangEqualTo(Integer value) {
            addCriterion("yujing_shuliang =", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangNotEqualTo(Integer value) {
            addCriterion("yujing_shuliang <>", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangGreaterThan(Integer value) {
            addCriterion("yujing_shuliang >", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangGreaterThanOrEqualTo(Integer value) {
            addCriterion("yujing_shuliang >=", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangLessThan(Integer value) {
            addCriterion("yujing_shuliang <", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangLessThanOrEqualTo(Integer value) {
            addCriterion("yujing_shuliang <=", value, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangIn(List<Integer> values) {
            addCriterion("yujing_shuliang in", values, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangNotIn(List<Integer> values) {
            addCriterion("yujing_shuliang not in", values, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangBetween(Integer value1, Integer value2) {
            addCriterion("yujing_shuliang between", value1, value2, "yujingShuliang");
            return (Criteria) this;
        }

        public Criteria andYujingShuliangNotBetween(Integer value1, Integer value2) {
            addCriterion("yujing_shuliang not between", value1, value2, "yujingShuliang");
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