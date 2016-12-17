package cn.e3mall.mapper;

import cn.e3mall.pojo.TbItemStorage;
import cn.e3mall.pojo.TbItemStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbItemStorageMapper {
    int countByExample(TbItemStorageExample example);

    int deleteByExample(TbItemStorageExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(TbItemStorage record);

    int insertSelective(TbItemStorage record);

    List<TbItemStorage> selectByExample(TbItemStorageExample example);

    TbItemStorage selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") TbItemStorage record, @Param("example") TbItemStorageExample example);

    int updateByExample(@Param("record") TbItemStorage record, @Param("example") TbItemStorageExample example);

    int updateByPrimaryKeySelective(TbItemStorage record);

    int updateByPrimaryKey(TbItemStorage record);
}