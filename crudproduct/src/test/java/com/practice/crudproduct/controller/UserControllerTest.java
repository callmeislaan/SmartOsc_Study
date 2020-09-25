package com.practice.crudproduct.controller;

import com.practice.crudproduct.entity.User;
import com.practice.crudproduct.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void itShouldSaveUserReturnThatSaved() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setUserName("htp");
        user.setPassword("1234");

//        when(userService.save(user)).thenReturn(user);

//        mockMvc.perform(post("/user/save", user))
//                .andReturn().getResponse().getContentAsString().equals(user.toString());
    }
}
