package com.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode
public class CongTy {
    @Id
    private String maCK;

    private String ten;

    @OneToMany
    private Set<CanDoiKeToan> canDoiKeToan;
}
