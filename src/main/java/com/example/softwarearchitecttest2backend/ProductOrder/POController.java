package com.example.softwarearchitecttest2backend.ProductOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
