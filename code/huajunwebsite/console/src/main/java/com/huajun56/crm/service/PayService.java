package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Pay;
import com.huajun56.common.exception.ServiceException;

public interface PayService {
	

    Pager<Pay> findByPager(Pager<Pay> pager) throws ServiceException;
    
    
    Pay findOne(String id) throws ServiceException;
    

    int add(Pay entity) throws ServiceException;
    
  
    int update(Pay entity) throws ServiceException;  

 
    int delete(String id) throws ServiceException;

}
