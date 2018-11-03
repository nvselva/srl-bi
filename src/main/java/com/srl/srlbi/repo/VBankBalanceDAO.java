package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.ViewBankBalance;


@Repository
public interface VBankBalanceDAO extends JpaRepository <ViewBankBalance, Long> {


}
