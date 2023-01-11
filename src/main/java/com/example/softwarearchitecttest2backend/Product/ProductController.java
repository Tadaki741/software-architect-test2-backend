package com.example.softwarearchitecttest2backend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.softwarearchitecttest2backend.response.ResponseBody;

@RestController
@RequestMapping(path = "product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/test")
    public String testProduct () {
        return "test controller from product !";
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addProduct(@RequestBody Product product) {
        ResponseBody responseBody = new ResponseBody(this.productService.addNewProduct(product),HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

}
