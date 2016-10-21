package cn.e3mall.mapper;

import cn.e3mall.pojo.TbGoodsStorage;
import cn.e3mall.pojo.TbGoodsStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsStorageMapper {
    int countByExample(TbGoodsStorageExample example);

    int deleteByExample(TbGoodsStorageExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(TbGoodsStorage record);

    int insertSelective(TbGoodsStorage record);

    List<TbGoodsStorage> selectByExample(TbGoodsStorageExample example);

    TbGoodsStorage selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") TbGoodsStorage record, @Param("example") TbGoodsStorageExample example);

    int updateByExample(@Param("record") TbGoodsStorage record, @Param("example") TbGoodsStorageExample example);

    int updateByPrimaryKeySelective(TbGoodsStorage record);

    int updateByPrimaryKey(TbGoodsStorage record);
}