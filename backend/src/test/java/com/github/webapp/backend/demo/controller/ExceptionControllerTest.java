package com.github.webapp.backend.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ExceptionControllerTest {

    private MockMvc mockMvc;

//    @Before
    public void setUp() {
        ExceptionController exceptionController = new ExceptionController();
        mockMvc = MockMvcBuilders.standaloneSetup(exceptionController).build();
    }

//    @Test
    public void dataConflictException() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/exception/methodNotAllow"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            System.out.println("请求状态码：" + mvcResult.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
