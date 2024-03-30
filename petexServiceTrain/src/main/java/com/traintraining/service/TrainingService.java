package com.traintraining.service;


	import java.util.List;
	import java.util.Optional;

import com.traintraining.entity.Trainning;

public interface TrainingService {
	    List<Trainning> getAllServices();

	    Optional<Trainning> getServiceById(Long id);

	    Trainning saveService(Trainning service);

	    void deleteServiceById(Long id);

	    Trainning updateService(Long id,Trainning updatedService);
	}


