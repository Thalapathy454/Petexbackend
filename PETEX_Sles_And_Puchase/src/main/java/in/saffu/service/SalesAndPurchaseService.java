package in.saffu.service;

import java.util.List;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;

public interface SalesAndPurchaseService  {
	
	public Boolean saveSales(SalesEntity sales);
	
	public List<SalesEntity> getAllSales();
	
	public Boolean savePurchase(PurchaseEntity purchase);
	
	public List<PurchaseEntity> getAllPurchase();


}
