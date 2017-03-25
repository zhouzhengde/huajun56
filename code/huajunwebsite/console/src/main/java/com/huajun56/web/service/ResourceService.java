package com.huajun56.web.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Resource;
import com.huajun56.common.exception.ServiceException;

import java.util.List;

public interface ResourceService {
	

    Pager<Resource> findByPager(Pager<Resource> pager) throws ServiceException;
    
    
    Resource findOne(Integer id) throws ServiceException;
    

    int add(Resource entity) throws ServiceException;
    
  
    int update(Resource entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

    List<Resource> generateTree(List<Resource> resourceList) throws ServiceException;

}
