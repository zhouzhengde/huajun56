package com.huajun56.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.crm.service.OrderService;
import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Order;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/order")
public class OrderController extends BaseController {
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Order> pager) throws ServiceException {

        return success(orderService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Order entity) throws ServiceException {    	
        return success(orderService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Order entity) throws ServiceException {    	
        return success(orderService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") String id) throws ServiceException {
        
        return success(orderService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") String id) throws ServiceException {
        return success(orderService.findOne(id));
    }	

}
