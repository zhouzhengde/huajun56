package com.huajun56.web.service;

import com.huajun56.ApplicationRunner;
import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bond on 2017/2/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    @Test
    public void findByPager() throws Exception {

    }

    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void generateTree() throws Exception {

        List<Resource> resources = resourceService.findByPager(new Pager<Resource>()).getResult();

        List<Resource> resources1 = resourceService.generateTree(resources);

        Assert.assertNotNull(resources1);

    }

}