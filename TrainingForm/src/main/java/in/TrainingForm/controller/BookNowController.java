package in.TrainingForm.controller;


	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import in.TrainingForm.entity.BookNowEntity;
import in.TrainingForm.entity.UserEntity;
import in.TrainingForm.repo.BookNowRepo;
import in.TrainingForm.repo.UserRepo;

	@RestController
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/booknow")
	public class BookNowController {
		
		@Autowired	
		private BookNowRepo brepo;
		
		@Autowired
		private UserRepo urepo;
		
		@PostMapping("/save/{userId}")
		public String saveUser(@PathVariable Long userId, @RequestBody BookNowEntity be) {
			
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
