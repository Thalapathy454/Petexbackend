package com.petex.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.DocumentException;
import com.petex.entity.HospitalizedEntity;
import com.petex.entity.UserEntity;
import com.petex.repo.HospitalizedRepo;
import com.petex.repo.UserRepo;
import com.petex.service.HospitalizedService;
import com.petex.utils.EmailUtils;
import com.petex.utils.PdfGenerator;

@Service
public class HospitalizeServiceImpl implements HospitalizedService {

	@Autowired
	private HospitalizedRepo repo;

	@Autowired
	private EmailUtils emailUtils;

	@Autowired
	private PdfGenerator pdfGenerator;

	@Autowired
	private UserRepo userRepo;

	@Override
	public Boolean create(HospitalizedEntity entity, Long userId) throws DocumentException, IOException {

		Optional<UserEntity> optinalId = userRepo.findById(userId);

		if (optinalId.isPresent()) {
			UserEntity user = optinalId.get();
			entity.setUser(user);
			HospitalizedEntity save = repo.save(entity);

			File f = new File("Hospitalization.pdf");
			pdfGenerator.generate(save, f);

			String subject = "Hospitalization Booking Report";
			String body = "Hospitalization ";
			String to = user.getEmail();

			emailUtils.sendEmail(subject, body, to, f);
			f.delete();
			return true;
		}
		return false;
	}

	/*
	 * UserEntity user = userRepo.findById(userId).orElse(null); if (user == null) {
	 * return false; }
	 */
	/*
	 * entity.setUser(user); HospitalizedEntity save = repo.save(entity);
	 * 
	 * File f = new File("Appointment.pdf"); pdfGenerator.generate(save, f);
	 * 
	 * String subject = "Hospitalization Booking Report"; String body =
	 * "Hospitalization "; String to = user.getEmail();
	 * 
	 * emailUtils.sendEmail(subject, body, to, f); f.delete(); return true; }
	 */

	@Override
	public List<HospitalizedEntity> getAll() {

		return repo.findAll();
	}

	@Override
	public HospitalizedEntity getById(Integer id) {
		Optional<HospitalizedEntity> optionalId = repo.findById(id);
		if (optionalId.isPresent()) {
			return optionalId.get();
		}

		return null;
	}

	@Override
	public String deleteById(Integer id) {
		repo.deleteById(id);
		return "deleted";
	}

	@Override
	public Boolean update(Integer id, HospitalizedEntity entity) {
		Optional<HospitalizedEntity> optionalId = repo.findById(id);
		if (optionalId.isPresent()) {
			HospitalizedEntity entites = optionalId.get();
			BeanUtils.copyProperties(entity, entites);
			entites.setCustomerId(id);
			repo.save(entites);
			return true;
		}
		return false;
	}
}
