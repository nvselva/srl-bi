package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Vendor_payment;



@Repository
public interface VendorPaymentDAO extends JpaRepository <Vendor_payment, Long> {

}
