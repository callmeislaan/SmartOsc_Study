package com.fintech.demo_rest_unit_test.endpoint;

import com.fintech.demo_rest_unit_test.entity.Person;
import com.fintech.demo_rest_unit_test.service.PersonService;
import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonEndpointTest {
    private MockMvc mockMvc;

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonEndpoint personEndpoint;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(personEndpoint)
                .build();
    }

    @Test
    public void shouldReturnPerson() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
        Person person = new Person(1L, "Phuoc");
        Mockito.when(personService.findById(1L))
                .thenReturn(person);

        mockMvc.perform(get("/person/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("Phuoc"));
    }
}
