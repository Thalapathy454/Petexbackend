package com.Grooming.Controller;


	import org.springframework.beans.factory.annotation.Autowired;
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

import com.Grooming.Service.GroomingService;
import com.Grooming.entity.Grooming;

import java.util.List;
	import java.util.Optional;
	@CrossOrigin("http://localhost:3000")
	@RestController
	@RequestMapping("/api/grooming")
	public class GroomingControl {
@Autowired
	    private final GroomingService serviceService;

	   
	    public GroomingControl(GroomingService serviceService) {
	        this.serviceService = serviceService;
	    }

	    @GetMapping("/all")
	    public List<Grooming> getAllServices() {
	        return serviceService.getAllServices();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Grooming> getServiceById(@PathVariable Long id) {
	        Optional<Grooming> service = serviceService.getServiceById(id);
	        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/save")
	    public Grooming saveService(@RequestBody Grooming service) {
	        return serviceService.saveService(service);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Grooming> updateService(@PathVariable Long id, @RequestBody Grooming updatedService) {
	    	Grooming result = serviceService.updateService(id, updatedService);
	        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id) {
	        serviceService.deleteServiceById(id);
	        return ResponseEntity.noContent().build();
	    }
	}


