package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Product.ProductRepository;
import com.example.softwarearchitecttest2backend.Utils.NullGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MOService {

    private static final Logger logger = Logger.getLogger(MOService.class.getName());

    @Autowired
    private MORepository repository;

    //This property will work to retrieve to product from "product" table
    @Autowired
    private ProductRepository productRepository;

    public ManufacturingOrder addMO (ManufacturingOrder manufacturingOrder, String id) {

        //We will need to query to find that product
        Product product = this.productRepository.findById(Long.parseLong(id)).orElse(null);
        if (product == null) {
            return null;
        }

        else {
            manufacturingOrder.setProduct(product);
        }
        return this.repository.save(manufacturingOrder);
    }

    public List<ManufacturingOrder> getAllMO () {
        //Find each MO, then set its product
        List<ManufacturingOrder> manufacturingOrders = (List<ManufacturingOrder>) this.repository.findAll();

        for (ManufacturingOrder mo :
                manufacturingOrders) {
            logger.log(Level.WARNING, "corresponding product: " + mo.getProduct());
        }

        //Then return
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
            //Get its product first
            Long correspondingProductID = manufacturingOrder.getProduct().getId();

            //Delete the Manufacturing Order parent object
            this.repository.deleteById(manufacturingOrder.getId());

            //Search for that product, if its quantity is >= 1, we allow the minus operations
            Product productToUpdate = this.productRepository.findById(correspondingProductID).orElse(null);

            if (productToUpdate == null){
                return false;
            }

            else {
                //Update that product with the quantity - 1
                //Check if >= 1
                if (productToUpdate.getQuantity() >= 1){
                    this.productRepository.updateProduct(productToUpdate.getId(),productToUpdate.getCode(),productToUpdate.getName(),productToUpdate.getDescription(),productToUpdate.getCategory(),productToUpdate.getQuantity() - 1,productToUpdate.getPrice());
                    return true;
                }
                return false;
            }



        }

    }

}
