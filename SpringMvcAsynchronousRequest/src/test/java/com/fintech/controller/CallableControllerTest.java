package com.fintech.controller;

import com.fintech.config.AppConfig;
import com.fintech.config.SpringWebMvcConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringWebMvcConfig.class)
public class CallableControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.context);
        this.mockMvc = builder.build();
    }

    @Test
    public void testController() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/callable");

        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.request().asyncStarted())
                .andExpect(MockMvcResultMatchers.request().asyncResult("async result"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}