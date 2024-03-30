package in.Training.entity;


	import jakarta.persistence.*;
	@Entity
	public class TrainingEntity {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    private double serviceCost;
		    private String serviceType;
		    private String location;
		    @Lob
		    @Column(columnDefinition = "LONGBLOB")
		    private byte[] image;
		    
		    
		    
			public TrainingEntity() {
				super();
			}


			public TrainingEntity(Long id, double serviceCost, String serviceType, String location, byte[] image) {
				super();
				this.id = id;
				this.serviceCost = serviceCost;
				this.serviceType = serviceType;
				this.location = location;
				this.image = image;
			}

			

			public byte[] getImage() {
				return image;
			}


			public void setImage(byte[] image) {
				this.image = image;
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
