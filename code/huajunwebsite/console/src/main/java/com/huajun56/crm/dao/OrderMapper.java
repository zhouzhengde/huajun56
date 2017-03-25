package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Order;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * crm_order
     */
    int deleteByPK(String id);

    /**
     * crm_order
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_order
     */
    int insert(Order record);

    /**
     * crm_order
     */
    int insertSelective(Order record);

    /**
     * crm_order
     */
    Order findByPK(String id);

    /**
     * crm_order
     */
    List<Order> find(Order record);

    /**
     * crm_order
     */
    int updateByPkSelective(Order record);

    /**
     * crm_order
     */
    int updateByPK(Order record);
}