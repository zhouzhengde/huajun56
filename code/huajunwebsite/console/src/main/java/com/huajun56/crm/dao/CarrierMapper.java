package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Carrier;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarrierMapper {
    /**
     * crm_carrier
     */
    int deleteByPK(Integer id);

    /**
     * crm_carrier
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_carrier
     */
    int insert(Carrier record);

    /**
     * crm_carrier
     */
    int insertSelective(Carrier record);

    /**
     * crm_carrier
     */
    Carrier findByPK(Integer id);

    /**
     * crm_carrier
     */
    List<Carrier> find(Carrier record);

    /**
     * crm_carrier
     */
    int updateByPkSelective(Carrier record);

    /**
     * crm_carrier
     */
    int updateByPkWithBLOBs(Carrier record);

    /**
     * crm_carrier
     */
    int updateByPK(Carrier record);
}