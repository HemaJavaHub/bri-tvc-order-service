package com.demo.productservice.repositories;

import com.demo.orderservice.models.ProductForOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductForOrder,Integer> {

    @Modifying
    @Query(value = "update product p set p.count = p.count-1 where p.id = id", nativeQuery = true)
    void updateProductCount(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product p set p.count = 20 where p.id = id", nativeQuery = true)
    void restockInventory(@Param("id") Integer id);


}
