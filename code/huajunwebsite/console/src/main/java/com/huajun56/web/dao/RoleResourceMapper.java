package com.huajun56.web.dao;

import com.huajun56.web.entity.RoleResource;
import com.huajun56.web.entity.RoleResourceKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleResourceMapper {
    int deleteByPK(RoleResourceKey key);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    RoleResource findByPK(RoleResourceKey key);

    List<RoleResource> find(RoleResource record);

    int updateByPkSelective(RoleResource record);

    int updateByPK(RoleResource record);

    int batchUpdate(@Param("list") List<RoleResource> deleteList);

    int batchInsert(@Param("list") List<RoleResource> insertList);
}