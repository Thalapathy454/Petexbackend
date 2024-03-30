package in.petex.controller;

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

import in.petex.entity.BreedingEntity;

import in.petex.service.BreedingService;
@CrossOrigin(origins = "*")
@RequestMapping("/breeds")
@RestController

public class BreedingController {
	@Autowired
	BreedingService breedingservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody BreedingEntity breed){
		Boolean status = breedingservice.save(breed);
		
		if(status) {
			return new ResponseEntity<>("Data is saved successfully",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("Data is not saved successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody BreedingEntity breeding) {
		Boolean update = breedingservice.update(id, breeding);
		if (update) {
			return new ResponseEntity<>("Data updated successfully", HttpStatus.CREATED);
		} else {

			return new ResponseEntity<>("Data failed to  update", HttpStatus.INTERNAL_SERVER_ERROR);

		}
			
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> delete(@PathVariable Long Id) {

		breedingservice.delete(Id);

		return new ResponseEntity<>("Report deleted successfully", HttpStatus.OK);
	}
	
    // GET method to fetch details of all breeding services
    @GetMapping("/all")
    public ResponseEntity<List<BreedingEntity>> getAllBreedingServices() {
        List<BreedingEntity> breedingList = breedingservice.getAllBreedingServices();
        return new ResponseEntity<>(breedingList, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BreedingEntity> getBreedById(@PathVariable Long id) {
        BreedingEntity breed = breedingservice.getBreedById(id);
        if (breed != null) {
            return new ResponseEntity<>(breed, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    
}
