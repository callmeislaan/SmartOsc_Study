package com.fintech.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.domain.Person;
import com.fintech.domain.Task;
import com.fintech.endpoint.PersonEndpoint;
import com.fintech.endpoint.TaskEndpoint;
import com.fintech.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class TaskExceptionTranslatorTest {
    private MockMvc mockMvc;

    @Mock
    PersonService personService;

    @SpyBean
    MessageSource messageSource;

    @Autowired
    ExceptionTranslator exceptionTranslator;

    @InjectMocks
    TaskEndpoint taskEndpoint;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(taskEndpoint)
                .setControllerAdvice(exceptionTranslator)
                .build();
    }

    @Test
    public void shouldSaveTaskThrowBindException() throws Exception {
        Task task = new Task();
        task.setName("new task");

        mockMvc.perform(post("/api_v1/task/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(task)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].propertyPath").value("NotBlank.taskDTO.description"))
                .andExpect(jsonPath("$[0].message").value("{NotBlank.task.description}"));
    }
}
