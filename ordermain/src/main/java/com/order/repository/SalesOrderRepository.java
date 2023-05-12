package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.SalesOrder;
@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
