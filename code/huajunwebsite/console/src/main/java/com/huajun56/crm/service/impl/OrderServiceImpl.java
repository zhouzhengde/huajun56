package com.huajun56.crm.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Order;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.OrderMapper;
import com.huajun56.crm.service.OrderService;



@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderMapper orderMapper;

    @Override
    public Pager<Order> findByPager(Pager<Order> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Order>() {
            @Override
            public List<Order> query(Order entity) throws ServiceException {
                return orderMapper.find(entity);
            }
        });
    }
    
    @Override
    public Order findOne(String id) throws ServiceException {
    	try{
    		 return orderMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Order entity) throws ServiceException {
    	try{
    	    entity.setId(UUID.randomUUID().toString());
    		return orderMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Order entity) throws ServiceException {
    	try{
    		return orderMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(String id) throws ServiceException {
        return orderMapper.deleteByPK(id);
    }
}
