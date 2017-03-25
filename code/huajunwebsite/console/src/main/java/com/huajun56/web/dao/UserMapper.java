package com.huajun56.web.dao;

import com.huajun56.web.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * web_user
     */
    int deleteByPK(Integer id);

    /**
     * web_user
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * web_user
     */
    int insert(User record);

    /**
     * web_user
     */
    int insertSelective(User record);

    /**
     * web_user
     */
    User findByPK(Integer id);

    /**
     * web_user
     */
    List<User> find(User record);

    /**
     * web_user
     */
    int updateByPkSelective(User record);

    /**
     * web_user
     */
    int updateByPkWithBLOBs(User record);

    /**
     * web_user
     */
    int updateByPK(User record);
}