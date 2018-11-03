package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Customer_payment;



@Repository
public interface CustomerPaymentDAO extends JpaRepository <Customer_payment, Long> {

}
