package com.example.softwarearchitecttest2backend.MPO;


import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface MPORepository extends JpaRepository<MPO,Long> {


    @Transactional
    @Modifying
    @Query(value = "update MPO mpo set mpo.status =:status where mpo.id = :id")
    void updateMPO(@Param(value = "id") Long id, @Param(value = "status") String status);


}
