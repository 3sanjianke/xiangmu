package org.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.shop.pojo.RuKu;
import org.shop.pojo.RuKuExample;

public interface RuKuMapper {
    long countByExample(RuKuExample example);

    int deleteByExample(RuKuExample example);

    int deleteByPrimaryKey(Integer rukuId);

    int insert(RuKu record);

    int insertSelective(RuKu record);

    List<RuKu> selectByExample(RuKuExample example);

    RuKu selectByPrimaryKey(Integer rukuId);

    int updateByExampleSelective(@Param("record") RuKu record, @Param("example") RuKuExample example);

    int updateByExample(@Param("record") RuKu record, @Param("example") RuKuExample example);

    int updateByPrimaryKeySelective(RuKu record);

    int updateByPrimaryKey(RuKu record);
    
    List<RuKu> selectByKey(RuKu ruku);
    
    int selectByIdKey(RuKu ruku);
}