package cn.e3mall.pojo;

import java.io.Serializable;

public class TbGoodsStorage implements Serializable {
    private Long goodsId;

    private Integer storageNum;

    private static final long serialVersionUID = 1L;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }
}