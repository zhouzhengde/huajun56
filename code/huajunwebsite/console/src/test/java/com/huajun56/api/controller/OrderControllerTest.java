package com.huajun56.api.controller;

import com.huajun56.ApplicationRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by bond on 2017/3/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationRunner.class)
@WebIntegrationTest("server.port:0")
public class OrderControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void init() {

        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void newestOrder() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/portals/order/latest/{number}", 4).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void submitNewOrder() throws Exception {
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post("/api/portals/order")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();

    }

    @Test
    public void get() throws Exception {

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/api/portals/order/{id}", 4)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse();

    }

}