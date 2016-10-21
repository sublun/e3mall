package cn.e3mall.pojo;

import java.io.Serializable;

public class TbPropertyEnum implements Serializable {
    private Long propEnumId;

    private Long propId;

    private String propEnumValue;

    private static final long serialVersionUID = 1L;

    public Long getPropEnumId() {
        return propEnumId;
    }

    public void setPropEnumId(Long propEnumId) {
        this.propEnumId = propEnumId;
    }

    public Long getPropId() {
        return propId;
    }

    public void setPropId(Long propId) {
        this.propId = propId;
    }

    public String getPropEnumValue() {
        return propEnumValue;
    }

    public void setPropEnumValue(String propEnumValue) {
        this.propEnumValue = propEnumValue == null ? null : propEnumValue.trim();
    }
}