package in.Training.Conroller;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.Training.entity.TrainingEntity;
import in.Training.service.TrainingService;

import java.io.IOException;
import java.util.List;
	import java.util.Optional;
	@CrossOrigin("http://localhost:3000")
	@RestController
	@RequestMapping("/traning")
	public class TrainingController {
@Autowired
	    private final TrainingService serviceService;

	   
	    public TrainingController(TrainingService serviceService) {
	        this.serviceService = serviceService;
	    }

	    @GetMapping("/all")
	    public List<TrainingEntity> getAllServices() {
	        return serviceService.getAllServices();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<TrainingEntity> getServiceById(@PathVariable Long id) {
	        Optional<TrainingEntity> service = serviceService.getServiceById(id);
	        return service.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/save")
	    public ResponseEntity<TrainingEntity> saveProduct(@RequestPart("training")TrainingEntity trainingEntity,
		        @RequestPart("image") MultipartFile image) throws IOException {
	    	TrainingEntity saveCategory = serviceService.saveCategory(trainingEntity, image);
		    return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
		}

	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteServiceById(@PathVariable Long id) {
	        serviceService.deleteServiceById(id);
	        return ResponseEntity.noContent().build();
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<TrainingEntity> updateService(@PathVariable Long id, @RequestBody TrainingEntity updatedService) {
	    	
	    	TrainingEntity result = serviceService.updateService(id, updatedService);
	        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
	    }
	}




