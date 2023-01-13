package com.example.softwarearchitecttest2backend.MPO;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "mpo")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    

}
