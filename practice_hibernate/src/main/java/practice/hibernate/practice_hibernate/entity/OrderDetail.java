package practice.hibernate.practice_hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OrderDetail{

    @Id
    @ManyToOne
    private Order order;

    @Id
    @ManyToOne
    private Product product;

    private Long quantity;
    private Double price;

}
