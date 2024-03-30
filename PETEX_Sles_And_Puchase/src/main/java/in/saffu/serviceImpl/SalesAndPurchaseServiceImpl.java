package in.saffu.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.saffu.entity.PurchaseEntity;
import in.saffu.entity.SalesEntity;
import in.saffu.repository.PurchaseRepo;
import in.saffu.repository.SalesRepo;
import in.saffu.service.SalesAndPurchaseService;

@Service
public class SalesAndPurchaseServiceImpl implements SalesAndPurchaseService {

	@Autowired
	private SalesRepo salesRepo;
	
	@Autowired
	private PurchaseRepo purchaseRepo;
	
	@Override
	public Boolean saveSales(SalesEntity sales) {
		salesRepo.save(sales);
		return true;
	}

	@Override
	public List<SalesEntity> getAllSales() {
		return salesRepo.findAll();
	}

	@Override
	public Boolean savePurchase(PurchaseEntity purchase) {
		purchaseRepo.save(purchase);
		return true;
	}

	@Override
	public List<PurchaseEntity> getAllPurchase() {
		return purchaseRepo.findAll();
	}

}
