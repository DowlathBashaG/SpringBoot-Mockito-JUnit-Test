package io.dowlath.springbootunittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Author Dowlath
 * @create 7/15/2020 2:55 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basic() throws Exception{
        // call "/hello-world" GET application/json
        // verify "Hello World"
        RequestBuilder request = MockMvcRequestBuilders
                                 .get("/hello-world")
                                 .accept(MediaType.APPLICATION_JSON);

        // If response is very simple use the blow one
        MvcResult result = mockMvc.perform(request)
                           .andExpect(status().isOk())
                           .andExpect(content().string("Hello World"))
                           .andReturn();

        // If response is very complex and use the assertEquals and perform
        //verify "Hello world"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

}
