package com.example.ecommerce.service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.ecommerce.exceptions.BusinessException;
import com.example.ecommerce.model.PurchaseReport;
import com.example.ecommerce.repository.PurchaseReportRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class PurchaseImpl implements PurchaseReportService {
	
	@Autowired
	private PurchaseReportRepository prRepo;
	@PostConstruct
	public void init() {
		Date d = new Date(0);
		PurchaseReport pr1 = new PurchaseReport(5,"Rohit","Running",d,"Nike airjorden");
		PurchaseReport pr2 = new PurchaseReport(6,"rohan","Cricket",d,"Addidas runing shoes");
		PurchaseReport pr3 = new PurchaseReport(7,"simplilean","Basketball",d,"formal shoes by bata");
		PurchaseReport pr4 = new PurchaseReport(8,"Rohit","Football",d,"Asian");
		
		prRepo.save(pr1);
		prRepo.save(pr2);
		prRepo.save(pr3);
		prRepo.save(pr4);
	}
	
	public PurchaseReport createPurchaseReport(PurchaseReport pr) throws BusinessException {
		int id = pr.getId();
		PurchaseReport oldPr = null;
		try {
			oldPr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			
		}
		if(oldPr!=null) throw new BusinessException("Purchase report already exists with id: "+id);
		return prRepo.save(pr);	
	}

	public PurchaseReport getPurchaseReportById(int id) throws BusinessException {
		PurchaseReport pr = null;
		try {
			if(id<=0) throw new BusinessException("Purchase Report Id can not be negative or zero");
			pr = prRepo.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("Purchase Report not found with Id: "+id);
		}
		return pr;
	}
	
	public PurchaseReport updatePurchaseReport(PurchaseReport pr) {
		return prRepo.save(pr);
	}
	
	public void deletePurchaseReportById(int id) throws BusinessException {
		try {
			prRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("Invalid id: "+id);
		}catch(EmptyResultDataAccessException e) {
			throw new BusinessException("Puchase Report does not exist with Id: "+id);
		}
	}


	public List<PurchaseReport> getAllPurchaseReports() {
		return prRepo.findAll();
	}

	public List<PurchaseReport> getAllPurchaseReportsByCategory(String category) {
		return prRepo.findByCategory(category);
	}
	

	public List<PurchaseReport> getAllPurchaseReportsByDOP(Date dop) {
		return prRepo.findByDop(dop);
	}

	

}
