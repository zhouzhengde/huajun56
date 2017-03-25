package com.huajun56.crm.dao;

import com.huajun56.crm.entity.Country;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountryMapper {
    /**
     * crm_country
     */
    int deleteByPK(Integer id);

    /**
     * crm_country
     */
    int batchDelete(@Param("ids") List ids);

    /**
     * crm_country
     */
    int insert(Country record);

    /**
     * crm_country
     */
    int insertSelective(Country record);

    /**
     * crm_country
     */
    Country findByPK(Integer id);

    /**
     * crm_country
     */
    List<Country> find(Country record);

    /**
     * crm_country
     */
    int updateByPkSelective(Country record);

    /**
     * crm_country
     */
    int updateByPK(Country record);
}