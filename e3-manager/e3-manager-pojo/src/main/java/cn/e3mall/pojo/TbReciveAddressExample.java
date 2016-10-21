package cn.e3mall.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbReciveAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbReciveAddressExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andReciveNameIsNull() {
            addCriterion("recive_name is null");
            return (Criteria) this;
        }

        public Criteria andReciveNameIsNotNull() {
            addCriterion("recive_name is not null");
            return (Criteria) this;
        }

        public Criteria andReciveNameEqualTo(String value) {
            addCriterion("recive_name =", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameNotEqualTo(String value) {
            addCriterion("recive_name <>", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameGreaterThan(String value) {
            addCriterion("recive_name >", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameGreaterThanOrEqualTo(String value) {
            addCriterion("recive_name >=", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameLessThan(String value) {
            addCriterion("recive_name <", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameLessThanOrEqualTo(String value) {
            addCriterion("recive_name <=", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameLike(String value) {
            addCriterion("recive_name like", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameNotLike(String value) {
            addCriterion("recive_name not like", value, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameIn(List<String> values) {
            addCriterion("recive_name in", values, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameNotIn(List<String> values) {
            addCriterion("recive_name not in", values, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameBetween(String value1, String value2) {
            addCriterion("recive_name between", value1, value2, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveNameNotBetween(String value1, String value2) {
            addCriterion("recive_name not between", value1, value2, "reciveName");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceIsNull() {
            addCriterion("recive_province is null");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceIsNotNull() {
            addCriterion("recive_province is not null");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceEqualTo(String value) {
            addCriterion("recive_province =", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceNotEqualTo(String value) {
            addCriterion("recive_province <>", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceGreaterThan(String value) {
            addCriterion("recive_province >", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("recive_province >=", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceLessThan(String value) {
            addCriterion("recive_province <", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceLessThanOrEqualTo(String value) {
            addCriterion("recive_province <=", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceLike(String value) {
            addCriterion("recive_province like", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceNotLike(String value) {
            addCriterion("recive_province not like", value, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceIn(List<String> values) {
            addCriterion("recive_province in", values, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceNotIn(List<String> values) {
            addCriterion("recive_province not in", values, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceBetween(String value1, String value2) {
            addCriterion("recive_province between", value1, value2, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveProvinceNotBetween(String value1, String value2) {
            addCriterion("recive_province not between", value1, value2, "reciveProvince");
            return (Criteria) this;
        }

        public Criteria andReciveCityIsNull() {
            addCriterion("recive_city is null");
            return (Criteria) this;
        }

        public Criteria andReciveCityIsNotNull() {
            addCriterion("recive_city is not null");
            return (Criteria) this;
        }

        public Criteria andReciveCityEqualTo(String value) {
            addCriterion("recive_city =", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityNotEqualTo(String value) {
            addCriterion("recive_city <>", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityGreaterThan(String value) {
            addCriterion("recive_city >", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityGreaterThanOrEqualTo(String value) {
            addCriterion("recive_city >=", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityLessThan(String value) {
            addCriterion("recive_city <", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityLessThanOrEqualTo(String value) {
            addCriterion("recive_city <=", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityLike(String value) {
            addCriterion("recive_city like", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityNotLike(String value) {
            addCriterion("recive_city not like", value, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityIn(List<String> values) {
            addCriterion("recive_city in", values, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityNotIn(List<String> values) {
            addCriterion("recive_city not in", values, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityBetween(String value1, String value2) {
            addCriterion("recive_city between", value1, value2, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveCityNotBetween(String value1, String value2) {
            addCriterion("recive_city not between", value1, value2, "reciveCity");
            return (Criteria) this;
        }

        public Criteria andReciveAreaIsNull() {
            addCriterion("recive_area is null");
            return (Criteria) this;
        }

        public Criteria andReciveAreaIsNotNull() {
            addCriterion("recive_area is not null");
            return (Criteria) this;
        }

        public Criteria andReciveAreaEqualTo(String value) {
            addCriterion("recive_area =", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaNotEqualTo(String value) {
            addCriterion("recive_area <>", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaGreaterThan(String value) {
            addCriterion("recive_area >", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaGreaterThanOrEqualTo(String value) {
            addCriterion("recive_area >=", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaLessThan(String value) {
            addCriterion("recive_area <", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaLessThanOrEqualTo(String value) {
            addCriterion("recive_area <=", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaLike(String value) {
            addCriterion("recive_area like", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaNotLike(String value) {
            addCriterion("recive_area not like", value, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaIn(List<String> values) {
            addCriterion("recive_area in", values, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaNotIn(List<String> values) {
            addCriterion("recive_area not in", values, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaBetween(String value1, String value2) {
            addCriterion("recive_area between", value1, value2, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAreaNotBetween(String value1, String value2) {
            addCriterion("recive_area not between", value1, value2, "reciveArea");
            return (Criteria) this;
        }

        public Criteria andReciveAddressIsNull() {
            addCriterion("recive_address is null");
            return (Criteria) this;
        }

        public Criteria andReciveAddressIsNotNull() {
            addCriterion("recive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReciveAddressEqualTo(String value) {
            addCriterion("recive_address =", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressNotEqualTo(String value) {
            addCriterion("recive_address <>", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressGreaterThan(String value) {
            addCriterion("recive_address >", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("recive_address >=", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressLessThan(String value) {
            addCriterion("recive_address <", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressLessThanOrEqualTo(String value) {
            addCriterion("recive_address <=", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressLike(String value) {
            addCriterion("recive_address like", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressNotLike(String value) {
            addCriterion("recive_address not like", value, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressIn(List<String> values) {
            addCriterion("recive_address in", values, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressNotIn(List<String> values) {
            addCriterion("recive_address not in", values, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressBetween(String value1, String value2) {
            addCriterion("recive_address between", value1, value2, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andReciveAddressNotBetween(String value1, String value2) {
            addCriterion("recive_address not between", value1, value2, "reciveAddress");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNull() {
            addCriterion("telphone is null");
            return (Criteria) this;
        }

        public Criteria andTelphoneIsNotNull() {
            addCriterion("telphone is not null");
            return (Criteria) this;
        }

        public Criteria andTelphoneEqualTo(String value) {
            addCriterion("telphone =", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotEqualTo(String value) {
            addCriterion("telphone <>", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThan(String value) {
            addCriterion("telphone >", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("telphone >=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThan(String value) {
            addCriterion("telphone <", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLessThanOrEqualTo(String value) {
            addCriterion("telphone <=", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneLike(String value) {
            addCriterion("telphone like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotLike(String value) {
            addCriterion("telphone not like", value, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneIn(List<String> values) {
            addCriterion("telphone in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotIn(List<String> values) {
            addCriterion("telphone not in", values, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneBetween(String value1, String value2) {
            addCriterion("telphone between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andTelphoneNotBetween(String value1, String value2) {
            addCriterion("telphone not between", value1, value2, "telphone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNull() {
            addCriterion("isdefault is null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIsNotNull() {
            addCriterion("isdefault is not null");
            return (Criteria) this;
        }

        public Criteria andIsdefaultEqualTo(Byte value) {
            addCriterion("isdefault =", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotEqualTo(Byte value) {
            addCriterion("isdefault <>", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThan(Byte value) {
            addCriterion("isdefault >", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultGreaterThanOrEqualTo(Byte value) {
            addCriterion("isdefault >=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThan(Byte value) {
            addCriterion("isdefault <", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultLessThanOrEqualTo(Byte value) {
            addCriterion("isdefault <=", value, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultIn(List<Byte> values) {
            addCriterion("isdefault in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotIn(List<Byte> values) {
            addCriterion("isdefault not in", values, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultBetween(Byte value1, Byte value2) {
            addCriterion("isdefault between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andIsdefaultNotBetween(Byte value1, Byte value2) {
            addCriterion("isdefault not between", value1, value2, "isdefault");
            return (Criteria) this;
        }

        public Criteria andAddrNameIsNull() {
            addCriterion("addr_name is null");
            return (Criteria) this;
        }

        public Criteria andAddrNameIsNotNull() {
            addCriterion("addr_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddrNameEqualTo(String value) {
            addCriterion("addr_name =", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameNotEqualTo(String value) {
            addCriterion("addr_name <>", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameGreaterThan(String value) {
            addCriterion("addr_name >", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_name >=", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameLessThan(String value) {
            addCriterion("addr_name <", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameLessThanOrEqualTo(String value) {
            addCriterion("addr_name <=", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameLike(String value) {
            addCriterion("addr_name like", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameNotLike(String value) {
            addCriterion("addr_name not like", value, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameIn(List<String> values) {
            addCriterion("addr_name in", values, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameNotIn(List<String> values) {
            addCriterion("addr_name not in", values, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameBetween(String value1, String value2) {
            addCriterion("addr_name between", value1, value2, "addrName");
            return (Criteria) this;
        }

        public Criteria andAddrNameNotBetween(String value1, String value2) {
            addCriterion("addr_name not between", value1, value2, "addrName");
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