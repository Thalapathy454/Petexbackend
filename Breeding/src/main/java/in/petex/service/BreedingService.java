package in.petex.service;

import java.util.List;

import in.petex.entity.BreedingEntity;


public interface BreedingService {

	public Boolean save(BreedingEntity breed);

	public Boolean update(Long id, BreedingEntity breed);

	void delete(Long id);

	public List<BreedingEntity> getAllBreedingServices();
	
	public BreedingEntity getBreedById(Long id);
	
	

}
