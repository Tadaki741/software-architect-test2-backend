package com.example.softwarearchitecttest2backend.Product;

import com.example.softwarearchitecttest2backend.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/test")
    public String testProduct() {
        return "test controller from product !";
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addProduct(@RequestBody Product product) {
        ResponseBody responseBody = new ResponseBody(this.productService.addNewProduct(product), HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllProducts() {
        //Get the list of products
        List<Product> allProducts = this.productService.retrieveAllProducts();
        ResponseBody responseBody = new ResponseBody(allProducts, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    @GetMapping(path = "/all/page")
    public ResponseEntity<ResponseBody> getAllProductsWithPage(@RequestParam(name = "pageSize") String size, @RequestParam(name = "NumberOfPage") String numberOfPage) {
        //Get the list of products
        List<Product> allProducts = this.productService.retrieveAllProductsWithPage(Integer.parseInt(numberOfPage),Integer.parseInt(size));
        ResponseBody responseBody = new ResponseBody(allProducts, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    @PatchMapping(path = "/{id}/update")
    public ResponseEntity<ResponseBody> updateProduct(@RequestBody Product product, @PathVariable(name = "id") String id) {
        boolean status = this.productService.updateProduct(product, id);
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseBody> deleteProduct(@PathVariable(name = "id") String id) {
        //Check if the product is existed
        boolean status = this.productService.deleteProduct(id);
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}
