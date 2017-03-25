package com.huajun56.web.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Resource;
import com.huajun56.web.entity.RoleResource;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.entity.RoleResourceKey;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleResourceService {
	

    Pager<RoleResource> findByPager(Pager<RoleResource> pager) throws ServiceException;
    
    
    RoleResource findOne(RoleResourceKey id) throws ServiceException;
    

    int add(RoleResource entity) throws ServiceException;
    
  
    int update(RoleResource entity) throws ServiceException;  

 
    int delete(RoleResourceKey id) throws ServiceException;


    int save(List<RoleResource> oldList, List<RoleResource> newList) throws ServiceException;

    List<Resource> generateMenuTree() throws ServiceException;
}
