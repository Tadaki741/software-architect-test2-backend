package com.example.softwarearchitecttest2backend.BillOfMaterial;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Utils.NullGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BOMService {

    private static final Logger logger = Logger.getLogger(BOMService.class.getName());

    @Autowired
    private BOMRepository bomRepository;


    public List<BillOfMaterial> getAllList () {
        return (List<BillOfMaterial>) this.bomRepository.findAll();
    }

    public BillOfMaterial createNewBillOfMaterial (BillOfMaterial billOfMaterial) {
        return this.bomRepository.save(billOfMaterial);
    }

    public boolean updateProduct(BillOfMaterial billOfMaterialDTO, String id) {

        //Find the product first
        BillOfMaterial existedBillOfMaterial = this.bomRepository.findById(Long.parseLong(id)).orElse(null);
        logger.info("DTO: " + billOfMaterialDTO);
        logger.info("database object: " + existedBillOfMaterial);
        if (existedBillOfMaterial == null) {
            return false;
        }

        //Fill null

        //Update

        return true;
    }


    //Delete
    public boolean deleteBOM(String id) {
        //Check if it exists first
        Optional<BillOfMaterial> databaseBillOfMaterial = this.bomRepository.findById(Long.parseLong(id));
        if (databaseBillOfMaterial.isEmpty()) {
            return false;
        }
        Long targetID = databaseBillOfMaterial.get().getBom_id();
        //Then delete it
        this.bomRepository.deleteById(targetID);
        return true;
    }


}
