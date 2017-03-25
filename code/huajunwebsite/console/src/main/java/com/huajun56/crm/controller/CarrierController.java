package com.huajun56.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.crm.service.CarrierService;
import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Carrier;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/carrier")
public class CarrierController extends BaseController {
	
	@Autowired
	private CarrierService carrierService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Carrier> pager) throws ServiceException {

        return success(carrierService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Carrier entity) throws ServiceException {    	
        return success(carrierService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Carrier entity) throws ServiceException {    	
        return success(carrierService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Integer id) throws ServiceException {
        
        return success(carrierService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") Integer id) throws ServiceException {
        return success(carrierService.findOne(id));
    }	

}
