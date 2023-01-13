package com.example.softwarearchitecttest2backend.ProductOrder;

import com.example.softwarearchitecttest2backend.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "po")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;


}
