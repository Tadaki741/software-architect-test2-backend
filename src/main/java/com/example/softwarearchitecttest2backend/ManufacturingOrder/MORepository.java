package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;

@Repository
public interface MORepository extends PagingAndSortingRepository<ManufacturingOrder,Long> {



    @Transactional
    @Modifying
    @Query(value = "update ManufacturingOrder mo set mo.clientName =:clientName, mo.completeDate = :completeDate, mo.deliveryDate = :deliveryDate, mo.startDate = :startDate where mo.id =:id")
    void updateMO(@Param(value = "id") long id, @Param(value = "clientName") String clientName, @Param(value = "deliveryDate")Date deliveryDate, @Param(value = "completeDate") Date completeDate, @Param(value = "startDate") Date startDate);


}
