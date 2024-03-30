package in.Training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.Training.entity.TrainingEntity;
@Repository
public interface TrainingRepo extends JpaRepository<TrainingEntity, Long> {
	
	

	
}


