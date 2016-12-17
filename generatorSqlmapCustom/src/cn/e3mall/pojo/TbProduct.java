package cn.e3mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbProduct implements Serializable {
    private Long prodId;

    private Long categoryId;

    private Long brandId;

    private String prodName;

    private String adWord;

    private String packagingList;

    private String afterSaleService;

    private BigDecimal stockWarning;

    private BigDecimal weight;

    private BigDecimal volume;

    private String templateId;

    private String isDelete;

    private Long addUserId;

    private Date addTime;

    private Long modUserId;

    private Date modTime;

    private String prodDesc;

    private static final long serialVersionUID = 1L;

    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName == null ? null : prodName.trim();
    }

    public String getAdWord() {
        return adWord;
    }

    public void setAdWord(String adWord) {
        this.adWord = adWord == null ? null : adWord.trim();
    }

    public String getPackagingList() {
        return packagingList;
    }

    public void setPackagingList(String packagingList) {
        this.packagingList = packagingList == null ? null : packagingList.trim();
    }

    public String getAfterSaleService() {
        return afterSaleService;
    }

    public void setAfterSaleService(String afterSaleService) {
        this.afterSaleService = afterSaleService == null ? null : afterSaleService.trim();
    }

    public BigDecimal getStockWarning() {
        return stockWarning;
    }

    public void setStockWarning(BigDecimal stockWarning) {
        this.stockWarning = stockWarning;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Long getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(Long addUserId) {
        this.addUserId = addUserId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getModUserId() {
        return modUserId;
    }

    public void setModUserId(Long modUserId) {
        this.modUserId = modUserId;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc == null ? null : prodDesc.trim();
    }
}