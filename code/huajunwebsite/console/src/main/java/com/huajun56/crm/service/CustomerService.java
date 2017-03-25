package com.huajun56.crm.service;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Customer;
import com.huajun56.common.exception.ServiceException;

public interface CustomerService {
	

    Pager<Customer> findByPager(Pager<Customer> pager) throws ServiceException;
    
    
    Customer findOne(Integer id) throws ServiceException;
    

    int add(Customer entity) throws ServiceException;
    
  
    int update(Customer entity) throws ServiceException;  

 
    int delete(Integer id) throws ServiceException;

    Customer findByMobile(String fromMobile);
}
