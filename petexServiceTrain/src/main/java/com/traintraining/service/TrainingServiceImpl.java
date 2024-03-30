package com.traintraining.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traintraining.entity.Trainning;
import com.traintraining.repo.TrainingRepo;
@Service
public class TrainingServiceImpl implements TrainingService{
	
	@Autowired
    private final TrainingRepo serviceRepository;

    public TrainingServiceImpl(TrainingRepo serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

	@Override
	public List<Trainning> getAllServices() {
	    return serviceRepository.findAll();
	}

	@Override
	public Optional<Trainning> getServiceById(Long id) {
		 return serviceRepository.findById(id);
	}

	@Override
	public Trainning saveService(Trainning service) {
		 return serviceRepository.save(service);
	}

	@Override
	public void deleteServiceById(Long id) {
		   serviceRepository.deleteById(id);
	}

	@Override
	public Trainning updateService(Long id, Trainning updatedService) {
		   if (serviceRepository.existsById(id)) {
	            updatedService.setId(id);
	            return serviceRepository.save(updatedService);
	        }
		return null;
	}

}
