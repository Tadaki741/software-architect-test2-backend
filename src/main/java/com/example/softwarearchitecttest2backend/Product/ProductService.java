package com.example.softwarearchitecttest2backend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProductService {

    private final String PRODUCT_CACHE = "PRODUCT";
    private final RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ProductRepository productRepository;

    public ProductService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //Define the parameters of operation: USER_CACHE, EMAIL, USER
    private HashOperations<String, String, Product> hashOperations;

    // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void initializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }


    public Product addNewProduct(Product product) {
        return this.productRepository.save(product);
    }


}
