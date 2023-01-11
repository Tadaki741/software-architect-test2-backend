package com.example.softwarearchitecttest2backend.kafka;

import com.example.softwarearchitecttest2backend.BillOfMaterial.BOMService;
import com.example.softwarearchitecttest2backend.ManufacturingOrder.MOService;
import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Product.ProductService;
import com.example.softwarearchitecttest2backend.ProductOrder.POService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class Consumer {

    private final Logger logger = Logger.getLogger(Consumer.class.getName());

    @Autowired
    private ProductService productService;

    @Autowired
    private POService poService;


    @Autowired
    private BOMService bomService;


    @Autowired
    private MOService moService;

    @KafkaListener(topics = "product", groupId = "group_id")
    public void consume(Product product) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", product));

        //save message to database
        Product newProduct = this.productService.addNewProduct(product);

        logger.info(String.format("#### -> ID message -> %s", newProduct.getId()));

    }
}
