package com.fintech.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Component
public class AccountInfo implements Serializable{
    enum Gender {
        MALE(1), FEMALE(2), OTHER(0);
        private final Integer code;

        Gender(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
        public static Gender getStatusByValue(int value) {
            for (Gender gender : Gender.values()) {
                if (gender.code == value) return gender;
            }
            throw new IllegalArgumentException("Giới tính không tồn tại.");
        }
    }

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "gender")
    private int gender;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "introduce", columnDefinition = "TEXT")
    private String introduce;

    @OneToOne(fetch = FetchType.EAGER)
    @Id
    @JoinColumn(name = "account_id")
    private Account account;

    public AccountInfo() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
