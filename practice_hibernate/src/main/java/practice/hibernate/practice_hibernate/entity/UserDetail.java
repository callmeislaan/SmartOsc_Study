package practice.hibernate.practice_hibernate.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetail {
    @Id
    private Long id;

    private String address;
    private LocalDate dob;
    private String fullName;
    private String phoneNumber;

    @OneToOne
    @MapsId
    private User user;
}