package com.example.Project1_AWBD.controller;

import com.example.Project1_AWBD.entities.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findById() throws Exception {
        mockMvc.perform(get("/recipe/findById/{id}","568"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void findAll() throws Exception {
        mockMvc.perform(get("/recipe/findAll/"))
                .andExpect(status().isNotFound());
    }
}
