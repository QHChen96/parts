package com.chenqinhao.parts;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.chenqinhao.parts.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Administrator on 2017/1/5.
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/home")).andExpect(view().name("home"));
    }
}
