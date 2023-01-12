package com.example.softwarearchitecttest2backend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.softwarearchitecttest2backend.response.ResponseBody;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllProducts () {
        //Get the list of products
        List<Product> allProducts = this.productService.retrieveAllProducts();
        ResponseBody responseBody = new ResponseBody(allProducts,HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }


    @PatchMapping(path = "/{id}/update")
    public ResponseEntity<ResponseBody> updateProduct (@RequestBody Product product, @PathVariable(name = "id") String id) {
        boolean status = this.productService.updateProduct(product,id);
        ResponseBody responseBody = new ResponseBody(status ? "true" : "false", HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<ResponseBody> deleteProduct (@PathVariable(name = "name") String name) {
        //Check if the product is existed
        boolean status = this.productService.deleteProduct(name);
        ResponseBody responseBody = new ResponseBody(status,HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

}
