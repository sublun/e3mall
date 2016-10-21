package cn.e3mall.mapper;

import cn.e3mall.pojo.TbPropertyEnum;
import cn.e3mall.pojo.TbPropertyEnumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPropertyEnumMapper {
    int countByExample(TbPropertyEnumExample example);

    int deleteByExample(TbPropertyEnumExample example);

    int deleteByPrimaryKey(Long propEnumId);

    int insert(TbPropertyEnum record);

    int insertSelective(TbPropertyEnum record);

    List<TbPropertyEnum> selectByExample(TbPropertyEnumExample example);

    TbPropertyEnum selectByPrimaryKey(Long propEnumId);

    int updateByExampleSelective(@Param("record") TbPropertyEnum record, @Param("example") TbPropertyEnumExample example);

    int updateByExample(@Param("record") TbPropertyEnum record, @Param("example") TbPropertyEnumExample example);

    int updateByPrimaryKeySelective(TbPropertyEnum record);

    int updateByPrimaryKey(TbPropertyEnum record);
}