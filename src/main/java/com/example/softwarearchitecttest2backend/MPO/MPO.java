package com.example.softwarearchitecttest2backend.MPO;


import javax.persistence.*;

@Entity
@Table(name = "material_purchase_order")
public class MPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    

}
