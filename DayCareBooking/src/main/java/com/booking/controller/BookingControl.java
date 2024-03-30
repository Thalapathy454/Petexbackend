package com.booking.controller;



	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	
import com.booking.entity.DayCareBooking;
import com.booking.entity.UserEntity;
import com.booking.repo.BookRepo;
import com.booking.repo.UserRepo;

	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/book")
	public class BookingControl {
		
		@Autowired
		private BookRepo brepo;
		
		@Autowired
		private UserRepo urepo;
		
		@PostMapping("/save/{userId}")
		public String saveUser(@PathVariable Long userId, @RequestBody DayCareBooking be) {
			
			System.out.println(userId);
			
			Optional<UserEntity> u= urepo.findById(userId);
			
			
			if(u.isPresent()) {
				
				UserEntity u1= u.get();
				be.setUser(u1);
				brepo.save(be);
				
				return "Booked";
			}
			
			return "Enter valid User";
			
		}
		
		
	}

