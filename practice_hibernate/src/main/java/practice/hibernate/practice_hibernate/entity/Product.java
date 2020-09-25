package practice.hibernate.practice_hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @OneToOne(mappedBy = "product")
    private ProductDetail productDetail;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetail = new ArrayList<>();
}
