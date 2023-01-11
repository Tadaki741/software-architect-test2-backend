package com.example.softwarearchitecttest2backend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product addNewProduct(Product product) {
        return this.productRepository.save(product);
    }


}
