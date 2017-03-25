package com.huajun56.crm.service.impl;

import java.util.List;

import com.huajun56.common.util.$;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.crm.entity.Customer;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.crm.dao.CustomerMapper;
import com.huajun56.crm.service.CustomerService;


@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Pager<Customer> findByPager(Pager<Customer> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Customer>() {
            @Override
            public List<Customer> query(Customer entity) throws ServiceException {
                return customerMapper.find(entity);
            }
        });
    }

    @Override
    public Customer findOne(Integer id) throws ServiceException {
        try {
            return customerMapper.findByPK(id);
        } catch (Exception e) {
            throw new ServiceException("[Query has error]", e);
        }
    }

    @Override
    public int add(Customer entity) throws ServiceException {
        try {
            return customerMapper.insertSelective(entity);
        } catch (Exception e) {
            throw new ServiceException("[Save has error]", e);
        }
    }

    @Override
    public int update(Customer entity) throws ServiceException {
        try {
            return customerMapper.updateByPkSelective(entity);
        } catch (Exception e) {
            throw new ServiceException("[Update has error]", e);
        }
    }

    @Override
    public int delete(Integer id) throws ServiceException {
        return customerMapper.deleteByPK(id);
    }

    @Override
    public Customer findByMobile(String fromMobile) {

        Customer customer = new Customer();
        customer.setMobile(fromMobile);
        List<Customer> customers = customerMapper.find(customer);

        if ($.isEmpty(customers)) {
            return null;
        }

        return customers.get(0);
    }
}
