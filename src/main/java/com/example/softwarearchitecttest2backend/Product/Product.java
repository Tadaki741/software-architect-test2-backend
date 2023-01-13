package com.example.softwarearchitecttest2backend.Product;


import com.example.softwarearchitecttest2backend.ProductOrder.ProductOrder;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;


    @Column(name = "quantity")
    private Integer quantity;


    @Column(name = "parent")
    private String parent;


    //Custom constructor without id
    public Product(String code, String name, String description, String category, int quantity, String parent) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.parent = parent;
    }
}
