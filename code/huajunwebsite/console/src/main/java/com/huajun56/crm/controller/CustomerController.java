package com.huajun56.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.crm.service.CustomerService;
import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Customer;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/customer")
public class CustomerController extends BaseController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Customer> pager) throws ServiceException {

        return success(customerService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Customer entity) throws ServiceException {    	
        return success(customerService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Customer entity) throws ServiceException {    	
        return success(customerService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Integer id) throws ServiceException {
        
        return success(customerService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") Integer id) throws ServiceException {
        return success(customerService.findOne(id));
    }	

}
