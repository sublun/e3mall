package cn.e3mall.mapper;

import cn.e3mall.pojo.TbReciveAddress;
import cn.e3mall.pojo.TbReciveAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbReciveAddressMapper {
    int countByExample(TbReciveAddressExample example);

    int deleteByExample(TbReciveAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbReciveAddress record);

    int insertSelective(TbReciveAddress record);

    List<TbReciveAddress> selectByExample(TbReciveAddressExample example);

    TbReciveAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbReciveAddress record, @Param("example") TbReciveAddressExample example);

    int updateByExample(@Param("record") TbReciveAddress record, @Param("example") TbReciveAddressExample example);

    int updateByPrimaryKeySelective(TbReciveAddress record);

    int updateByPrimaryKey(TbReciveAddress record);
}