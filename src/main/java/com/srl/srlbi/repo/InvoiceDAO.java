package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Invoice;



@Repository
public interface InvoiceDAO extends JpaRepository <Invoice, Long> {

}
