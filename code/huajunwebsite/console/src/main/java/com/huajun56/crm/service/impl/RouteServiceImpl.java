package com.huajun56.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Route;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.RouteMapper;
import com.huajun56.crm.service.RouteService;



@Component
public class RouteServiceImpl implements RouteService {
	
	@Autowired
    private RouteMapper routeMapper;

    @Override
    public Pager<Route> findByPager(Pager<Route> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Route>() {
            @Override
            public List<Route> query(Route entity) throws ServiceException {
                return routeMapper.find(entity);
            }
        });
    }
    
    @Override
    public Route findOne(Integer id) throws ServiceException {
    	try{
    		 return routeMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Route entity) throws ServiceException {
    	try{
    		return routeMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Route entity) throws ServiceException {
    	try{
    		return routeMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return routeMapper.deleteByPK(id);
    }
}
