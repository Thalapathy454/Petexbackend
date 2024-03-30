package in.Training.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import in.Training.entity.TrainingEntity;

public interface TrainingServiceInt {
	   List<TrainingEntity>getAllServices();

	    Optional<TrainingEntity> getServiceById(Long id);

		public TrainingEntity saveCategory(TrainingEntity trainingEntity,MultipartFile image) throws IOException;


	    void deleteServiceById(Long id);

	    TrainingEntity updateService(Long id,TrainingEntity updatedService);

}
