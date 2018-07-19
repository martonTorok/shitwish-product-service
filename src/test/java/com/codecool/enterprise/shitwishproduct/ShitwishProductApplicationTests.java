package com.codecool.enterprise.shitwishproduct;

import com.codecool.enterprise.shitwishproduct.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShitwishProductApplicationTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private Product testProduct = new Product(
            
    );


    @Test
    public void contextLoads() {
    }

}
