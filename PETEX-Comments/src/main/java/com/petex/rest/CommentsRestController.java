package com.petex.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.petex.entity.CommentsEntity;
import com.petex.repo.CommentsRepo;
import com.petex.service.CommentsService;

@RestController
@RequestMapping("/petex")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentsRestController {
	
	@Autowired
	private CommentsService services;
	
	@PostMapping("/save")
	public ResponseEntity<String> savePetexComments(@RequestBody CommentsEntity entity) {

		Boolean status = services.saveAdotion(entity);
		if (status) {
			return new ResponseEntity<>("PetexComments successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<>("PetexComments not  successfully", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CommentsEntity>>getUser(){
		List<CommentsEntity> allUser = services.getAllUser();
		return new ResponseEntity<List<CommentsEntity>>(allUser,HttpStatus.OK);
		
		
	}
	@DeleteMapping("/deluser/{id}")
	public ResponseEntity<String> deleteMsdata(@PathVariable long id){
		String deleteUser = services.deleteUser(id);
		return new ResponseEntity<String>(deleteUser,HttpStatus.OK);
	}
		
}
