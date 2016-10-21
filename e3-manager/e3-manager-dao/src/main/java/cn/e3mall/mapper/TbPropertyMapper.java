package cn.e3mall.mapper;

import cn.e3mall.pojo.TbProperty;
import cn.e3mall.pojo.TbPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPropertyMapper {
    int countByExample(TbPropertyExample example);

    int deleteByExample(TbPropertyExample example);

    int deleteByPrimaryKey(Long propId);

    int insert(TbProperty record);

    int insertSelective(TbProperty record);

    List<TbProperty> selectByExample(TbPropertyExample example);

    TbProperty selectByPrimaryKey(Long propId);

    int updateByExampleSelective(@Param("record") TbProperty record, @Param("example") TbPropertyExample example);

    int updateByExample(@Param("record") TbProperty record, @Param("example") TbPropertyExample example);

    int updateByPrimaryKeySelective(TbProperty record);

    int updateByPrimaryKey(TbProperty record);
}