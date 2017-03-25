package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Carrier;
import com.huajun56.common.exception.ServiceException;

public interface CarrierService {
	

    Pager<Carrier> findByPager(Pager<Carrier> pager) throws ServiceException;
    
    
    Carrier findOne(Integer id) throws ServiceException;
    

    int add(Carrier entity) throws ServiceException;
    
  
    int update(Carrier entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

}
