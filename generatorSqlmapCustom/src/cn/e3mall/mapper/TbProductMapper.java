package cn.e3mall.mapper;

import cn.e3mall.pojo.TbProduct;
import cn.e3mall.pojo.TbProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProductMapper {
    int countByExample(TbProductExample example);

    int deleteByExample(TbProductExample example);

    int deleteByPrimaryKey(Long prodId);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    List<TbProduct> selectByExampleWithBLOBs(TbProductExample example);

    List<TbProduct> selectByExample(TbProductExample example);

    TbProduct selectByPrimaryKey(Long prodId);

    int updateByExampleSelective(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExample(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKeyWithBLOBs(TbProduct record);

    int updateByPrimaryKey(TbProduct record);
}