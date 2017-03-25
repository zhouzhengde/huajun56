package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Route;
import com.huajun56.common.exception.ServiceException;

public interface RouteService {
	

    Pager<Route> findByPager(Pager<Route> pager) throws ServiceException;
    
    
    Route findOne(Integer id) throws ServiceException;
    

    int add(Route entity) throws ServiceException;
    
  
    int update(Route entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

}
