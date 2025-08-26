package com.example.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleBlogApplicationTests {

    @Test
    public void contextLoads() {
        // Simple test to verify the application context loads
        assertTrue("The application context should have loaded", true);
    }
}
