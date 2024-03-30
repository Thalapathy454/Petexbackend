package in.Training.entity;

	import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

	@Table(name = "Trainer_Booking_Table")
	@Entity
	public class BookNowEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		private String customerName;
		private String customerEmail;
		private String customerPhno;
		private String breedName;
		private String date;
		private String time;
		private String description;
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "userId")
		private UserEntity user;



		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerEmail() {
			return customerEmail;
		}

		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}

		public String getCustomerPhno() {
			return customerPhno;
		}

		public void setCustomerPhno(String customerPhno) {
			this.customerPhno = customerPhno;
		}

		public String getBreedName() {
			return breedName;
		}

		public void setBreedName(String breedName) {
			this.breedName = breedName;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}
