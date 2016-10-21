package cn.e3mall.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPropertyExample() {
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

        public Criteria andPropNameIsNull() {
            addCriterion("PROP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPropNameIsNotNull() {
            addCriterion("PROP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPropNameEqualTo(String value) {
            addCriterion("PROP_NAME =", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotEqualTo(String value) {
            addCriterion("PROP_NAME <>", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThan(String value) {
            addCriterion("PROP_NAME >", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_NAME >=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThan(String value) {
            addCriterion("PROP_NAME <", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLessThanOrEqualTo(String value) {
            addCriterion("PROP_NAME <=", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameLike(String value) {
            addCriterion("PROP_NAME like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotLike(String value) {
            addCriterion("PROP_NAME not like", value, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameIn(List<String> values) {
            addCriterion("PROP_NAME in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotIn(List<String> values) {
            addCriterion("PROP_NAME not in", values, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameBetween(String value1, String value2) {
            addCriterion("PROP_NAME between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andPropNameNotBetween(String value1, String value2) {
            addCriterion("PROP_NAME not between", value1, value2, "propName");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNull() {
            addCriterion("INPUT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInputTypeIsNotNull() {
            addCriterion("INPUT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInputTypeEqualTo(String value) {
            addCriterion("INPUT_TYPE =", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotEqualTo(String value) {
            addCriterion("INPUT_TYPE <>", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThan(String value) {
            addCriterion("INPUT_TYPE >", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE >=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThan(String value) {
            addCriterion("INPUT_TYPE <", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLessThanOrEqualTo(String value) {
            addCriterion("INPUT_TYPE <=", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeLike(String value) {
            addCriterion("INPUT_TYPE like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotLike(String value) {
            addCriterion("INPUT_TYPE not like", value, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeIn(List<String> values) {
            addCriterion("INPUT_TYPE in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotIn(List<String> values) {
            addCriterion("INPUT_TYPE not in", values, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andInputTypeNotBetween(String value1, String value2) {
            addCriterion("INPUT_TYPE not between", value1, value2, "inputType");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andIsNullableIsNull() {
            addCriterion("IS_NULLABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsNullableIsNotNull() {
            addCriterion("IS_NULLABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsNullableEqualTo(String value) {
            addCriterion("IS_NULLABLE =", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableNotEqualTo(String value) {
            addCriterion("IS_NULLABLE <>", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableGreaterThan(String value) {
            addCriterion("IS_NULLABLE >", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NULLABLE >=", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableLessThan(String value) {
            addCriterion("IS_NULLABLE <", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableLessThanOrEqualTo(String value) {
            addCriterion("IS_NULLABLE <=", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableLike(String value) {
            addCriterion("IS_NULLABLE like", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableNotLike(String value) {
            addCriterion("IS_NULLABLE not like", value, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableIn(List<String> values) {
            addCriterion("IS_NULLABLE in", values, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableNotIn(List<String> values) {
            addCriterion("IS_NULLABLE not in", values, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableBetween(String value1, String value2) {
            addCriterion("IS_NULLABLE between", value1, value2, "isNullable");
            return (Criteria) this;
        }

        public Criteria andIsNullableNotBetween(String value1, String value2) {
            addCriterion("IS_NULLABLE not between", value1, value2, "isNullable");
            return (Criteria) this;
        }

        public Criteria andPropGroupIsNull() {
            addCriterion("PROP_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andPropGroupIsNotNull() {
            addCriterion("PROP_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andPropGroupEqualTo(String value) {
            addCriterion("PROP_GROUP =", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupNotEqualTo(String value) {
            addCriterion("PROP_GROUP <>", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupGreaterThan(String value) {
            addCriterion("PROP_GROUP >", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupGreaterThanOrEqualTo(String value) {
            addCriterion("PROP_GROUP >=", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupLessThan(String value) {
            addCriterion("PROP_GROUP <", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupLessThanOrEqualTo(String value) {
            addCriterion("PROP_GROUP <=", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupLike(String value) {
            addCriterion("PROP_GROUP like", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupNotLike(String value) {
            addCriterion("PROP_GROUP not like", value, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupIn(List<String> values) {
            addCriterion("PROP_GROUP in", values, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupNotIn(List<String> values) {
            addCriterion("PROP_GROUP not in", values, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupBetween(String value1, String value2) {
            addCriterion("PROP_GROUP between", value1, value2, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupNotBetween(String value1, String value2) {
            addCriterion("PROP_GROUP not between", value1, value2, "propGroup");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortIsNull() {
            addCriterion("PROP_GROUP_SORT is null");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortIsNotNull() {
            addCriterion("PROP_GROUP_SORT is not null");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortEqualTo(Integer value) {
            addCriterion("PROP_GROUP_SORT =", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortNotEqualTo(Integer value) {
            addCriterion("PROP_GROUP_SORT <>", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortGreaterThan(Integer value) {
            addCriterion("PROP_GROUP_SORT >", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROP_GROUP_SORT >=", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortLessThan(Integer value) {
            addCriterion("PROP_GROUP_SORT <", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortLessThanOrEqualTo(Integer value) {
            addCriterion("PROP_GROUP_SORT <=", value, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortIn(List<Integer> values) {
            addCriterion("PROP_GROUP_SORT in", values, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortNotIn(List<Integer> values) {
            addCriterion("PROP_GROUP_SORT not in", values, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortBetween(Integer value1, Integer value2) {
            addCriterion("PROP_GROUP_SORT between", value1, value2, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andPropGroupSortNotBetween(Integer value1, Integer value2) {
            addCriterion("PROP_GROUP_SORT not between", value1, value2, "propGroupSort");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("IS_DELETE like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("IS_DELETE not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andAddUserIsNull() {
            addCriterion("ADD_USER is null");
            return (Criteria) this;
        }

        public Criteria andAddUserIsNotNull() {
            addCriterion("ADD_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserEqualTo(Long value) {
            addCriterion("ADD_USER =", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotEqualTo(Long value) {
            addCriterion("ADD_USER <>", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThan(Long value) {
            addCriterion("ADD_USER >", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThanOrEqualTo(Long value) {
            addCriterion("ADD_USER >=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThan(Long value) {
            addCriterion("ADD_USER <", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThanOrEqualTo(Long value) {
            addCriterion("ADD_USER <=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserIn(List<Long> values) {
            addCriterion("ADD_USER in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotIn(List<Long> values) {
            addCriterion("ADD_USER not in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserBetween(Long value1, Long value2) {
            addCriterion("ADD_USER between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotBetween(Long value1, Long value2) {
            addCriterion("ADD_USER not between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("ADD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("ADD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("ADD_TIME =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("ADD_TIME <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("ADD_TIME >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("ADD_TIME <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("ADD_TIME <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("ADD_TIME in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("ADD_TIME not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("ADD_TIME not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andModUserIsNull() {
            addCriterion("MOD_USER is null");
            return (Criteria) this;
        }

        public Criteria andModUserIsNotNull() {
            addCriterion("MOD_USER is not null");
            return (Criteria) this;
        }

        public Criteria andModUserEqualTo(Long value) {
            addCriterion("MOD_USER =", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotEqualTo(Long value) {
            addCriterion("MOD_USER <>", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserGreaterThan(Long value) {
            addCriterion("MOD_USER >", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserGreaterThanOrEqualTo(Long value) {
            addCriterion("MOD_USER >=", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserLessThan(Long value) {
            addCriterion("MOD_USER <", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserLessThanOrEqualTo(Long value) {
            addCriterion("MOD_USER <=", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserIn(List<Long> values) {
            addCriterion("MOD_USER in", values, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotIn(List<Long> values) {
            addCriterion("MOD_USER not in", values, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserBetween(Long value1, Long value2) {
            addCriterion("MOD_USER between", value1, value2, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotBetween(Long value1, Long value2) {
            addCriterion("MOD_USER not between", value1, value2, "modUser");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNull() {
            addCriterion("MOD_TIME is null");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNotNull() {
            addCriterion("MOD_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andModTimeEqualTo(Date value) {
            addCriterion("MOD_TIME =", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotEqualTo(Date value) {
            addCriterion("MOD_TIME <>", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThan(Date value) {
            addCriterion("MOD_TIME >", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("MOD_TIME >=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThan(Date value) {
            addCriterion("MOD_TIME <", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThanOrEqualTo(Date value) {
            addCriterion("MOD_TIME <=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeIn(List<Date> values) {
            addCriterion("MOD_TIME in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotIn(List<Date> values) {
            addCriterion("MOD_TIME not in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeBetween(Date value1, Date value2) {
            addCriterion("MOD_TIME between", value1, value2, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotBetween(Date value1, Date value2) {
            addCriterion("MOD_TIME not between", value1, value2, "modTime");
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