package com.example.softwarearchitecttest2backend.Product;


import com.example.softwarearchitecttest2backend.ManufacturingOrder.ManufacturingOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})//We add this annotation to allow backend return the product object when it is stored inside Manufacturing Order
@Entity
@Table(name = "product")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

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


    @Column(name = "price")
    private Integer price;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private ManufacturingOrder manufacturingOrder;


    //Custom constructor without id
    public Product(String code, String name, String description, String category, int quantity, int price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }
}
