package com.huajun56.web.service;

import com.huajun56.ApplicationRunner;
import com.huajun56.common.entity.Pager;
import com.huajun56.web.entity.RoleResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bond on 2017/2/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
public class RoleResourceServiceTest {

    @Autowired
    private RoleResourceService roleResourceService;

    @Test
    public void findByPager() throws Exception {

        Pager<RoleResource> pager = new Pager<>();
        RoleResource roleResource = new RoleResource();
        roleResource.setRoleId(1);
        roleResource.setIsDel(false);

        pager.setCondition(roleResource);
        Pager<RoleResource> byPager = roleResourceService.findByPager(pager);

        Assert.assertNotNull(byPager);

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
    public void save() throws Exception {

    }

    @Test
    public void generateMenuTree() throws Exception {

    }

}