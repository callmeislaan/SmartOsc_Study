package com.fintech.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fintech.domain.Person;
import com.fintech.domain.Status;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
public class PersonDTO {

    @NotBlank(message = "{NotBlank.person.firstName}")
    private String firstName;
    @NotBlank(message = "{NotBlank.person.lastName}")
    private String lastName;
    @JsonFormat
    private Double salary;

    private Long id;
    private Date dob;
    private Status status;
    private String salaryFormatted;
    private String statusStr;
    private String dobFormatted;
    private List<TaskDTO> tasks;
    private MessageSource messageSource;

    public PersonDTO() {
    }



    public PersonDTO(Person person, MessageSource messageSource) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.salary = person.getSalary();
        this.dob = person.getDob();
        this.status = person.getStatus();

        tasks = person.getTasks().stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
        this.statusStr = messageSource.getMessage(this.status.name(), null, LocaleContextHolder.getLocale());
        this.salaryFormatted = convertUSDToVND(this.salary);
        this.dobFormatted = formatDob(this.dob);
    }

    private String formatDob(Date dob) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(dob);
    }

    private String convertUSDToVND(Double salary) {
        return NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(salary);
    }

    public Person toEntity() {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDob(dob);
        person.setStatus(status);
        person.setSalary(salary);
//        Optional.ofNullable(tasks).ifPresent(taskDTOS -> {
//            person.setTasks(taskDTOS.stream().map(TaskDTO::toEntity).collect(Collectors.toList()));
//        });
        return person;
    }
}
