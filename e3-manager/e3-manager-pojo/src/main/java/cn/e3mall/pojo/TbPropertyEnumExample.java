package cn.e3mall.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbPropertyEnumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPropertyEnumExample() {
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

        public Criteria andPropEnumIdIsNull() {
            addCriterion("PROP_ENUM_ID is null");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdIsNotNull() {
            addCriterion("PROP_ENUM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdEqualTo(Long value) {
            addCriterion("PROP_ENUM_ID =", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdNotEqualTo(Long value) {
            addCriterion("PROP_ENUM_ID <>", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdGreaterThan(Long value) {
            addCriterion("PROP_ENUM_ID >", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROP_ENUM_ID >=", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdLessThan(Long value) {
            addCriterion("PROP_ENUM_ID <", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdLessThanOrEqualTo(Long value) {
            addCriterion("PROP_ENUM_ID <=", value, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdIn(List<Long> values) {
            addCriterion("PROP_ENUM_ID in", values, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdNotIn(List<Long> values) {
            addCriterion("PROP_ENUM_ID not in", values, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdBetween(Long value1, Long value2) {
            addCriterion("PROP_ENUM_ID between", value1, value2, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropEnumIdNotBetween(Long value1, Long value2) {
            addCriterion("PROP_ENUM_ID not between", value1, value2, "propEnumId");
            return (Criteria) this;
        }

        public Criteria andPropIdIsNull() {
            addCriterion("PROP_ID is null");
            return (Criteria) this;
        }

        public Criteria andPropIdIsNotNull() {
            addCriterion("PROP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPropIdEqualTo(Long value) {
            addCriterion("PROP_ID =", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotEqualTo(Long value) {
            addCriterion("PROP_ID <>", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThan(Long value) {
            addCriterion("PROP_ID >", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PROP_ID >=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThan(Long value) {
            addCriterion("PROP_ID <", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdLessThanOrEqualTo(Long value) {
            addCriterion("PROP_ID <=", value, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdIn(List<Long> values) {
            addCriterion("PROP_ID in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotIn(List<Long> values) {
            addCriterion("PROP_ID not in", values, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdBetween(Long value1, Long value2) {
            addCriterion("PROP_ID between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropIdNotBetween(Long value1, Long value2) {
            addCriterion("PROP_ID not between", value1, value2, "propId");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueIsNull() {
            addCriterion("PROP_ENUM_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueIsNotNull() {
            addCriterion("PROP_ENUM_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueEqualTo(String value) {
            addCriterion("PROP_ENUM_VALUE =", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueNotEqualTo(String value) {
            addCriterion("PROP_ENUM_VALUE <>", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueGreaterThan(String value) {
            addCriterion("PROP_ENUM_VALUE >", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_ENUM_VALUE >=", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueLessThan(String value) {
            addCriterion("PROP_ENUM_VALUE <", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueLessThanOrEqualTo(String value) {
            addCriterion("PROP_ENUM_VALUE <=", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueLike(String value) {
            addCriterion("PROP_ENUM_VALUE like", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueNotLike(String value) {
            addCriterion("PROP_ENUM_VALUE not like", value, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueIn(List<String> values) {
            addCriterion("PROP_ENUM_VALUE in", values, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueNotIn(List<String> values) {
            addCriterion("PROP_ENUM_VALUE not in", values, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueBetween(String value1, String value2) {
            addCriterion("PROP_ENUM_VALUE between", value1, value2, "propEnumValue");
            return (Criteria) this;
        }

        public Criteria andPropEnumValueNotBetween(String value1, String value2) {
            addCriterion("PROP_ENUM_VALUE not between", value1, value2, "propEnumValue");
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