package in.Training.service;

	import java.io.IOException;
import java.util.List;
	import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.Training.entity.TrainingEntity;
import in.Training.repo.TrainingRepo;
@Service
public class TrainingService implements TrainingServiceInt{
  
	@Autowired
    private final TrainingRepo serviceRepository;

    public TrainingService(TrainingRepo serviceRepository) {
        this.serviceRepository = serviceRepository;
    }
	@Override
	public List<TrainingEntity> getAllServices() {
		 return serviceRepository.findAll();
	}

	@Override
	public Optional<TrainingEntity> getServiceById(Long id) {
		 return serviceRepository.findById(id);
	}
	@Override
	public TrainingEntity saveCategory(TrainingEntity trainingEntity,MultipartFile image) throws IOException{
		trainingEntity.setImage(image.getBytes());
		return serviceRepository.save(trainingEntity);
	}

	@Override
	public void deleteServiceById(Long id) {
		serviceRepository.deleteById(id);
		
	}

	@Override
	public TrainingEntity updateService(Long id, TrainingEntity updatedService) {
        if (serviceRepository.existsById(id)) {
            updatedService.setId(id);
            return serviceRepository.save(updatedService);
        }
        return null;
    }
}

