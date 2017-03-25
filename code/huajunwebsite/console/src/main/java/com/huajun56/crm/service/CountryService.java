package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Country;
import com.huajun56.common.exception.ServiceException;

public interface CountryService {
	

    Pager<Country> findByPager(Pager<Country> pager) throws ServiceException;
    
    
    Country findOne(Integer id) throws ServiceException;
    

    int add(Country entity) throws ServiceException;
    
  
    int update(Country entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

}
