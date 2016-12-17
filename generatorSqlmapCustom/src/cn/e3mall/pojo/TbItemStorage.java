package cn.e3mall.pojo;

import java.io.Serializable;

public class TbItemStorage implements Serializable {
    private Long itemId;

    private Integer storageNum;

    private static final long serialVersionUID = 1L;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getStorageNum() {
        return storageNum;
    }

    public void setStorageNum(Integer storageNum) {
        this.storageNum = storageNum;
    }
}