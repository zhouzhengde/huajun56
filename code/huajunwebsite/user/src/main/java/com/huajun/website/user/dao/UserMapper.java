package com.huajun.website.user.dao;

import com.huajun.website.user.entity.User;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteRealByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User user);

    User selectOneBy(User user);

    List<User> selectListBy(User record);

    Integer count(User user);
}
