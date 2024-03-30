package com.petex.service;

import java.io.IOException;
import java.util.List;

import com.lowagie.text.DocumentException;
import com.petex.entity.HospitalizedEntity;

public interface HospitalizedService {
	
	public Boolean create(HospitalizedEntity entity, Long userId) throws DocumentException, IOException;
	
	public List<HospitalizedEntity> getAll();
	
	public HospitalizedEntity getById(Integer id);
	
	public String deleteById(Integer id);
	
	public Boolean update(Integer id, HospitalizedEntity entity);

}

