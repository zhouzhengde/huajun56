package com.huajun56.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Carrier;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.CarrierMapper;
import com.huajun56.crm.service.CarrierService;



@Component
public class CarrierServiceImpl implements CarrierService {
	
	@Autowired
    private CarrierMapper carrierMapper;

    @Override
    public Pager<Carrier> findByPager(Pager<Carrier> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Carrier>() {
            @Override
            public List<Carrier> query(Carrier entity) throws ServiceException {
                return carrierMapper.find(entity);
            }
        });
    }
    
    @Override
    public Carrier findOne(Integer id) throws ServiceException {
    	try{
    		 return carrierMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Carrier entity) throws ServiceException {
    	try{
    		return carrierMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Carrier entity) throws ServiceException {
    	try{
    		return carrierMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return carrierMapper.deleteByPK(id);
    }
}
