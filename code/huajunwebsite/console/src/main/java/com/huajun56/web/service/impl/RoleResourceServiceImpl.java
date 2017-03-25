package com.huajun56.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.huajun56.common.util.$;
import com.huajun56.common.util.Constants;
import com.huajun56.shiro.entity.ShiroUser;
import com.huajun56.web.entity.PermissionObject;
import com.huajun56.web.entity.Resource;
import com.huajun56.web.entity.RoleResourceKey;
import com.huajun56.web.service.ResourceService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.RoleResource;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.dao.RoleResourceMapper;
import com.huajun56.web.service.RoleResourceService;
import org.springframework.transaction.annotation.Transactional;


@Component
public class RoleResourceServiceImpl implements RoleResourceService {
	
	@Autowired
    private RoleResourceMapper roleResourceMapper;

    @Autowired
    private ResourceService resourceService;



    @Override
    public Pager<RoleResource> findByPager(Pager<RoleResource> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<RoleResource>() {
            @Override
            public List<RoleResource> query(RoleResource entity) throws ServiceException {
                return roleResourceMapper.find(entity);
            }
        });
    }
    
    @Override
    public RoleResource findOne(RoleResourceKey id) throws ServiceException {
    	try{
    		 return roleResourceMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(RoleResource entity) throws ServiceException {
    	try{
    		return roleResourceMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(RoleResource entity) throws ServiceException {
    	try{
    		return roleResourceMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(RoleResourceKey id) throws ServiceException {
        return roleResourceMapper.deleteByPK(id);
    }

    @Override
    @Transactional
    public int save(List<RoleResource> oldList, List<RoleResource> newList) throws ServiceException {

        List<RoleResource> updateList = (List<RoleResource>) CollectionUtils.intersection(newList, oldList);
        List<RoleResource> insertList = (List<RoleResource>) CollectionUtils.subtract(newList, oldList);
        List<RoleResource> deleteList = (List<RoleResource>) CollectionUtils.subtract(oldList, newList);

        for (RoleResource roleResource : updateList) {
            roleResource.setIsDel(false);
        }
        for (RoleResource roleResource : deleteList) {
            roleResource.setIsDel(true);
        }

        if (!$.isEmpty(deleteList)) {
            roleResourceMapper.batchUpdate(deleteList);
        }
        if (!$.isEmpty(updateList)) {
            roleResourceMapper.batchUpdate(updateList);
        }
        if (!$.isEmpty(insertList)) {
            return roleResourceMapper.batchInsert(insertList);
        }
        return Constants.METHOD_EXEC_OK;
    }

    @Override
    public List<Resource> generateMenuTree() throws ServiceException {

        List<RoleResource> roleResources = ShiroUser.getSessionUser().getRole().getRoleResourceList();
        if ($.isEmpty(roleResources)) {
            return null;
        }

        List<Resource> resources = new ArrayList<>();
        for (RoleResource roleRes : roleResources) {
            PermissionObject permissionObject = roleRes.getPermissionObject();
            Resource res = roleRes.getResource();
            if($.isNull(res) || $.isNull(permissionObject)){
                continue;
            }
            if (!roleRes.getIsDel() && permissionObject.getAccess() && $.isEqual(res.getType(), 0) && !res.getDisabled()) {
                resources.add(res);
            }
        }
        return resourceService.generateTree(resources);
    }

}
