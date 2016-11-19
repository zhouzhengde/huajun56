package com.huajun.website.user.api;

import com.huajun.website.user.entity.User;
import com.lscsoft.jfa.commons.exception.ServiceException;
import com.lscsoft.jfa.data.entity.Pager;

/**
 * @author Created by Admin on 2016/7/6.
 * @copyright ${copyright}
 */
public interface PagingUserService {

    Pager<User> paging(Pager<User> pager) throws ServiceException;

}
