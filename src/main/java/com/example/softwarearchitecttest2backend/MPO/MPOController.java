package com.example.softwarearchitecttest2backend.MPO;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.softwarearchitecttest2backend.response.ResponseBody;


/**
 * @Annotation: mpo/MPO is Material Purchase Order
 */
@RestController
@RequestMapping("mpo")
@CrossOrigin("*")
public class MPOController {

    //Create new MPO
    @PostMapping
    public ResponseEntity<ResponseBody> addMPO (@RequestBody MPO mpo) {

        ResponseBody responseBody = new ResponseBody();

        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);

    }


    //Get all



    //Update



    //Delete



}
