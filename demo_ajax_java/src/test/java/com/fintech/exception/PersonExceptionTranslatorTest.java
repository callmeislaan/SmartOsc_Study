package com.fintech.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.domain.Person;
import com.fintech.domain.Status;
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
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PersonExceptionTranslatorTest {
    private MockMvc mockMvc;

    @Mock
    PersonService personService;

    @SpyBean
    MessageSource messageSource;

    @Autowired
    ExceptionTranslator exceptionTranslator;

    @InjectMocks
    PersonEndpoint personEndpoint;

    private Person person;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personEndpoint)
                .setControllerAdvice(exceptionTranslator)
                .build();
    }

    @Test
    public void shouldSavePersonThrowMethodArgumentNotValidException() throws Exception {
        person = new Person();
        person.setFirstName("phuoc");

        mockMvc.perform(post("/api_v1/person/save")
                .content(new ObjectMapper().writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].propertyPath").value("NotBlank.personDTO.lastName"))
                .andExpect(jsonPath("$[0].message").value("{NotBlank.person.lastName}"));
    }

    @Test
    public void shouldSavePersonThrowStatusException() throws Exception {
        person = new Person();
        person.setId(1L);
        person.setStatus(Status.INACTIVE);
        person.setSalary(10D);
        person.setLastName("hoang");
        person.setFirstName("phuoc");
        person.setDob(new Date(2020, Calendar.NOVEMBER, 20));
        Task task = new Task(1L, "task1", "description1", person);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        person.setTasks(taskList);

        when(personService.findPerson(any())).thenReturn(person);

        mockMvc.perform(post("/api_v1/person/save")
                .content(new ObjectMapper().writeValueAsString(person))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].propertyPath").value("Error.PersonDTO.status"))
                .andExpect(jsonPath("$[0].message")
                        .value(messageSource.getMessage("Error.person.status", null,
                                LocaleContextHolder.getLocale())));
    }
}
