package com.example.softwarearchitecttest2backend.ManufacturingOrder;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MORepository extends PagingAndSortingRepository<ManufacturingOrder,Long> {



}
