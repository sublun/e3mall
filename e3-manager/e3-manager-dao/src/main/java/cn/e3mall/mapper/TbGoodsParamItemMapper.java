package cn.e3mall.mapper;

import cn.e3mall.pojo.TbGoodsParamItem;
import cn.e3mall.pojo.TbGoodsParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsParamItemMapper {
    int countByExample(TbGoodsParamItemExample example);

    int deleteByExample(TbGoodsParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGoodsParamItem record);

    int insertSelective(TbGoodsParamItem record);

    List<TbGoodsParamItem> selectByExampleWithBLOBs(TbGoodsParamItemExample example);

    List<TbGoodsParamItem> selectByExample(TbGoodsParamItemExample example);

    TbGoodsParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGoodsParamItem record, @Param("example") TbGoodsParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") TbGoodsParamItem record, @Param("example") TbGoodsParamItemExample example);

    int updateByExample(@Param("record") TbGoodsParamItem record, @Param("example") TbGoodsParamItemExample example);

    int updateByPrimaryKeySelective(TbGoodsParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbGoodsParamItem record);

    int updateByPrimaryKey(TbGoodsParamItem record);
}