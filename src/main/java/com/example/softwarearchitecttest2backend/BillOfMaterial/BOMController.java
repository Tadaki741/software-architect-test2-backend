package com.example.softwarearchitecttest2backend.BillOfMaterial;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "bom")
@CrossOrigin("*")
public class BOMController {

    @Autowired
    private BOMService bomService;


    @GetMapping(path = "/test")
    public String testBOM() {
        return "test controller from BOM";
    }


    //GET ALL
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllBOM () {
        //Retrieve the data
        List<BillOfMaterial> billOfMaterialList = this.bomService.getAllList();
        ResponseBody responseBody = new ResponseBody(billOfMaterialList, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    //CREATE
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addBOM (@RequestBody BillOfMaterial billOfMaterial) {
        ResponseBody responseBody = new ResponseBody(this.bomService.createNewBillOfMaterial(billOfMaterial),HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }
    //UPDATE
    @PatchMapping(path = "/{id}/update")
    public ResponseEntity<ResponseBody> updateProduct(@RequestBody BillOfMaterial billOfMaterial, @PathVariable(name = "id") String id) {
        boolean status = this.bomService.updateProduct(billOfMaterial, id);
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }



    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseBody> deleteProduct(@PathVariable(name = "id") String id) {
        //Check if the product is existed
        boolean status = this.bomService.deleteBOM(id);
        ResponseBody responseBody = new ResponseBody(status, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

}
