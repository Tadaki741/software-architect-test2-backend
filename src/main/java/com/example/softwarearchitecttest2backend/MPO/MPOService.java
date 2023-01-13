package com.example.softwarearchitecttest2backend.MPO;

import com.example.softwarearchitecttest2backend.Product.Product;
import com.example.softwarearchitecttest2backend.Product.ProductRepository;
import com.example.softwarearchitecttest2backend.Utils.NullGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPOService {

    @Autowired
    private MPORepository repository;

    @Autowired
    private ProductRepository productRepository;

    //Create
    public MPO createMPO (MPO mpo, String id) {

        //We need to find the associated product with it
        //We will need to query to find that product
        Product product = this.productRepository.findById(Long.parseLong(id)).orElse(null);
        if (product == null) {
            return null;
        }

        else {
            mpo.setProduct(product);
        }


        return this.repository.save(mpo);
    }

    //Update
    public boolean updateMPO(MPO mpoDTO, String id) {

        //Find existed
        MPO mpo = this.repository.findById(Long.parseLong(id)).orElse(null);

        //Check null
        if (mpo == null){
            return false;
        }

        else {
            NullGuard.updateIfChanged(mpo::setStatus,mpoDTO.getStatus(),mpo::getStatus);
            //update
            this.repository.updateMPO(mpo.getId(), mpo.getStatus());
            return true;
        }
    }

    //Get all
    public List<MPO> getAllMPO (){
        return this.repository.findAll();
    }

    //Delete
    public boolean deleteMPO (String id){

        //Find existed
        MPO mpo = this.repository.findById(Long.parseLong(id)).orElse(null);
        if (mpo == null){
            return false;
        }
        else {
            Long correspondingProductID = mpo.getProduct().getId();

            //Delete the mpo
            this.repository.deleteById(mpo.getId());

            //Search for that product and increase the value of it
            Product productToUpdate = this.productRepository.findById(correspondingProductID).orElse(null);

            if (productToUpdate == null){
                return false;
            }

            else {
                //Found product, update its quantity plus 1
                this.productRepository.updateProduct(productToUpdate.getId(),productToUpdate.getCode(),productToUpdate.getName(),productToUpdate.getDescription(),productToUpdate.getCategory(),productToUpdate.getQuantity() + 1,productToUpdate.getPrice());
                return true;
            }
        }
    }


}
