package com.huajun56.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.crm.service.PayService;
import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Pay;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/pay")
public class PayController extends BaseController {
	
	@Autowired
	private PayService payService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Pay> pager) throws ServiceException {

        return success(payService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Pay entity) throws ServiceException {    	
        return success(payService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Pay entity) throws ServiceException {    	
        return success(payService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") String id) throws ServiceException {
        
        return success(payService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") String id) throws ServiceException {
        return success(payService.findOne(id));
    }	

}
