package com.example.softwarearchitecttest2backend.ProductOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class POService {

    @Autowired
    private PORepository poRepository;



    public List<ProductOrder> getAllProductOrder () {
        return (List<ProductOrder>) this.poRepository.findAll();
    }


    public ProductOrder addProductOrder (ProductOrder productOrder){
        return this.poRepository.save(productOrder);
    }


    public boolean updateProductOrder (ProductOrder productOrderDTO, Long id) {
        //Find existed product order first
        ProductOrder existedProductOrder = this.poRepository.findById(id).orElse(null);
        //Check null field from incoming DTO
        if (existedProductOrder == null){
            return false;
        }
        else {
            //Update




            return true;
        }

    }

    public boolean deleteProductOrder (String id){

        //Find the product in the database first
        Optional<ProductOrder> existedProductOrder = this.poRepository.findById(Long.parseLong(id));

        //Delete if exist
        if (existedProductOrder.isEmpty()){
            return false;
        }else {
            this.poRepository.deleteById(existedProductOrder.get().getId());
            return true;
        }


    }


}
