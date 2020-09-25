package com.fintech.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fintech.config.CustomLocalResolver;
import com.fintech.domain.Person;
import com.fintech.domain.Status;
import com.fintech.domain.Task;
import com.fintech.dto.PersonDTO;
import com.fintech.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ContextConfiguration(classes = CustomLocalResolver.class)
public class PersonEndpointTest {
    private MockMvc mockMvc;

    @Mock
    PersonService personService;

    @SpyBean
    MessageSource messageSource;

    @InjectMocks
    PersonEndpoint personEndpoint;

    private Person person;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personEndpoint)
                .build();

        person = new Person();

        person.setId(1L);
        person.setStatus(Status.ACTIVE);
        person.setSalary(10D);
        person.setLastName("hoang");
        person.setFirstName("phuoc");
        person.setDob(new Date(2020, Calendar.NOVEMBER, 20));

        Task task = new Task(1L, "task1", "description1", person);
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        person.setTasks(taskList);

    }

    @Test
    public void shouldGetPersonByIdReturnThatPerson() throws Exception {
        when(personService.findPerson(any())).thenReturn(person);

        mockMvc.perform(get("/api_v1/person/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("phuoc"))
                .andExpect(jsonPath("$.lastName").value("hoang"))
                .andExpect(jsonPath("$.salary").value(10))
                .andExpect(jsonPath("$.dob").value(new Date(2020, Calendar.NOVEMBER, 20)))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
    }

    @Test
    public void shouldSavePersonReturnPersonThatSaved() throws Exception {
        person.setId(null);
        person.setTasks(new ArrayList<>());

        when(personService.save(any())).thenReturn(person);

        mockMvc.perform(post("/api_v1/person/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(new PersonDTO(person, messageSource))))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value(person.getFirstName()))
                .andExpect(jsonPath("$.lastName").value("hoang"))
                .andExpect(jsonPath("$.salary").value(10))
                .andExpect(jsonPath("$.dob").value(new Date(2020, Calendar.NOVEMBER, 20)))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
    }


    @Test
    public void shouldFindPersonByNameAndStatusReturnThatPerson() throws Exception {
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personService.findByNameAndStatus(any(), any())).thenReturn(personList);

        mockMvc.perform(get("/api_v1/person/find-by-name-and-status", "phuoc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("phuoc"))
                .andExpect(jsonPath("$[0].lastName").value("hoang"))
                .andExpect(jsonPath("$[0].salary").value(10))
                .andExpect(jsonPath("$[0].dob").value(new Date(2020, Calendar.NOVEMBER, 20)))
                .andExpect(jsonPath("$[0].status").value("ACTIVE"));
    }

    @Test
    public void shouldSavePersonThrowStatusException() {
        person.setStatus(Status.INACTIVE);
        when(personService.findPerson(any())).thenReturn(person);

        String actualMessage = "Request processing failed; nested exception is com.fintech.exception.StatusException: " +
                "Status must not inactive cause this person had task";
        String message = assertThrows(Exception.class, () -> {
            mockMvc.perform(post("/api_v1/person/save")
                    .content(new ObjectMapper().writeValueAsString(person))
                    .contentType(MediaType.APPLICATION_JSON));
        }).getMessage();

        assertEquals(message, actualMessage);
    }
}
