package com.example.softwarearchitecttest2backend.Product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {



}
