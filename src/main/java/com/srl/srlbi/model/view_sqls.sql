CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`srl_bill` AS select uuid_short() AS `id`,`a`.`bill_date` AS `bill_date`,`a`.`bill_number` AS `bill_number`,`a`.`cf_cust_wo` AS `cust_wo`,`a`.`cf_cust_invoice` AS `invoice`,`a`.`vendor_name` AS `vendor_name`,`a`.`cf_vehicle_no` AS `vehicle_number`,`a`.`quantity` AS `quantity`,`a`.`rate` AS `rate`,`a`.`sub_total` AS `subtotal`,`a`.`adjustment` AS `adjustment`,`a`.`total` AS `total`,`a`.`item_name` AS `item`,`a`.`purchase_order` AS `srl_po` from `srl`.`t_bill` `a`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`srl_customer_payment` AS select uuid_short() AS `id`,`a`.`date` AS `paid_date`,`a`.`invoice_number` AS `invoice`,`a`.`invoice_amount` AS `paid_amount`,`a`.`amount` AS `check_amount` from `srl`.`t_customer_payment` `a`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`srl_invoice` AS select uuid_short() AS `id`,`a`.`invoice_date` AS `invoice_date`,`a`.`invoice_number` AS `invoice`,`a`.`purchase_order` AS `cust_wo`,`a`.`item_name` AS `item`,`a`.`quantity` AS `quantity`,`a`.`item_cf_date` AS `item_date`,`a`.`item_cf_lorry_no` AS `vehicle_number`,`a`.`item_cf_receipt_no` AS `bill_number`,`a`.`item_price` AS `item_price`,`a`.`item_tax_amount` AS `tax_amount`,`a`.`item_total` AS `item_total`,`a`.`adjustment` AS `adjustments`,`a`.`total` AS `total`,`a`.`notes` AS `notes`,`a`.`cf_withheld_amount` AS `cf_withheld_amount` from `srl`.`t_invoice` `a` where (not((`a`.`invoice_number` like 'DU%')));

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`srl_profits` AS select uuid_short() AS `id`,concat(year(`b`.`invoice_date`),'-',monthname(`b`.`invoice_date`)) AS `sales_month`,concat(min(`a`.`invoice`),' to ',max(`a`.`invoice`)) AS `invoices`,concat(min(`a`.`from_rmr`),' to ',max(`a`.`to_rmr`)) AS `RMRs`,concat(min(`b`.`invoice_date`),' to ',max(`b`.`invoice_date`)) AS `inv_dates`,round(avg(`a`.`rate`),2) AS `purchase_rate`,sum(`a`.`quantity`) AS `purchase_quantity`,sum(`a`.`paid_amount`) AS `purchase_amount_paid`,sum(`b`.`quantity`) AS `sales_quantity`,round(sum(`b`.`item_total`),2) AS `sales_amount_total`,sum(`b`.`gst`) AS `sales_gst`,round(sum((`b`.`item_total` - `a`.`paid_amount`)),2) AS `sales_profit`,round(sum(`b`.`adjustments`),2) AS `security_deposit`,(sum((`b`.`item_total` - `a`.`paid_amount`)) + round(sum((-(1) * `b`.`cf_withheld_amount`)),2)) AS `net_profit`,sum(`b`.`total`) AS `amount_to_be_received`,sum(`b`.`paid_amount`) AS `actual_amount_received`,sum(`b`.`over_due_amount`) AS `overdue_amount` from (`srl`.`view_purchases` `a` join `srl`.`view_sales` `b` on((`a`.`invoice` = `b`.`invoice`))) group by concat(year(`b`.`invoice_date`),'-',monthname(`b`.`invoice_date`));

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`srl_vendor_payment` AS select uuid_short() AS `id`,`a`.`date` AS `paid_date`,`a`.`vendor_name` AS `vendor_name`,`a`.`bill_number` AS `bill_number`,`a`.`amount` AS `bill_amount`,`a`.`bill_amount` AS `paid_amount`,`a`.`paid_through` AS `paid_mode` from `srl`.`t_vendor_payment` `a`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_bank_balance` AS select uuid_short() AS `id`,max(`srl_banking`.`trans_date`) AS `till_date`,round(sum(`srl_banking`.`trans_amt`),2) AS `bank_balance`,sum((case when (`srl_banking`.`trans_amt` < 0) then `srl_banking`.`trans_amt` else 0 end)) AS `debit_amt`,sum((case when (`srl_banking`.`trans_amt` > 0) then `srl_banking`.`trans_amt` else 0 end)) AS `credit_amt`,((select (-(1) * sum(`srl_banking`.`trans_amt`)) from `srl`.`srl_banking` where ((`srl_banking`.`transaction_description` like 'ATM%') or (`srl_banking`.`transaction_description` like 'VELUSAMY N%'))) - ((select sum(`srl`.`t_expense`.`total`) from `srl`.`t_expense` where (`srl`.`t_expense`.`paid_through` like 'Petty%')) + (select sum(`srl_vendor_payment`.`paid_amount`) from `srl`.`srl_vendor_payment` where (`srl_vendor_payment`.`paid_mode` like 'Petty%')))) AS `cash_balance` from `srl`.`srl_banking`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_expenses` AS select uuid_short() AS `id`,concat(year(`srl`.`t_expense`.`expense_date`),'-',monthname(`srl`.`t_expense`.`expense_date`)) AS `exp_month`,sum(`srl`.`t_expense`.`expense_amount`) AS `expenses` from `srl`.`t_expense` where (not((`srl`.`t_expense`.`expense_account` like '%GST%'))) group by concat(year(`srl`.`t_expense`.`expense_date`),'-',monthname(`srl`.`t_expense`.`expense_date`));

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_profits` AS select uuid_short() AS `id`,`a`.`sales_month` AS `sales_month`,`a`.`invoices` AS `invoices`,`a`.`RMRs` AS `RMRs`,`a`.`inv_dates` AS `inv_dates`,`a`.`purchase_rate` AS `purchase_rate`,`a`.`purchase_quantity` AS `purchase_quantity`,`a`.`purchase_amount_paid` AS `purchase_amount_paid`,`a`.`sales_quantity` AS `sales_quantity`,`a`.`sales_amount_total` AS `sales_amount_total`,`a`.`sales_gst` AS `sales_gst`,`a`.`sales_profit` AS `sales_profit`,`a`.`security_deposit` AS `security_deposit`,`a`.`net_profit` AS `net_profit`,`a`.`amount_to_be_received` AS `amount_to_be_received`,`a`.`actual_amount_received` AS `actual_amount_received`,`a`.`overdue_amount` AS `overdue_amount`,`b`.`expenses` AS `expenses`,'30%' AS `income_tax_pct`,round((`a`.`net_profit` * 0.30),2) AS `income_tax`,round(((`a`.`net_profit` * 0.70) - `b`.`expenses`),2) AS `final_profit`,round((((`a`.`net_profit` * 0.70) - `b`.`expenses`) * 0.8),2) AS `partner_1_share`,round((((`a`.`net_profit` * 0.70) - `b`.`expenses`) * 0.2),2) AS `partner_2_share` from (`srl`.`srl_profits` `a` join `srl`.`view_expenses` `b`) where (`a`.`sales_month` = `b`.`exp_month`);

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_purchase_payments` AS select uuid_short() AS `id`,`srl_vendor_payment`.`bill_number` AS `bill_number`,round(sum(`srl_vendor_payment`.`paid_amount`),2) AS `paid_amount` from `srl`.`srl_vendor_payment` group by `srl_vendor_payment`.`bill_number`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_purchases` AS select uuid_short() AS `id`,`a`.`cust_wo` AS `cust_wo`,`a`.`invoice` AS `invoice`,round(sum(`a`.`quantity`),2) AS `quantity`,round(sum(`a`.`adjustment`),2) AS `adjustment`,round(sum(`b`.`paid_amount`),2) AS `paid_amount`,round(avg(`a`.`rate`),2) AS `rate`,concat(min(`a`.`bill_number`),' to ',max(`a`.`bill_number`)) AS `RMRs`,min(`a`.`bill_number`) AS `from_rmr`,max(`a`.`bill_number`) AS `to_rmr` from (`srl`.`srl_bill` `a` join `srl`.`view_purchase_payments` `b`) where (`a`.`bill_number` = `b`.`bill_number`) group by `a`.`cust_wo`,`a`.`invoice` order by `a`.`cust_wo`,`a`.`invoice`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_quantity_sold` AS select uuid_short() AS `id`,`a`.`cust_wo` AS `cust_wo`,max(`b`.`wo_qty`) AS `wo_qty`,concat(min(`a`.`invoice`),' to ',max(`a`.`invoice`)) AS `invoices`,round(sum(`a`.`quantity`),2) AS `qty_sold` from (`srl`.`srl_invoice` `a` join `srl`.`view_sales_order` `b`) where (`a`.`cust_wo` = `b`.`wo_num`) group by `a`.`cust_wo`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_sales` AS select uuid_short() AS `id`,`a`.`invoice_date` AS `invoice_date`,`a`.`invoice` AS `invoice`,`a`.`cust_wo` AS `cust_wo`,`a`.`item_total` AS `item_total`,`a`.`gst` AS `gst`,`a`.`adjustments` AS `adjustments`,`a`.`total` AS `total`,`a`.`quantity` AS `quantity`,`a`.`cf_withheld_amount` AS `cf_withheld_amount`,sum(`b`.`check_amount`) AS `check_amount`,sum((case when isnull(`b`.`invoice`) then 0 else `b`.`paid_amount` end)) AS `paid_amount`,(sum((case when isnull(`b`.`invoice`) then 0 else `b`.`paid_amount` end)) - sum(distinct `a`.`total`)) AS `over_due_amount` from (`srl`.`view_sales_invoice` `a` left join `srl`.`srl_customer_payment` `b` on((`a`.`invoice` = `b`.`invoice`))) group by `a`.`invoice_date`,`a`.`invoice`,`a`.`cust_wo`,`a`.`item_total`,`a`.`gst`,`a`.`adjustments`,`a`.`total`,`a`.`quantity`,`a`.`cf_withheld_amount`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_sales_invoice` AS select uuid_short() AS `id`,`srl_invoice`.`invoice_date` AS `invoice_date`,`srl_invoice`.`invoice` AS `invoice`,`srl_invoice`.`cust_wo` AS `cust_wo`,round(sum(`srl_invoice`.`quantity`),2) AS `quantity`,round(sum(`srl_invoice`.`item_total`),2) AS `item_total`,round(sum(`srl_invoice`.`tax_amount`),2) AS `gst`,`srl_invoice`.`adjustments` AS `adjustments`,`srl_invoice`.`total` AS `total`,`srl_invoice`.`cf_withheld_amount` AS `cf_withheld_amount` from `srl`.`srl_invoice` group by `srl_invoice`.`invoice_date`,`srl_invoice`.`invoice`,`srl_invoice`.`cust_wo`,`srl_invoice`.`adjustments`,`srl_invoice`.`total`,`srl_invoice`.`cf_withheld_amount`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `srl`.`view_sales_order` AS select `srl`.`t_sales_order`.`purchase_order` AS `wo_num`,sum(`srl`.`t_sales_order`.`quantity_ordered`) AS `wo_qty`,max(`srl`.`t_sales_order`.`total`) AS `total_amount`,sum(`srl`.`t_sales_order`.`item_tax_amount`) AS `gst_amount`,round(sum(`srl`.`t_sales_order`.`quantity_invoiced`),2) AS `qty_invoiced` from `srl`.`t_sales_order` group by `srl`.`t_sales_order`.`purchase_order`;
