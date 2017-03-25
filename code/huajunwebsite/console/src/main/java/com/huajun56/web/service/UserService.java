package com.huajun56.web.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.User;
import com.huajun56.common.exception.ServiceException;

public interface UserService {


    Pager<User> findByPager(Pager<User> pager) throws ServiceException;


    User findOne(Integer id) throws ServiceException;


    int add(User entity) throws ServiceException;


    int update(User entity) throws ServiceException;


    int delete(Integer id) throws ServiceException;

    User findOne(User user) throws ServiceException;
}
