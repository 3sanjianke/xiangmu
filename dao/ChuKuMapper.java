package org.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shop.pojo.ChuKu;
import org.shop.pojo.ChuKuExample;

public interface ChuKuMapper {
    long countByExample(ChuKuExample example);

    int deleteByExample(ChuKuExample example);

    int deleteByPrimaryKey(Integer chukuId);

    int insert(ChuKu record);

    int insertSelective(ChuKu record);

    List<ChuKu> selectByExample(ChuKuExample example);

    ChuKu selectByPrimaryKey(Integer chukuId);
    
    List<ChuKu> selectOne(ChuKu chuku);

    int updateByExampleSelective(@Param("record") ChuKu record, @Param("example") ChuKuExample example);

    int updateByExample(@Param("record") ChuKu record, @Param("example") ChuKuExample example);

    int updateByPrimaryKeySelective(ChuKu record);

    int updateByPrimaryKey(ChuKu record);
    
    int selectByIdKey(ChuKu chuku);
}