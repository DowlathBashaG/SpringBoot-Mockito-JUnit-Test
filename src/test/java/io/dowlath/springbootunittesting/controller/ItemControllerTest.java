package io.dowlath.springbootunittesting.controller;

import io.dowlath.springbootunittesting.model.Item;
import io.dowlath.springbootunittesting.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

/**
 * @Author Dowlath
 * @create 7/15/2020 2:55 PM
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    // Mocking the service and expected as return value and testing.
    @Test
    public void dummyItem_basic() throws Exception{
        // call "/hello-world" GET application/json
        // verify "Hello World"
        RequestBuilder request = MockMvcRequestBuilders
                                 .get("/dummy-item")
                                 .accept(MediaType.APPLICATION_JSON);

        // If response is very simple use the blow one
        MvcResult result = mockMvc.perform(request)
                           .andExpect(status().isOk())
                           .andExpect(content().json("{\n" +
                                   "  \"id\": 1,\n" +
                                   "  \"name\": \"Ball\",\n" +
                                   "  \"price\": 10,\n" +
                                   "  \"quantity\": 100\n" +
                                   "}"))
                           .andReturn();

        // If response is very complex and use the assertEquals and perform
        //verify "Hello world"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception{

        when(businessService.retrieveHardCodedItem()).thenReturn(
                new Item(2,"Item2",10,10));


        // call "/hello-world" GET application/json
        // verify "Hello World"
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        // If response is very simple use the blow one
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2,name:Item2,price:10}"))
                .andReturn();

        // If response is very complex and use the assertEquals and perform
        //verify "Hello world"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    // This is test method for GET http methods
    @Test
    public void retrieveAllItems_basic() throws Exception{

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2,"Item2",10,10) ,
                        new Item(2,"Item3",20,20)));
        // call "/hello-world" GET application/json
        // verify "Hello World"
        RequestBuilder request = MockMvcRequestBuilders
                 // GET
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        // If response is very simple use the blow one
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2,name:Item2,price:10},{}]"))
                .andReturn();

        // If response is very complex and use the assertEquals and perform
        //verify "Hello world"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    // if you are using POST , it should be like this.

    /*

     RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/items")
                                     .accept(MediaType.APPLICATION_JSON)
                                     .content("{\id\":1,\"name\":\"Ball\",
                                               \"price\":10,\"quantity\":1000}")
                                     .contentType(MediaType.APPLICATION_JSON);

     MvcResult result = mockMvc.perform(requestBuilder)
                               .andExpect(status().isCreated())
                               .andExpect(header()
                                          .string("location",
                                          containsString("/item/")))
                                          .andReturn();
     */



}
