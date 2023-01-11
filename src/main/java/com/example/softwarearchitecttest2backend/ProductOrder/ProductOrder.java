package com.example.softwarearchitecttest2backend.ProductOrder;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "productorder")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long po_id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;



}
