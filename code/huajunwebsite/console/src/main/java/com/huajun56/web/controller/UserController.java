package com.huajun56.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.huajun56.web.service.UserService;
import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.User;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.base.BaseController;



@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<User> pager) throws ServiceException {

        return success(userService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody User entity) throws ServiceException {    	
        return success(userService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody User entity) throws ServiceException {    	
        return success(userService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Integer id) throws ServiceException {
        
        return success(userService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") Integer id) throws ServiceException {
        return success(userService.findOne(id));
    }	

}
