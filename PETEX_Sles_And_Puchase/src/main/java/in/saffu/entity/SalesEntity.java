package in.saffu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SALES-TAB")
public class SalesEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petId;
	private String petType;
	private String petname;
	private String gender;
	private Double weight;
    private Double height;
    private String color;
	private String email;
	private Long phno;
	private String address;
	public Integer getPetId() {
		return petId;
	}
	public void setPetId(Integer petId) {
		this.petId = petId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public SalesEntity(Integer petId, String petType, String petname, String gender, Double weight, Double height,
			String color, String email, Long phno, String address) {
		super();
		this.petId = petId;
		this.petType = petType;
		this.petname = petname;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.color = color;
		this.email = email;
		this.phno = phno;
		this.address = address;
	}
	public SalesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
