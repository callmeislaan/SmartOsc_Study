package practice.hibernate.practice_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDetail {
    @Id
    private Long id;

    private Long quantity;

    @OneToOne
    @MapsId
    private Product product;

}