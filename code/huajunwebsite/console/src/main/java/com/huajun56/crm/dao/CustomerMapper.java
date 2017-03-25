package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * crm_customer
     */
    int deleteByPK(Integer id);

    /**
     * crm_customer
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_customer
     */
    int insert(Customer record);

    /**
     * crm_customer
     */
    int insertSelective(Customer record);

    /**
     * crm_customer
     */
    Customer findByPK(Integer id);

    /**
     * crm_customer
     */
    List<Customer> find(Customer record);

    /**
     * crm_customer
     */
    int updateByPkSelective(Customer record);

    /**
     * crm_customer
     */
    int updateByPkWithBLOBs(Customer record);

    /**
     * crm_customer
     */
    int updateByPK(Customer record);
}