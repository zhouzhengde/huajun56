package com.huajun56.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Role;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.dao.RoleMapper;
import com.huajun56.web.service.RoleService;



@Component
public class RoleServiceImpl implements RoleService {
	
	@Autowired
    private RoleMapper roleMapper;

    @Override
    public Pager<Role> findByPager(Pager<Role> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Role>() {
            @Override
            public List<Role> query(Role entity) throws ServiceException {
                return roleMapper.find(entity);
            }
        });
    }
    
    @Override
    public Role findOne(Integer id) throws ServiceException {
    	try{
    		 return roleMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Role entity) throws ServiceException {
    	try{
    		return roleMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Role entity) throws ServiceException {
    	try{
    		return roleMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return roleMapper.deleteByPK(id);
    }
}
