package com.example.softwarearchitecttest2backend.BillOfMaterial;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BOMRepository extends PagingAndSortingRepository<BillOfMaterial,Long> {



}
