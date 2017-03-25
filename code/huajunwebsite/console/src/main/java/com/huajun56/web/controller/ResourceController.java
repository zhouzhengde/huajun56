package com.huajun56.web.controller;

import com.huajun56.common.base.BaseController;
import com.huajun56.common.entity.Pager;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.entity.Resource;
import com.huajun56.web.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("api/resource")
public class ResourceController extends BaseController {
	
	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<Resource> pager) throws ServiceException {

        return success(resourceService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody Resource entity) throws ServiceException {    	
        return success(resourceService.add(entity));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody Resource entity) throws ServiceException {    	
        return success(resourceService.update(entity));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("id") Integer id) throws ServiceException {
        
        return success(resourceService.delete(id));
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("id") Integer id) throws ServiceException {
        return success(resourceService.findOne(id));
    }

    @RequestMapping(value = "tree", method = RequestMethod.POST)
    public Map<String, Object> tree(@RequestBody Resource entity) throws ServiceException {
        Pager<Resource> pager = new Pager<>();
        entity.setDisabled(false);
        pager.setCondition(entity);
        pager.setPageSize(Integer.MAX_VALUE);
        List<Resource> resources = resourceService.findByPager(pager).getResult();
        return success(resourceService.generateTree(resources));
    }

}
