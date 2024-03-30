package com.Grooming.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Grooming.Repo.GroomingRepo;
import com.Grooming.entity.Grooming;

import java.util.List;
	import java.util.Optional;

	@Service
	public class GroomingServiceImpl implements GroomingService {
		@Autowired
	    private final GroomingRepo serviceRepository;

	    public GroomingServiceImpl(GroomingRepo serviceRepository) {
	        this.serviceRepository = serviceRepository;
	    }

	    @Override
	    public List<Grooming> getAllServices() {
	        return serviceRepository.findAll();
	    }

	    @Override
	    public Optional<Grooming> getServiceById(Long id) {
	        return serviceRepository.findById(id);
	    }

	    @Override
	    public Grooming saveService(Grooming service) {
	        return serviceRepository.save(service);
	    }

	    @Override
	    public void deleteServiceById(Long id) {
	        serviceRepository.deleteById(id);
	    }

	    @Override
	    public Grooming updateService(Long id, Grooming updatedService) {
	        if (serviceRepository.existsById(id)) {
	            updatedService.setId(id);
	            return serviceRepository.save(updatedService);
	        }
	        return null;
	    }
	}


