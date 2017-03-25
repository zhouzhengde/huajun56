package com.huajun56.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Pay;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.PayMapper;
import com.huajun56.crm.service.PayService;



@Component
public class PayServiceImpl implements PayService {
	
	@Autowired
    private PayMapper payMapper;

    @Override
    public Pager<Pay> findByPager(Pager<Pay> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Pay>() {
            @Override
            public List<Pay> query(Pay entity) throws ServiceException {
                return payMapper.find(entity);
            }
        });
    }
    
    @Override
    public Pay findOne(String id) throws ServiceException {
    	try{
    		 return payMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Pay entity) throws ServiceException {
    	try{
    		return payMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Pay entity) throws ServiceException {
    	try{
    		return payMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(String id) throws ServiceException {
        return payMapper.deleteByPK(id);
    }
}
