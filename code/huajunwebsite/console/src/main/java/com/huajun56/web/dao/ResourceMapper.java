package com.huajun56.web.dao;

import com.huajun56.web.entity.Resource;
import java.util.List;

public interface ResourceMapper {
    int deleteByPK(Integer id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource findByPK(Integer id);

    List<Resource> find(Resource record);

    int updateByPkSelective(Resource record);

    int updateByPK(Resource record);
}