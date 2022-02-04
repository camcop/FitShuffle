//package com.qa.fitshuffle.rest;
//
//import com.qa.fitshuffle.domain.Item;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
//import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
////import com.fasterxml.jackson.databind.ObjectMapper;
//
//import static org.springframework.http.RequestEntity.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc // acts like your postman - makes the test requests
//@Sql(scripts = {"classpath:item-schema.sql", "classpath:item-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@ActiveProfiles("test")
//public class ItemControllerTest {
//
//    @Autowired
//    private MockMvc mock; // to mock the requests
//
//    @Autowired
//    private ObjectMapper map; //interprets JSON
//
//    @Test
//    void testCreateCont() throws Exception {
//        //--request
//        //Create a item
//        Item newItem = new Item("J Crew shirt","Top", "Shirt", "J Crew", "Blue");
//        //Convert into JSON string
//        String newItemJSON = this.map.writeValueAsString(newItem);
//        //Build the mock request
//        RequestBuilder mockRequest = post("").contentType(MediaType.APPLICATION_JSON).content(newItemJSON);
//
//        //--response
//        Item savedItem = new Item("J Crew shirt","Top", "Shirt", "J Crew", "Blue"); //already inserted one record with the schema
//        //convert to JSON
//        String savedItemJSON = this.map.writeValueAsString(savedItem);
//
//        //--test response (status + body)
//        //-test status = 201-CREATED
//        ResultMatcher matchStatus = status().isCreated();
//        //-test body
//        ResultMatcher matchBody = content().json(savedItemJSON);
//
//        //perform the test
//        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
//
//    }
//
//}
