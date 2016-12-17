package cn.e3mall.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbProductParam implements Serializable {
    private Long id;

    private Long productId;

    private Date created;

    private Date updated;

    private String productParamData;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getProductParamData() {
        return productParamData;
    }

    public void setProductParamData(String productParamData) {
        this.productParamData = productParamData == null ? null : productParamData.trim();
    }
}