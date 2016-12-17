package cn.e3mall.pojo;

import java.io.Serializable;

public class TbReciveAddress implements Serializable {
    private Long id;

    private Long userId;

    private String reciveName;

    private String reciveProvince;

    private String reciveCity;

    private String reciveArea;

    private String reciveAddress;

    private String telphone;

    private String mobile;

    private String email;

    private Byte isdefault;

    private String addrName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReciveName() {
        return reciveName;
    }

    public void setReciveName(String reciveName) {
        this.reciveName = reciveName == null ? null : reciveName.trim();
    }

    public String getReciveProvince() {
        return reciveProvince;
    }

    public void setReciveProvince(String reciveProvince) {
        this.reciveProvince = reciveProvince == null ? null : reciveProvince.trim();
    }

    public String getReciveCity() {
        return reciveCity;
    }

    public void setReciveCity(String reciveCity) {
        this.reciveCity = reciveCity == null ? null : reciveCity.trim();
    }

    public String getReciveArea() {
        return reciveArea;
    }

    public void setReciveArea(String reciveArea) {
        this.reciveArea = reciveArea == null ? null : reciveArea.trim();
    }

    public String getReciveAddress() {
        return reciveAddress;
    }

    public void setReciveAddress(String reciveAddress) {
        this.reciveAddress = reciveAddress == null ? null : reciveAddress.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Byte isdefault) {
        this.isdefault = isdefault;
    }

    public String getAddrName() {
        return addrName;
    }

    public void setAddrName(String addrName) {
        this.addrName = addrName == null ? null : addrName.trim();
    }
}