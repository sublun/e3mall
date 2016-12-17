package cn.e3mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbProperty implements Serializable {
    private Long propId;

    private String propName;

    private String inputType;

    private Integer sort;

    private String isNullable;

    private String propGroup;

    private Integer propGroupSort;

    private String isDelete;

    private Long addUser;

    private Date addTime;

    private Long modUser;

    private Date modTime;

    private static final long serialVersionUID = 1L;

    public Long getPropId() {
        return propId;
    }

    public void setPropId(Long propId) {
        this.propId = propId;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName == null ? null : propName.trim();
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType == null ? null : inputType.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable == null ? null : isNullable.trim();
    }

    public String getPropGroup() {
        return propGroup;
    }

    public void setPropGroup(String propGroup) {
        this.propGroup = propGroup == null ? null : propGroup.trim();
    }

    public Integer getPropGroupSort() {
        return propGroupSort;
    }

    public void setPropGroupSort(Integer propGroupSort) {
        this.propGroupSort = propGroupSort;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Long getAddUser() {
        return addUser;
    }

    public void setAddUser(Long addUser) {
        this.addUser = addUser;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getModUser() {
        return modUser;
    }

    public void setModUser(Long modUser) {
        this.modUser = modUser;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }
}