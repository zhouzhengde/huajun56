package com.huajun56.web.controller;

import com.huajun56.common.base.BaseController;
import com.huajun56.common.entity.Pager;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.common.util.$;
import com.huajun56.common.util.ExceptionCode;
import com.huajun56.web.entity.RoleResource;
import com.huajun56.web.entity.RoleResourceKey;
import com.huajun56.web.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("api/roleResource")
public class RoleResourceController extends BaseController {
	
	@Autowired
	private RoleResourceService roleResourceService;
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public Map<String, Object> list(@RequestBody Pager<RoleResource> pager) throws ServiceException {

        return success(roleResourceService.findByPager(pager));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> add(@RequestBody List<RoleResource> roleResourceList) throws ServiceException {

        if ($.isEmpty(roleResourceList)) {
            throw new ServiceException(ExceptionCode.ILLEGAL_PARAMETER.getCode(), "参数为空集！");
        }

        Pager<RoleResource> pager = new Pager();
        pager.setPageSize(Integer.MAX_VALUE);
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(roleResourceList.get(0).getRoleId());
        roleResource.setIsDel(null); //查询所有
        pager.setCondition(roleResource);

        List<RoleResource> oldRoleResourceList = roleResourceService.findByPager(pager).getResult();

        return success(roleResourceService.save(oldRoleResourceList, roleResourceList));
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Map<String, Object> update(@RequestBody RoleResource entity) throws ServiceException {    	
        return success(roleResourceService.update(entity));
    }

    @RequestMapping(value = "{roleId}/{resourceId}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("roleId") Integer roleId,@PathVariable("resourceId") Integer resourceId) throws ServiceException {
        RoleResourceKey roleResourceKey = new RoleResourceKey();
        roleResourceKey.setResourceId(resourceId);
        roleResourceKey.setRoleId(roleId);
        return success(roleResourceService.delete(roleResourceKey));
    }

    @RequestMapping(value = "{roleId}/{resourceId}",  method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable("roleId") Integer roleId,@PathVariable("resourceId") Integer resourceId) throws ServiceException {
        RoleResourceKey roleResourceKey = new RoleResourceKey();
        roleResourceKey.setResourceId(resourceId);
        roleResourceKey.setRoleId(roleId);
        return success(roleResourceService.findOne(roleResourceKey));
    }	

}
