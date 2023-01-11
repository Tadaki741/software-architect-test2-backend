package com.example.softwarearchitecttest2backend.BillOfMaterial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
