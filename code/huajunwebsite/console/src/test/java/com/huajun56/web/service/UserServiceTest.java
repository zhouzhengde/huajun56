package com.huajun56.web.service;

import com.huajun56.ApplicationRunner;
import com.huajun56.web.entity.User;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

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
    public void findOne1() throws Exception {

        User user = new User();
        user.setUsername("admin");
        User one = userService.findOne(user);

        Assert.assertNotNull(one);

    }

}