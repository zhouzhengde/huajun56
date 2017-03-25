package com.huajun56.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.District;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.DistrictMapper;
import com.huajun56.crm.service.DistrictService;



@Component
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
    private DistrictMapper districtMapper;

    @Override
    public Pager<District> findByPager(Pager<District> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<District>() {
            @Override
            public List<District> query(District entity) throws ServiceException {
                return districtMapper.find(entity);
            }
        });
    }
    
    @Override
    public District findOne(Integer id) throws ServiceException {
    	try{
    		 return districtMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(District entity) throws ServiceException {
    	try{
    		return districtMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(District entity) throws ServiceException {
    	try{
    		return districtMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return districtMapper.deleteByPK(id);
    }
}
