package com.srl.srlbi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srl.srlbi.model.Banking;
import com.srl.srlbi.model.Bill;
import com.srl.srlbi.model.Customer_payment;
import com.srl.srlbi.model.Expense;
import com.srl.srlbi.model.Invoice;
import com.srl.srlbi.model.Vendor_payment;
import com.srl.srlbi.model.ViewBankBalance;
import com.srl.srlbi.model.*;
import com.srl.srlbi.repo.*;
import com.srl.srlbi.repo.BillDAO;
import com.srl.srlbi.repo.CustomerPaymentDAO;
import com.srl.srlbi.repo.ExpenseDAO;
import com.srl.srlbi.repo.InvoiceDAO;
import com.srl.srlbi.repo.VBankBalanceDAO;
import com.srl.srlbi.repo.VProfitDAO;
import com.srl.srlbi.repo.VendorPaymentDAO;
import com.srl.srlbi.service.SRLService;

@RestController
@RequestMapping("/srl")
public class SRLController {

	@Autowired
    BillDAO billDAO;
	@Autowired
    InvoiceDAO invoiceDAO;
	@Autowired
    CustomerPaymentDAO customerPaymentDAO;
	@Autowired
	VendorPaymentDAO vendorPaymentDAO;
	@Autowired
	PurchaseOrderDAO purchaseOrderDAO;
	@Autowired
	SalesOrderDAO salesOrderDAO;
	@Autowired
	BankingDAO bankingDAO;
	@Autowired
	ExpenseDAO expenseDAO;
	@Autowired
	VProfitDAO vProfitDAO;
	@Autowired
	VQtyDAO vQtyDAO;
	@Autowired
	VBankBalanceDAO vBankBalanceDAO;
	@Autowired
	VExpenseDetailsDAO vExpenseDetailsDAO;
	
	@GetMapping("/runBatch")
	public String runBatch(@PathVariable(value = "path", required=false) String path) {
	    
		if (StringUtils.isEmpty(path)) {
			path = "/Users/nvselva/Documents/coding/dump/";
		}
		String status = "";
		
		status = status + (new SRLService<Bill>()).importData(path, billDAO, Bill.class);
		status = status + (new SRLService<Invoice>()).importData(path, invoiceDAO, Invoice.class);
		status = status + (new SRLService<Expense>()).importData(path, expenseDAO, Expense.class);
		status = status + (new SRLService<Customer_payment>()).importData(path, customerPaymentDAO, Customer_payment.class);
		status = status + (new SRLService<Vendor_payment>()).importData(path, vendorPaymentDAO, Vendor_payment.class);
		status = status + (new SRLService<Banking>()).importData(path, bankingDAO, Banking.class);
		status = status + (new SRLService<Purchase_order>()).importData(path, purchaseOrderDAO, Purchase_order.class);
		status = status + (new SRLService<Sales_order>()).importData(path, salesOrderDAO, Sales_order.class);
	    return status;
	}

	@GetMapping("/profit")
	public List<ViewProfit> getAllProfits() {
	    return vProfitDAO.findAll();
	}
	
	@GetMapping("/qty")
	public List<ViewQuantitySold> getQty() {
	    return vQtyDAO.findAll();
	}
	
	@GetMapping("/expense")
	public List<ViewExpenseDetail> getVExpenseDetails() {
	    return vExpenseDetailsDAO.findAll();
	}
	
	@GetMapping("/bank")
	public List<ViewBankBalance> getBankBalance() {
	    return vBankBalanceDAO.findAll();
	}
	
}
