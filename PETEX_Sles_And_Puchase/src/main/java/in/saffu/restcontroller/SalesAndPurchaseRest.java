package in.saffu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;
import in.saffu.service.SalesAndPurchaseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/petex")
public class SalesAndPurchaseRest {
	
	@Autowired
	private SalesAndPurchaseService services;
	
	@PostMapping("/sales")
	public ResponseEntity<String> saveSalesData(@RequestBody SalesEntity entity){
		Boolean salesStatus = services.saveSales(entity);
		
		if (salesStatus) {
			return new ResponseEntity<String>("sallening successfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("sallening not successfully",HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	@PostMapping("/getsales")
	public ResponseEntity<List<SalesEntity>> getAllSales(){
		List<SalesEntity> allSales = services.getAllSales();
		return new ResponseEntity<List<SalesEntity>>(allSales,HttpStatus.OK);
	}
	
	@PostMapping("/getpurchase")
	public ResponseEntity<List<PurchaseEntity>> getAllPurchase(){
		List<PurchaseEntity> allpurchase = services.getAllPurchase();
		return new ResponseEntity<List<PurchaseEntity>>(allpurchase,HttpStatus.OK);
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<String> savePurchaseData(@RequestBody PurchaseEntity entity){
		Boolean salesStatus = services.savePurchase(entity);
		
		if (salesStatus) {
			return new ResponseEntity<String>("Purchaseing successfully",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Purchaseing not successfully",HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	
	
}
