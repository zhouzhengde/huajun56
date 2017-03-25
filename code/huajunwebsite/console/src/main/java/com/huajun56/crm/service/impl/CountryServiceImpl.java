package com.huajun56.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Country;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.CountryMapper;
import com.huajun56.crm.service.CountryService;



@Component
public class CountryServiceImpl implements CountryService {
	
	@Autowired
    private CountryMapper countryMapper;

    @Override
    public Pager<Country> findByPager(Pager<Country> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Country>() {
            @Override
            public List<Country> query(Country entity) throws ServiceException {
                return countryMapper.find(entity);
            }
        });
    }
    
    @Override
    public Country findOne(Integer id) throws ServiceException {
    	try{
    		 return countryMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Country entity) throws ServiceException {
    	try{
    		return countryMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Country entity) throws ServiceException {
    	try{
    		return countryMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return countryMapper.deleteByPK(id);
    }
}
