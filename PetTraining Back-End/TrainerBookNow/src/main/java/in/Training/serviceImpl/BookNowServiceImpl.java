package in.Training.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Training.entity.BookNowEntity;
import in.Training.entity.UserEntity;
import in.Training.repo.BookNowRepo;
import in.Training.repo.UserRepo;
import in.Training.service.BookNowService;

@Service
public class BookNowServiceImpl implements BookNowService {

	@Autowired
	private BookNowRepo bookNowRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public Boolean saveBookNow(BookNowEntity entity, Long userId) {
		 Optional<UserEntity> optionalUser = userRepo.findById(entity.getUser().getUserId());
		    if (optionalUser.isPresent()) {
		        UserEntity user = optionalUser.get();
		        entity.setUser(user);
		        bookNowRepo.save(entity);
		        return true;
		    } else {
		        throw new RuntimeException("User not found with ID: " + entity.getUser().getUserId());
		    }
		

	
}}