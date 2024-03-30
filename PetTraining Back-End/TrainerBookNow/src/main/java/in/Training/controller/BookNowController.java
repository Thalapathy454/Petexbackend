package in.Training.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import in.Training.entity.BookNowEntity;
import in.Training.entity.UserEntity;
import in.Training.service.BookNowService;

	@RestController
	@CrossOrigin(origins = "http://localhost:3000/")
	@RequestMapping("/booknow")
	public class BookNowController {

		@Autowired
		private BookNowService services;

		@PostMapping("/save/{userId}")
		public ResponseEntity<String> saveDaycare(@RequestBody BookNowEntity entity, @PathVariable Long userId) {
			Boolean status = services.saveBookNow(entity, userId);
			if (status) {
				return new ResponseEntity<String>("Data saved successfully", HttpStatus.CREATED);
			} else {
				return new ResponseEntity<String>("Data not saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);

			}
		}
	}


