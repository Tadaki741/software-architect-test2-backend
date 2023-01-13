package com.example.softwarearchitecttest2backend.Product;


import com.example.softwarearchitecttest2backend.ManufacturingOrder.ManufacturingOrder;
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
