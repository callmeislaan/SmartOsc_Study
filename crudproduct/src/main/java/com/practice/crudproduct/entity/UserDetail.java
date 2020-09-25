package com.practice.crudproduct.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class UserDetail {
    @Id
    private Long id;

    private String address;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dob;
    private String fullName;
    private String phoneNumber;

    @OneToOne
    @JsonIgnore
    @MapsId
    private User user;

}