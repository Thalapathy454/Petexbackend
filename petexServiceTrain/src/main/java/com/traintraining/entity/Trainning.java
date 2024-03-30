package com.traintraining.entity;



	import jakarta.persistence.*;
	@Entity
	public class Trainning {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    private double serviceCost;
		    private String serviceType;
		    private String location;
		    
			public Trainning() {
				super();
			}

			public Trainning(Long id, double serviceCost, String serviceType, String location) {
				super();
				this.id = id;
				this.serviceCost = serviceCost;
				this.serviceType = serviceType;
				this.location = location;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}


			public double getServiceCost() {
				return serviceCost;
			}

			public void setServiceCost(double serviceCost) {
				this.serviceCost = serviceCost;
			}

			public String getServiceType() {
				return serviceType;
			}

			public void setServiceType(String serviceType) {
				this.serviceType = serviceType;
			}

			public String getLocation() {
				return location;
			}

			public void setLocation(String location) {
				this.location = location;
			}

			
		

		}



