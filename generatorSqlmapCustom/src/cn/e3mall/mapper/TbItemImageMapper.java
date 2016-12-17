package cn.e3mall.mapper;

import cn.e3mall.pojo.TbItemImage;
import cn.e3mall.pojo.TbItemImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemImageMapper {
    int countByExample(TbItemImageExample example);

    int deleteByExample(TbItemImageExample example);

    int deleteByPrimaryKey(Long imgId);

    int insert(TbItemImage record);

    int insertSelective(TbItemImage record);

    List<TbItemImage> selectByExample(TbItemImageExample example);

    TbItemImage selectByPrimaryKey(Long imgId);

    int updateByExampleSelective(@Param("record") TbItemImage record, @Param("example") TbItemImageExample example);

    int updateByExample(@Param("record") TbItemImage record, @Param("example") TbItemImageExample example);

    int updateByPrimaryKeySelective(TbItemImage record);

    int updateByPrimaryKey(TbItemImage record);
}