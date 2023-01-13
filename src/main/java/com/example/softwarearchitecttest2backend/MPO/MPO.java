package com.example.softwarearchitecttest2backend.MPO;


import com.example.softwarearchitecttest2backend.Product.Product;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;


    public MPO(String status, Product product) {
        this.status = status;
        this.product = product;
    }
}
