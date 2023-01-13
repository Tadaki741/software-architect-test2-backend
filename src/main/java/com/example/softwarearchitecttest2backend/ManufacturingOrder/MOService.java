package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Utils.NullGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MOService {

    @Autowired
    private MORepository repository;

    public ManufacturingOrder addMO (ManufacturingOrder manufacturingOrder) {
        return this.repository.save(manufacturingOrder);
    }

    public List<ManufacturingOrder> getAllMO () {
        return (List<ManufacturingOrder>) this.repository.findAll();
    }

    public boolean updateMO (ManufacturingOrder manufacturingOrderDTO, String id) {
        //Find the product first
        ManufacturingOrder existedMO = this.repository.findById(Long.parseLong(id)).orElse(null);

        if (existedMO == null) {
            return false;
        }

        //Fill null
        NullGuard.updateIfChanged(existedMO::setClientName, manufacturingOrderDTO.getClientName(), existedMO::getClientName);
        NullGuard.updateIfChanged(existedMO::setDeliveryDate, manufacturingOrderDTO.getDeliveryDate(), existedMO::getDeliveryDate);
        NullGuard.updateIfChanged(existedMO::setStartDate, manufacturingOrderDTO.getStartDate(), existedMO::getStartDate);
        NullGuard.updateIfChanged(existedMO::setCompleteDate, manufacturingOrderDTO.getCompleteDate(), existedMO::getCompleteDate);


        this.repository.updateMO(Long.parseLong(id), existedMO.getClientName(), existedMO.getDeliveryDate(), existedMO.getCompleteDate(), existedMO.getStartDate(), existedMO.getStatus());
        return true;
    }

    public boolean deleteMO (String id) {
        ManufacturingOrder manufacturingOrder = this.repository.findById(Long.parseLong(id)).orElse(null);

        if (manufacturingOrder == null){
            return false;
        }

        else {
            //Delete
            this.repository.deleteById(manufacturingOrder.getId());
            return true;
        }

    }

}
