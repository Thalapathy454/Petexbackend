package com.petex.restcontroller;

import java.io.IOException;
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

import com.lowagie.text.DocumentException;
import com.petex.entity.HospitalizedEntity;
import com.petex.service.HospitalizedService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/petex")
public class HospitalizedRestController {

	@Autowired
	private HospitalizedService service;

	@PostMapping("/save/{userId}")
	public ResponseEntity<String> save(@RequestBody HospitalizedEntity entity,@PathVariable Long userId) throws DocumentException, IOException {
		Boolean status = service.create(entity, userId);
		if (status) {
			return new ResponseEntity<String>("Hospitalization saved successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Hospitalization not saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HospitalizedEntity>> getAll() {
		List<HospitalizedEntity> entities = service.getAll();
		return new ResponseEntity<>(entities, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		HospitalizedEntity entity = service.getById(id);

		if (entity == null) {
			return new ResponseEntity<>("This Id is not exist", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(entity, HttpStatus.OK);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> upadteData(@PathVariable Integer id, @RequestBody HospitalizedEntity entity) {
		Boolean statusUpdate = service.update(id, entity);
		if (statusUpdate) {

			return new ResponseEntity<String>("Upadted successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Upadte not successfully", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		String deleteById = service.deleteById(id);
		if (deleteById.equals("deleted")) {
			return new ResponseEntity<String>("delete successfully", HttpStatus.OK);

		}
		return new ResponseEntity<String>("Data not deleted successfully", HttpStatus.BAD_REQUEST);

	}

}
