package com.aurionpro.test;

import com.aurionpro.model.ScmApp;

public class ScmAppTest {
	public static void main(String[] args) {
		ScmApp scm = new ScmApp();
		
		scm.connectToScmDb();
		
//		scm.query1();
//		scm.query2();
//		scm.query3();
//		scm.query4();
//		scm.query5();
//		scm.query6();
//		scm.query7();
//		scm.query8();
//		scm.query9();
//		scm.query10();
//		
//		scm.insertIntoSupplier();
//		scm.insertIntoProduct();
//		scm.insertIntoOrder();
//		scm.insertIntoOrderDetail();
//		scm.insertIntoInventory();
//		
//		scm.getSuppliers();
//		scm.getProducts();
//		scm.getOrders();
//		scm.getOrderDetails();
//		scm.getInventory();
		
		scm.displayMenu();
	}
}
