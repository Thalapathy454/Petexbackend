package in.petex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.petex.entity.BreedingEntity;
import in.petex.repository.BreedingRespository;
@Service
public class BreedingServiceImpl implements BreedingService {
	
	@Autowired
	BreedingRespository breedingrepository;

	@Override
	public Boolean save(BreedingEntity breed) {
		breedingrepository.save(breed);
		return true;
	}

	@Override
	public Boolean update(Long id, BreedingEntity breed) {
		Optional<BreedingEntity> optionalId = breedingrepository.findById(id);
		if(optionalId.isPresent()) {
			
			BreedingEntity breeding = optionalId.get();
			BeanUtils.copyProperties(breed, breeding);
			breeding.setId(id);
			breedingrepository.save(breeding);
			return true;
		}
		return false;
	}

	@Override
	public void delete(Long id) {
		breedingrepository.deleteById(id);

	}
	@Override
	 public List<BreedingEntity> getAllBreedingServices() {
	        // Fetch all breeding services from the repository
	        return breedingrepository.findAll();
	    }

	@Override
	public BreedingEntity getBreedById(Long id) {
	    Optional<BreedingEntity> optionalBreed = breedingrepository.findById(id);
	    return optionalBreed.orElse(null); // Return null if the entity is not found
	}


}
