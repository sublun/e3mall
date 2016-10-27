package cn.e3mall.mapper;

import cn.e3mall.pojo.TbGoodsCat;
import cn.e3mall.pojo.TbGoodsCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsCatMapper {
    int countByExample(TbGoodsCatExample example);

    int deleteByExample(TbGoodsCatExample example);

    int deleteByPrimaryKey(Long itemCatId);

    int insert(TbGoodsCat record);

    int insertSelective(TbGoodsCat record);

    List<TbGoodsCat> selectByExample(TbGoodsCatExample example);

    TbGoodsCat selectByPrimaryKey(Long itemCatId);

    int updateByExampleSelective(@Param("record") TbGoodsCat record, @Param("example") TbGoodsCatExample example);

    int updateByExample(@Param("record") TbGoodsCat record, @Param("example") TbGoodsCatExample example);

    int updateByPrimaryKeySelective(TbGoodsCat record);

    int updateByPrimaryKey(TbGoodsCat record);
}