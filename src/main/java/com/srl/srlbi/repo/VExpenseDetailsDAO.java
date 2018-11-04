package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.ViewExpenseDetail;


@Repository
public interface VExpenseDetailsDAO extends JpaRepository <ViewExpenseDetail, Long> {

}
