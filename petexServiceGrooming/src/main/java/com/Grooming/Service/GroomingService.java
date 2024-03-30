package com.Grooming.Service;

	import java.util.List;
	import java.util.Optional;

import com.Grooming.entity.Grooming;
	public interface GroomingService {
	    List<Grooming> getAllServices();

	    Optional<Grooming> getServiceById(Long id);

	    Grooming saveService(Grooming service);

	    void deleteServiceById(Long id);

	    Grooming updateService(Long id,Grooming updatedService);
	}


