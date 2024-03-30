package com.booking.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

	@Entity
	 @Table(name = "USER_TABLE")
	public class UserEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long userId;
		private String petType;
		private String petname;
		private String species;
		private Integer age;
		private String gender;
		private Double weight;
		private Double height;
		private String color;
		private String disease;
		private String vaccinated;
		private String fullname;
		private String email;
		private String pwd;
		private String confirmPwd;
		private Long phno;
		private String city;
		private String otp;

		@OneToMany(cascade = CascadeType.ALL, mappedBy ="user")
		private List<DayCareBooking> book;

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getPetType() {
			return petType;
		}

		public void setPetType(String petType) {
			this.petType = petType;
		}

		public String getPetname() {
			return petname;
		}

		public void setPetname(String petname) {
			this.petname = petname;
		}

		public String getSpecies() {
			return species;
		}

		public void setSpecies(String species) {
			this.species = species;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Double getWeight() {
			return weight;
		}

		public void setWeight(Double weight) {
			this.weight = weight;
		}

		public Double getHeight() {
			return height;
		}

		public void setHeight(Double height) {
			this.height = height;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getDisease() {
			return disease;
		}

		public void setDisease(String disease) {
			this.disease = disease;
		}

		public String getVaccinated() {
			return vaccinated;
		}

		public void setVaccinated(String vaccinated) {
			this.vaccinated = vaccinated;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPwd() {
			return pwd;
		}

		public void setPwd(String pwd) {
			this.pwd = pwd;
		}

		public String getConfirmPwd() {
			return confirmPwd;
		}

		public void setConfirmPwd(String confirmPwd) {
			this.confirmPwd = confirmPwd;
		}

		public Long getPhno() {
			return phno;
		}

		public void setPhno(Long phno) {
			this.phno = phno;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		public List<DayCareBooking> getBook() {
			return book;
		}

		public void setBook(List<DayCareBooking> book) {
			this.book = book;
		}
		
		
}
