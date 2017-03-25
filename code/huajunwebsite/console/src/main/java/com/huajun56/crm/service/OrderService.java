package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Order;
import com.huajun56.common.exception.ServiceException;

public interface OrderService {
	

    Pager<Order> findByPager(Pager<Order> pager) throws ServiceException;
    
    
    Order findOne(String id) throws ServiceException;
    

    int add(Order entity) throws ServiceException;
    
  
    int update(Order entity) throws ServiceException;  

 
    int delete(String id) throws ServiceException;

}
