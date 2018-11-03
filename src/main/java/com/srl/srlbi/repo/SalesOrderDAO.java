package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Sales_order;



@Repository
public interface SalesOrderDAO extends JpaRepository <Sales_order, Long> {

}
