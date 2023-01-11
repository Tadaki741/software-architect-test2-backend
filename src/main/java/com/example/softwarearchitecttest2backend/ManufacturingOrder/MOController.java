package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "mo")
public class MOController {

    @Autowired
    private MOService moService;


    @GetMapping(path = "/test")
    public String testMO() {
        return "test controller from MO";
    }

}
