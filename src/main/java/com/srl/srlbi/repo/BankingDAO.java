package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Banking;


@Repository
public interface BankingDAO extends JpaRepository <Banking, Long> {

}
