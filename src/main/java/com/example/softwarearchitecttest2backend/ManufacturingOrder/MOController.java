package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import com.example.softwarearchitecttest2backend.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "mo")
public class MOController {

    @Autowired
    private MOService moService;


    @GetMapping(path = "/test")
    public String testMO() {
        return "test controller from MO";
    }

    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllMO () {
        ResponseBody responseBody = new ResponseBody(this.moService.getAllMO(),HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addMO (@RequestBody ManufacturingOrder manufacturingOrder) {
        ResponseBody responseBody = new ResponseBody(this.moService.addMO(manufacturingOrder), HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody,HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}/update")
    public ResponseEntity<ResponseBody> updateMO (@RequestBody ManufacturingOrder manufacturingOrder, @PathVariable(name = "id") String id){
        boolean status = this.moService.updateMO(manufacturingOrder,id);
        ResponseBody responseBody = new ResponseBody(status,HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseBody> deleteMO(@PathVariable(name = "id") String id){
        ResponseBody responseBody = new ResponseBody(this.moService.deleteMO(id),HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }


}
