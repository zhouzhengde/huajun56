package com.huajun56.web.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Role;
import com.huajun56.common.exception.ServiceException;

public interface RoleService {
	

    Pager<Role> findByPager(Pager<Role> pager) throws ServiceException;
    
    
    Role findOne(Integer id) throws ServiceException;
    

    int add(Role entity) throws ServiceException;
    
  
    int update(Role entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

}
