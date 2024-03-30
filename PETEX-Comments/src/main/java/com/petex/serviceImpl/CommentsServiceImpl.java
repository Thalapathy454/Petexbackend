package com.petex.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petex.entity.CommentsEntity;
import com.petex.repo.CommentsRepo;
import com.petex.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsRepo repo;

	@Override
	public Boolean saveAdotion(CommentsEntity entity) {
		repo.save(entity);
		return true;
	}

	


	@Override
	public List<CommentsEntity> getAllUser() {
		
		// TODO Auto-generated method stub
		return repo.findAll();
	}




	@Override
	public CommentsEntity updateUser(Long id, CommentsEntity user) {
		
		
		return null;
	}




	@Override
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "deleted user successfully";
	}

}
