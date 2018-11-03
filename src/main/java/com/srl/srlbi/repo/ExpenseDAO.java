package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.Expense;


@Repository
public interface ExpenseDAO extends JpaRepository <Expense, Long> {

}
