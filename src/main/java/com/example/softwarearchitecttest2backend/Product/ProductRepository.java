package com.example.softwarearchitecttest2backend.Product;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {


    Product findByName(String name);

    Page<Product> findProductByCategory(String category, Pageable pageable);

    @Override
    Iterable<Product> findAll();

    //Use for updating
    @Transactional
    @Modifying
    @Query(value = "update Product p set p.code = :code, p.name = :name, p.description = :description, p.category = :category, p.quantity = :quantity, p.parent = :parent where p.id = :id")
    void updateProduct(@Param(value = "id") long id, @Param(value = "code") String code, @Param(value = "name") String name, @Param(value = "description") String description, @Param(value = "category") String category, @Param(value = "quantity") int quantity, @Param(value = "parent") String parent);
}
