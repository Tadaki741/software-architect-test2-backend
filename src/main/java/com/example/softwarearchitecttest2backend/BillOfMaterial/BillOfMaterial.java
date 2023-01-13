package com.example.softwarearchitecttest2backend.BillOfMaterial;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bom")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String clientName;


}
