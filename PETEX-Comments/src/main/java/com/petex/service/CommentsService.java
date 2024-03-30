package com.petex.service;

import java.util.List;

import com.petex.entity.CommentsEntity;

public interface CommentsService {

	public Boolean saveAdotion(CommentsEntity entity);
	
	public List<CommentsEntity > getAllUser();

	CommentsEntity updateUser(Long id, CommentsEntity user);

	public String deleteUser(Long id);


}
