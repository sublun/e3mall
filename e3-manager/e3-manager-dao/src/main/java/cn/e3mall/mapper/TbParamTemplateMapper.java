package cn.e3mall.mapper;

import cn.e3mall.pojo.TbParamTemplate;
import cn.e3mall.pojo.TbParamTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbParamTemplateMapper {
    int countByExample(TbParamTemplateExample example);

    int deleteByExample(TbParamTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbParamTemplate record);

    int insertSelective(TbParamTemplate record);

    List<TbParamTemplate> selectByExampleWithBLOBs(TbParamTemplateExample example);

    List<TbParamTemplate> selectByExample(TbParamTemplateExample example);

    TbParamTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbParamTemplate record, @Param("example") TbParamTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") TbParamTemplate record, @Param("example") TbParamTemplateExample example);

    int updateByExample(@Param("record") TbParamTemplate record, @Param("example") TbParamTemplateExample example);

    int updateByPrimaryKeySelective(TbParamTemplate record);

    int updateByPrimaryKeyWithBLOBs(TbParamTemplate record);

    int updateByPrimaryKey(TbParamTemplate record);
}