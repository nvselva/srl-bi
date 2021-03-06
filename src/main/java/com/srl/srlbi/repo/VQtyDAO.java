package com.srl.srlbi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srl.srlbi.model.ViewQuantitySold;


@Repository
public interface VQtyDAO extends JpaRepository <ViewQuantitySold, Long> {

//	@Override 
//	@Query("SELECT a.salesMonth AS SALESMONTH,\n" + 
//			"    a.invoices,\n" + 
//			"    a.invDates,\n" + 
//			"    a.purchaseQuantity,\n" + 
//			"    a.purchaseAmountPaid,\n" + 
//			"    a.salesQuantity,\n" + 
//			"    a.salesAmountTotal,\n" + 
//			"    a.salesGst,\n" + 
//			"    a.salesProfit,\n" + 
//			"    a.securityDeposit,\n" + 
//			"    a.netProfit,\n" + 
//			"    a.amountToBeReceived,\n" + 
//			"    a.actualAmountReceived,\n" + 
//			"    a.overdueAmount\n" + 
//			"FROM ViewProfit a" + 
//			"")
//	List<ViewProfit> findAll();

}
