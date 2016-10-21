package cn.e3mall.pojo;

import java.io.Serializable;

public class TbCategoryBrandKey implements Serializable {
    private Long brandId;

    private Long itemCatId;

    private static final long serialVersionUID = 1L;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }
}