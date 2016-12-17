package cn.e3mall.pojo;

import java.io.Serializable;

public class TbCategoryBrandKey implements Serializable {
    private Long brandId;

    private Long categoryId;

    private static final long serialVersionUID = 1L;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}