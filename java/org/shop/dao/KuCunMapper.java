package org.shop.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.shop.pojo.KuCun;
import org.shop.pojo.KuCunExample;

public interface KuCunMapper {
    long countByExample(KuCunExample example);

    int deleteByExample(KuCunExample example);

    int deleteByPrimaryKey(Integer kucunId);

    int insert(KuCun record);

    int insertSelective(KuCun record);

    List<KuCun> selectByExample(KuCunExample example);

    KuCun selectByPrimaryKey(Integer kucunId);
    
    List<String> selectAllNames();
    
    List<String> selectFenlei(String shopName);
    
    List<Integer> selectShuliang(String shopName);
    
    List<KuCun> selectOne(KuCun kucun);
    
    KuCun selectByName(String shopName);

    int updateByExampleSelective(@Param("record") KuCun record, @Param("example") KuCunExample example);

    int updateByExample(@Param("record") KuCun record, @Param("example") KuCunExample example);

    int updateByPrimaryKeySelective(KuCun record);

    int updateByPrimaryKey(KuCun record);
    
    int updateShuliang(KuCun kucun);
    
    int selectByKey(KuCun kucun);
    
    int selectByNameKey(KuCun kucun);
}