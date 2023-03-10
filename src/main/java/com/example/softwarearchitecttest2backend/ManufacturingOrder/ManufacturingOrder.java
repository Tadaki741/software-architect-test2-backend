package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mo")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "clientname")
    private String clientName;

    @Column(name = "deliverydate")
    private Date deliveryDate;

    @Column(name = "completedate")
    private Date completeDate;

    @Column(name = "startdate")
    private Date startDate;


    @Column(name = "status")
    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public ManufacturingOrder(String clientName, Date deliveryDate, Date completeDate, Date startDate, String status, Product product) {
        this.clientName = clientName;
        this.deliveryDate = deliveryDate;
        this.completeDate = completeDate;
        this.startDate = startDate;
        this.status = status;
        this.product = product;
    }


}
