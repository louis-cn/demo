package com.luyi.user;

import com.luyi.user.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;

/**
 * @Author: luyi
 * @Description: 用户测试
 * @Date: Created in 2022-05-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserApplication.class, UserController.class})
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void register() throws Exception {
        String json = "{\"name\":\"luyi1\",\"email\":\"xin@163.com\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }

    @Test
    public void list() throws Exception {
        String json = "{\"name\":\"xin\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }


    @Test
    public void edit() throws Exception {
        String json = "{\"id\":4,\"name\":\"xin\",\"email\":\"xin@163.com\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/user/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }

    @Test
    public void get() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/get/4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);

    }

    @Test
    public void delete() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/user/delete/4")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }

    @Test
    public void deleteBatch() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/user/deleteBatch")
                        .param("ids", "7,8")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertEquals(mvcResult.getResponse().getStatus(), 200);
    }

}
