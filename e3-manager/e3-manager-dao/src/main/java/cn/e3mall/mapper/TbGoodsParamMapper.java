package cn.e3mall.mapper;

import cn.e3mall.pojo.TbGoodsParam;
import cn.e3mall.pojo.TbGoodsParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsParamMapper {
    int countByExample(TbGoodsParamExample example);

    int deleteByExample(TbGoodsParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbGoodsParam record);

    int insertSelective(TbGoodsParam record);

    List<TbGoodsParam> selectByExampleWithBLOBs(TbGoodsParamExample example);

    List<TbGoodsParam> selectByExample(TbGoodsParamExample example);

    TbGoodsParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbGoodsParam record, @Param("example") TbGoodsParamExample example);

    int updateByExampleWithBLOBs(@Param("record") TbGoodsParam record, @Param("example") TbGoodsParamExample example);

    int updateByExample(@Param("record") TbGoodsParam record, @Param("example") TbGoodsParamExample example);

    int updateByPrimaryKeySelective(TbGoodsParam record);

    int updateByPrimaryKeyWithBLOBs(TbGoodsParam record);

    int updateByPrimaryKey(TbGoodsParam record);
}