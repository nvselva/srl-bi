package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Bill;


@Repository
public interface BillDAO extends JpaRepository <Bill, Long> {

}
