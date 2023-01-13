package com.example.softwarearchitecttest2backend.Product;

import com.example.softwarearchitecttest2backend.Utils.NullGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProductService {

    private final Logger logger = Logger.getLogger(ProductService.class.getName());

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


    public List<Product> retrieveAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }


    public List<Product> retrieveAllProductsWithPage(int NumberOfPage,int pageSize) {
        logger.info("number of page: " + NumberOfPage + " page size: " + pageSize);
        Pageable pageable = PageRequest.of(NumberOfPage,pageSize);
        Page<Product> pagedResult = this.productRepository.findAll(pageable);
        logger.info("result: " + pagedResult.getContent());
        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }



    public boolean updateProduct(Product productDTO, String id) {

        //Find the product first
        Product existedProduct = this.productRepository.findById(Long.parseLong(id)).orElse(null);

        if (existedProduct == null) {
            return false;
        }

        //Fill null
        NullGuard.updateIfChanged(existedProduct::setCode, productDTO.getCode(), existedProduct::getCode);
        NullGuard.updateIfChanged(existedProduct::setName, productDTO.getName(), existedProduct::getName);
        NullGuard.updateIfChanged(existedProduct::setDescription, productDTO.getDescription(), existedProduct::getDescription);
        NullGuard.updateIfChanged(existedProduct::setCategory, productDTO.getCategory(), existedProduct::getCategory);
        NullGuard.updateIfChanged(existedProduct::setQuantity, productDTO.getQuantity(), existedProduct::getQuantity);
        NullGuard.updateIfChanged(existedProduct::setPrice, productDTO.getPrice(), existedProduct::getPrice);

        this.productRepository.updateProduct(Long.parseLong(id), existedProduct.getCode(), existedProduct.getName(), existedProduct.getDescription(), existedProduct.getCategory(), existedProduct.getQuantity(), existedProduct.getPrice());
        return true;
    }


    public boolean deleteProduct(String id) {
        //Check if it exists first
        Optional<Product> databaseProduct = this.productRepository.findById(Long.parseLong(id));
        if (databaseProduct.isEmpty()) {
            return false;
        }
        Long targetID = databaseProduct.get().getId();
        //Then delete it
        this.productRepository.deleteById(targetID);
        return true;
    }


}
