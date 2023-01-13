package com.example.softwarearchitecttest2backend.MPO;


import javax.persistence.*;

@Entity
@Table(name = "mpo")
public class MPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    

}
