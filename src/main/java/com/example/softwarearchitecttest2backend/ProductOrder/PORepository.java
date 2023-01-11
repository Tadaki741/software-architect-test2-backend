package com.example.softwarearchitecttest2backend.ProductOrder;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PORepository extends PagingAndSortingRepository<ProductOrder,Long> {





}
