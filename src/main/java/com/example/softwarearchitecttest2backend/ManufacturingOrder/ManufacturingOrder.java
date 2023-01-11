package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import com.example.softwarearchitecttest2backend.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ManufacturingOrder")
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

    @ManyToMany
    private List<Product> listOfProductToSell;

}
