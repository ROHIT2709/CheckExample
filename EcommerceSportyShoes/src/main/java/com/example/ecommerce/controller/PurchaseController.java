package com.example.ecommerce.controller;
////import com.example.ecommerce.*;

import java.util.Date;
////import java.util.List;
import java.util.List;

import org.springframework.http.ResponseEntity;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.exceptions.BusinessException;
import com.example.ecommerce.model.PurchaseReport;
import com.example.ecommerce.service.PurchaseImpl;
//import com.example.ecommerce.service.PurchaseReportService;

@RestController
public class PurchaseController {
	 
	@GetMapping("category/{category}")
	 
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByCategory(@PathVariable String category){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByCategory(category), HttpStatus.OK);
	}
	@GetMapping("date/{dateInMs}")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReportsByDop(@PathVariable Long dateInMs){
		Date dop = new Date(dateInMs);
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReportsByDOP(dop), HttpStatus.OK);
	}
	@GetMapping("purchaseReport/all")
	public ResponseEntity<List<PurchaseReport>> getAllPurchaseReport(){
		return new ResponseEntity<List<PurchaseReport>>(service.getAllPurchaseReports(), HttpStatus.OK);
	}
	
	 
	 
	}

	


