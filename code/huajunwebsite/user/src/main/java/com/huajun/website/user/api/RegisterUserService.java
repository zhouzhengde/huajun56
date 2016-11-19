package com.huajun.website.user.api;


import com.huajun.website.user.entity.User;
import com.lscsoft.jfa.commons.exception.ServiceException;

/**
 * @author Created by Admin on 2016/7/6.
 * @copyright ${copyright}
 */
public interface RegisterUserService {

    Integer register(User user) throws ServiceException;
}
