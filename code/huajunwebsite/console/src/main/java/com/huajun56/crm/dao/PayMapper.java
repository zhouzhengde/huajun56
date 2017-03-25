package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Pay;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMapper {
    /**
     * crm_pay
     */
    int deleteByPK(String id);

    /**
     * crm_pay
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_pay
     */
    int insert(Pay record);

    /**
     * crm_pay
     */
    int insertSelective(Pay record);

    /**
     * crm_pay
     */
    Pay findByPK(String id);

    /**
     * crm_pay
     */
    List<Pay> find(Pay record);

    /**
     * crm_pay
     */
    int updateByPkSelective(Pay record);

    /**
     * crm_pay
     */
    int updateByPK(Pay record);
}