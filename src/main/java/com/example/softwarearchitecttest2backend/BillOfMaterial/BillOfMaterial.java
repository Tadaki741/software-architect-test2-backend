package com.example.softwarearchitecttest2backend.BillOfMaterial;

import com.example.softwarearchitecttest2backend.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "billofmaterial")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BillOfMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bom_id;


    private String clientName;


    @ManyToMany
    private List<Product> listOfProductToBuy;


}
