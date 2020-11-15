package com.demo.empdept.repository;

import com.demo.empdept.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Stock sc set sc.stock = sc.stock - 1 where sc.stockId = :id and sc.stock >= -1")
    void descByProdId(@Param(value = "id") long id);

}
