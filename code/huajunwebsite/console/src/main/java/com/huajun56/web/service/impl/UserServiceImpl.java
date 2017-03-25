package com.huajun56.web.service.impl;

import java.util.List;

import com.huajun56.common.util.$;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.User;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.dao.UserMapper;
import com.huajun56.web.service.UserService;


@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Pager<User> findByPager(Pager<User> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<User>() {
            @Override
            public List<User> query(User entity) throws ServiceException {
                return userMapper.find(entity);
            }
        });
    }

    @Override
    public User findOne(Integer id) throws ServiceException {
        try {
            return userMapper.findByPK(id);
        } catch (Exception e) {
            throw new ServiceException("[Query has error]", e);
        }
    }

    @Override
    public int add(User entity) throws ServiceException {
        try {
            return userMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new ServiceException("[Save has error]", e);
        }
    }

    @Override
    public int update(User entity) throws ServiceException {
        try {
            return userMapper.updateByPkSelective(entity);
        } catch (Exception e) {
            throw new ServiceException("[Update has error]", e);
        }
    }

    @Override
    public int delete(Integer id) throws ServiceException {
        return userMapper.deleteByPK(id);
    }

    @Override
    public User findOne(User user) throws ServiceException {
        try {
            List<User> list = userMapper.find(user);

            if ($.isEmpty(list)) {
                return null;
            }
            return list.get(0);
        } catch (Exception e) {
            throw new ServiceException("[Query has error]", e);
        }
    }
}
