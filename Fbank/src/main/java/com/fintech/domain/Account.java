package com.fintech.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Component
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false, unique = true)
    private String name;
    @Column(length = 30, nullable = false)
    private String password;
    @Column(name = "login_fielded", columnDefinition = "bigint default 0")
    private Integer loginFielded = 0;
    @Column(name = "time_block")
    private LocalDateTime timeBlock;
    @Column(columnDefinition = "bigint default 1")
    private Integer status = Status.ACTIVE.getCode();

    @OneToOne(mappedBy = "account", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private AccountInfo accountInfo;

    public enum Status {
        ACTIVE(1), BLOCK(-1);
        private final Integer code;

        Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Account.Status getStatusByValue(int value) {
            for (Account.Status status : Account.Status.values()) {
                if (status.code == value) return status;
            }
            throw new IllegalArgumentException("status is not exist");
        }
    }

    public Account() {
    }

    public Account(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
        this.accountInfo.setAccount(this);
    }


    public void setAccountInfo(AccountInfo accountInfo) {
        accountInfo.setAccount(this);
        this.accountInfo = accountInfo;
    }   

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public boolean isMatchPassword(String password) {
        return this.password.equals(password);
    }

}
