package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Route;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RouteMapper {
    /**
     * crm_route
     */
    int deleteByPK(Integer id);

    /**
     * crm_route
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_route
     */
    int insert(Route record);

    /**
     * crm_route
     */
    int insertSelective(Route record);

    /**
     * crm_route
     */
    Route findByPK(Integer id);

    /**
     * crm_route
     */
    List<Route> find(Route record);

    /**
     * crm_route
     */
    int updateByPkSelective(Route record);

    /**
     * crm_route
     */
    int updateByPK(Route record);
}