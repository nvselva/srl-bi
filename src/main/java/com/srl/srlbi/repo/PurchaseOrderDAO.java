package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Purchase_order;



@Repository
public interface PurchaseOrderDAO extends JpaRepository <Purchase_order, Long> {

}
