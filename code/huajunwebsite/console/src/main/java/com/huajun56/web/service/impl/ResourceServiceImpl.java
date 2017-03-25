package com.huajun56.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.huajun56.common.util.$;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Resource;
import com.huajun56.common.exception.ServiceException;
import com.huajun56.web.dao.ResourceMapper;
import com.huajun56.web.service.ResourceService;



@Component
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Pager<Resource> findByPager(Pager<Resource> pager) throws ServiceException {

        return pager.pagingQuery(new Pager.Callback<Resource>() {
            @Override
            public List<Resource> query(Resource entity) throws ServiceException {
                return resourceMapper.find(entity);
            }
        });
    }
    
    @Override
    public Resource findOne(Integer id) throws ServiceException {
    	try{
    		 return resourceMapper.findByPK(id);
    	}catch(Exception e){
    		throw new ServiceException("[Query has error]", e);
    	}       
    }

    @Override
    public int add(Resource entity) throws ServiceException {
    	try{
    		return resourceMapper.insertSelective(entity);
    	}catch(Exception e){
    		throw new ServiceException("[Save has error]", e);
    	}       
    }

 	@Override
    public int update(Resource entity) throws ServiceException {
    	try{
    		return resourceMapper.updateByPkSelective(entity);
	    }catch(Exception e){
			throw new ServiceException("[Update has error]", e);
		}       
    }   

    @Override
    public int delete(Integer id) throws ServiceException {
        return resourceMapper.deleteByPK(id);
    }

    @Override
    public List<Resource> generateTree(List<Resource> resources) throws ServiceException {

        // 找到根级节点
        List<Resource> rootList = new ArrayList<>();
        for (int i = 0; i < resources.size(); i++) {
            Resource root = resources.get(i);
            if ($.isEqual(0, root.getParentId())) {
                root.setText(root.getName());
                root.setNodes(generateRoot(root, resources));
                rootList.add(root);
            }
        }
        return rootList;
    }

    private List<Resource> generateRoot(Resource root, List<Resource> resources) {
        List<Resource> siblings = new ArrayList<>();
        for (int i = 0; i < resources.size(); i++) {
            Resource sib = resources.get(i);
            sib.setText(sib.getName());
            if ($.isEqual(sib.getParentId(), root.getId())) {
                sib.setNodes(generateRoot(sib, resources));
                siblings.add(sib);
            }
        }
        if ($.isEmpty(siblings)) {
            return null;
        }
        Collections.sort(siblings, new Comparator<Resource>() {
            @Override
            public int compare(Resource o1, Resource o2) {
                return o1.getOrderId() - o2.getOrderId();
            }
        });
        return siblings;
    }
}
