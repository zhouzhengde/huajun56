package com.huajun56.web.dao;

import com.huajun56.web.entity.Role;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * web_role
     */
    int deleteByPK(Integer id);

    /**
     * web_role
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * web_role
     */
    int insert(Role record);

    /**
     * web_role
     */
    int insertSelective(Role record);

    /**
     * web_role
     */
    Role findByPK(Integer id);

    /**
     * web_role
     */
    List<Role> find(Role record);

    /**
     * web_role
     */
    int updateByPkSelective(Role record);

    /**
     * web_role
     */
    int updateByPK(Role record);
}