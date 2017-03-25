package com.huajun56.crm.dao;

import com.huajun56.crm.entity.District;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DistrictMapper {
    /**
     * crm_district
     */
    int deleteByPK(Integer id);

    /**
     * crm_district
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_district
     */
    int insert(District record);

    /**
     * crm_district
     */
    int insertSelective(District record);

    /**
     * crm_district
     */
    District findByPK(Integer id);

    /**
     * crm_district
     */
    List<District> find(District record);

    /**
     * crm_district
     */
    int updateByPkSelective(District record);

    /**
     * crm_district
     */
    int updateByPK(District record);
}