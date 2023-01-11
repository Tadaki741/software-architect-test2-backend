package com.example.softwarearchitecttest2backend.Product;


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
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;


    @Column(name = "quantity")
    private int quantity;


    @Column(name = "parent")
    private String parent;

}
