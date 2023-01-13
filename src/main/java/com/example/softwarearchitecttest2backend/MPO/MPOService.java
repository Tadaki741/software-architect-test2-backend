package com.example.softwarearchitecttest2backend.MPO;

import com.example.softwarearchitecttest2backend.Utils.NullGuard;
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
            this.repository.deleteById(mpo.getId());
            return true;
        }
    }


}
