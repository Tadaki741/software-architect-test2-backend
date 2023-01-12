package com.example.softwarearchitecttest2backend.ProductOrder;

import com.example.softwarearchitecttest2backend.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "po")
@CrossOrigin("*")
public class POController {

    @Autowired
    private POService poService;


    @GetMapping(path = "/test")
    public String testPO () {
        return "test controller from PO";
    }

    //Get all ProductOrder
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllProductOrder () {
        //Get the list
        List<ProductOrder> listOfProductOrder = this.poService.getAllProductOrder();
        ResponseBody responseBody = new ResponseBody(listOfProductOrder, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }


    //Create new Product Order
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addNewProductOrder (@RequestBody ProductOrder productOrder) {
        //Call the service class
        ResponseBody responseBody = new ResponseBody(this.poService.addProductOrder(productOrder),HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }


    //Update Product Order
    @PatchMapping(path = "/{id}/update")
    public ResponseEntity<ResponseBody> updateProductOrder (@RequestBody ProductOrder productOrder, @PathVariable(name = "id") String id) {
        //Call the service class
        boolean status = this.poService.updateProductOrder(productOrder, Long.parseLong(id));
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }



    //Delete Product Order
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseBody> deleteProductOrder (@PathVariable(name = "id") String id){
        //Check if the product is existed
        boolean status = this.poService.deleteProductOrder(id);
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


}
