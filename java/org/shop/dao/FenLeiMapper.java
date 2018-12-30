package org.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.shop.pojo.FenLei;
import org.shop.pojo.FenLeiExample;

public interface FenLeiMapper {
    long countByExample(FenLeiExample example);

    int deleteByExample(FenLeiExample example);

    int deleteByPrimaryKey(Integer sortId);

    int insert(FenLei record);

    int insertSelective(FenLei record);

    List<FenLei> selectByExample(FenLeiExample example);
    
    List<String> selectAllNames();
    
    int selectByKey(FenLei fenlei);
    
    int selectByNameKey(FenLei fenlei);
    
    List<FenLei> selectOne(FenLei fenlei);

    FenLei selectByPrimaryKey(Integer sortId);

    int updateByExampleSelective(@Param("record") FenLei record, @Param("example") FenLeiExample example);

    int updateByExample(@Param("record") FenLei record, @Param("example") FenLeiExample example);

    int updateByPrimaryKeySelective(FenLei record);

    int updateByPrimaryKey(FenLei record);
}