package com.doctsighn.service;

import java.io.IOException;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.doctsighn.entity.DoctorEntity;



import com.doctsighn.binding.DoctorSingUp;
import com.doctsighn.binding.LoginForm;
import com.doctsighn.binding.NewConfirmPwdForm;
import com.doctsighn.binding.OtpForm;

public interface DoctorSingUpService {

	public String saveDocter(DoctorSingUp form,MultipartFile image) throws IOException;

	public DoctorEntity getDoctorById(Long id);

	public String login(LoginForm form);

	public Boolean forgetPwd(String email);

	public String validOtp(OtpForm form);

	public String confirmPassword(NewConfirmPwdForm form);

	public List<DoctorEntity> getAllDoctor();

	public String deleteRecord(long id);

	public Boolean updateDoctorRecord(Long id, DoctorSingUp form);
	
	public DoctorEntity findByEmailAndPwd(String email, String pwd);

	public DoctorEntity getdoctorByEmail(String email);
	public DoctorEntity updateDoctorRecord(long id, DoctorEntity doctorsingh);
	 
	 List<DoctorEntity> findDoctorsByName(String doctorName);
	

	 
	 List<DoctorEntity> findDoctorsByLocation(String location);
}
