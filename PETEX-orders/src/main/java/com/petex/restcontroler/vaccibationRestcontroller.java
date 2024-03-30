package com.petex.restcontroler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petex.entity.VaccinationEntity;
import com.petex.service.vacctinationService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins="http://localhost:3000")

public class vaccibationRestcontroller {
	
	@Autowired
	private vacctinationService servies;

	@PostMapping("/save")
	public ResponseEntity<String> saveVacctination(@RequestBody VaccinationEntity entity) {
		Boolean status = servies.save(entity);
		if (status) {
			return new ResponseEntity<String>("orders booked success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("orders not successfully booked", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/get/{customerId}")
	public ResponseEntity<VaccinationEntity> getVacctination(@PathVariable Integer customerId) {
		VaccinationEntity entity = servies.getAppintmentById(customerId);
		return new ResponseEntity<VaccinationEntity>(entity, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<VaccinationEntity>> getAllVacctination1() {
		List<VaccinationEntity> entity = servies.getAllAppointmentData();
		return new ResponseEntity<List<VaccinationEntity>>(entity, HttpStatus.OK);

	}
	@GetMapping("/getRevenue")
	public ResponseEntity<List<VaccinationEntity>> getAllVacctination() {
		List<VaccinationEntity> entity = servies.getAllAppointmentData();
		return new ResponseEntity<List<VaccinationEntity>>(entity, HttpStatus.OK);

	}

	 @PutMapping("/update/{customerId}")
	    public ResponseEntity<String> updateVacctination(@PathVariable Integer customerId,
	                                                   @RequestBody VaccinationEntity entity) {
	        Boolean updatedStatus = servies.updateAppointmentData(customerId, entity);

	        if (updatedStatus) {
	            return new ResponseEntity<>("vactcination data updated successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("vactcination data not updated successfully", HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 @DeleteMapping("/delete/{customerId}")
	 public ResponseEntity<String> deleteVacctination(@PathVariable Integer customerId) {
	     String deleteStatus = servies.deleteAppointmentById(customerId);

	     if (deleteStatus.equals("deleted")) {
	         return new ResponseEntity<>("vactcination deleted successfully", HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>("vactcination not found or not deleted successfully", HttpStatus.NOT_FOUND);
	     }
	 }

	
	

}
