package com.petex.binding;

public class OtpForm {

	private String email;

	private String otp;

	public OtpForm(String email, String otp) {
		super();
		this.email = email;
		this.otp = otp;
	}

	public OtpForm() {
		super();
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OtpForm [email=" + email + ", otp=" + otp + "]";
	}
	

}
