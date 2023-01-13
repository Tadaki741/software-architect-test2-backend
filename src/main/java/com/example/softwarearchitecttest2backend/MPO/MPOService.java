package com.example.softwarearchitecttest2backend.MPO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MPOService {

    @Autowired
    private MPORepository repository;


    //Create
    public MPO createMPO (MPO mpo) {
        return this.repository.save(mpo);
    }

    //Update
    public boolean updateMPO(MPO mpoDTO, String id) {

        return true;
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
            this.repository.deleteById(mpo.getId());
            return true;
        }
    }


}
