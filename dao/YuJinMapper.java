package org.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shop.pojo.YuJin;
import org.shop.pojo.YuJinExample;

public interface YuJinMapper {
    long countByExample(YuJinExample example);

    int deleteByExample(YuJinExample example);

    int deleteByPrimaryKey(Integer yujinId);

    int insert(YuJin record);

    int insertSelective(YuJin record);

    List<YuJin> selectByExample(YuJinExample example);

    YuJin selectByPrimaryKey(Integer yujinId);
    
    List<YuJin> selectOne(YuJin yujin);

    int updateByExampleSelective(@Param("record") YuJin record, @Param("example") YuJinExample example);

    int updateByExample(@Param("record") YuJin record, @Param("example") YuJinExample example);

    int updateByPrimaryKeySelective(YuJin record);

    int updateByPrimaryKey(YuJin record);
    
    int updateByKey(YuJin yujin);
    
    int selectByIdKey(YuJin yujin);
}