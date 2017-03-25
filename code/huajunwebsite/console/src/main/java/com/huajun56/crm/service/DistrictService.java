package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.District;
import com.huajun56.common.exception.ServiceException;

public interface DistrictService {
	

    Pager<District> findByPager(Pager<District> pager) throws ServiceException;
    
    
    District findOne(Integer id) throws ServiceException;
    

    int add(District entity) throws ServiceException;
    
  
    int update(District entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

}
