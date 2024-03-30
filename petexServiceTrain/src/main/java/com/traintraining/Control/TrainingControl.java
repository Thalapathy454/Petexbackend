package com.traintraining.Control;


	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;


import com.traintraining.entity.Trainning;
import com.traintraining.service.TrainingService;

import java.util.List;
	import java.util.Optional;
	@CrossOrigin("http://localhost:3000")
	@RestController
	@RequestMapping("/house/board")
	public class TrainingControl {

	    private final TrainingService serviceService;

	   
	    public TrainingControl(TrainingService serviceService) {
	        this.serviceService = serviceService;
	    }

	    @GetMapping("/all")
	    public List<Trainning> getAllServices() {
	        return serviceService.getAllServices();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Trainning> getServiceById(@PathVariable Long id) {
	        Optional<Trainning> service = serviceService.getServiceById(id);
	        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/save")
	    public Trainning saveService(@RequestBody Trainning service) {
	        return serviceService.saveService(service);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Trainning> updateService(@PathVariable Long id, @RequestBody Trainning updatedService) {
	    	Trainning result = serviceService.updateService(id, updatedService);
	        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id) {
	        serviceService.deleteServiceById(id);
	        return ResponseEntity.noContent().build();
	    }
	}




