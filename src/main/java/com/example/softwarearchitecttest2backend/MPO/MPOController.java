package com.example.softwarearchitecttest2backend.MPO;


import com.example.softwarearchitecttest2backend.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Annotation: mpo/MPO is Material Purchase Order
 */
@RestController
@RequestMapping("mpo")
@CrossOrigin("*")
public class MPOController {


    @Autowired
    private MPOService service;

    //Create new MPO
    @PostMapping(path = "/add")
    public ResponseEntity<ResponseBody> addMPO(@RequestBody MPO mpo) {
        ResponseBody responseBody = new ResponseBody(this.service.createMPO(mpo),HttpStatus.CREATED.name());
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);

    }


    //Get all
    @GetMapping(path = "/all")
    public ResponseEntity<ResponseBody> getAllMPO() {
        //Get all
        List<MPO> mpo_list = this.service.getAllMPO();
        ResponseBody responseBody = new ResponseBody(mpo_list, HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


    //Update
    @PutMapping("/{id}/update")
    public ResponseEntity<ResponseBody> updateMPO (@PathVariable(name = "id") String id, @RequestBody MPO mpo){


        ResponseBody responseBody = new ResponseBody();
        return new ResponseEntity<>(responseBody,HttpStatus.OK);
    }


    //Delete
    @DeleteMapping
    public ResponseEntity<ResponseBody> deleteMPO(@PathVariable(name = "id") String id) {
        ResponseBody responseBody = new ResponseBody(this.service.deleteMPO(id), HttpStatus.OK.name());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }


}
