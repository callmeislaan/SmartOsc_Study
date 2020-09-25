package com.fintech.endpoint;

import com.fintech.domain.Person;
import com.fintech.domain.Status;
import com.fintech.dto.PersonDTO;
import com.fintech.exception.StatusException;
import com.fintech.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api_v1/person")
@Validated
public class PersonEndpoint {

    @Autowired
    PersonService personService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findById(@PathVariable Long id) {
        return new PersonDTO(personService.findPerson(id), messageSource);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO save(@RequestBody @Validated PersonDTO personDTO) {
        Optional.ofNullable(personDTO.getId()).ifPresent(id -> {
            if (personService.findPerson(personDTO.getId()).getTasks().size() > 0
                    && personDTO.getStatus().equals(Status.INACTIVE)) {
                String message = messageSource.getMessage("Error.person.status", null, LocaleContextHolder.getLocale());
                throw new StatusException(message); }});
        Person person = personDTO.toEntity();
        return new PersonDTO(personService.save(person), messageSource);
    }

    @GetMapping("/find-by-name-and-status")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> findByNameAndStatus(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String status) {
        return personService.findByNameAndStatus(name, status)
                .stream()
                .map(person -> new PersonDTO(person, messageSource))
                .collect(Collectors.toList());
    }
}
