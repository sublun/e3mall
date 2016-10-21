package cn.e3mall.mapper;

import cn.e3mall.pojo.TbGoodsImage;
import cn.e3mall.pojo.TbGoodsImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsImageMapper {
    int countByExample(TbGoodsImageExample example);

    int deleteByExample(TbGoodsImageExample example);

    int deleteByPrimaryKey(Long imgId);

    int insert(TbGoodsImage record);

    int insertSelective(TbGoodsImage record);

    List<TbGoodsImage> selectByExample(TbGoodsImageExample example);

    TbGoodsImage selectByPrimaryKey(Long imgId);

    int updateByExampleSelective(@Param("record") TbGoodsImage record, @Param("example") TbGoodsImageExample example);

    int updateByExample(@Param("record") TbGoodsImage record, @Param("example") TbGoodsImageExample example);

    int updateByPrimaryKeySelective(TbGoodsImage record);

    int updateByPrimaryKey(TbGoodsImage record);
}