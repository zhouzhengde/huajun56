package com.huajun56.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.web.service.RoleService;
import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Role;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/role")
public class RoleController extends BaseController {
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Role> pager) throws ServiceException {

        return success(roleService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Role entity) throws ServiceException {    	
        return success(roleService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Role entity) throws ServiceException {    	
        return success(roleService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Integer id) throws ServiceException {
        
        return success(roleService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") Integer id) throws ServiceException {
        return success(roleService.findOne(id));
    }	

}
