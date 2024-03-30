package in.TrainingForm.entity;

	import com.fasterxml.jackson.annotation.JsonIgnore;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
	@Entity
	@Table(name = "TrainerForm")
	public class BookNowEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long bookId;
		private String customerName;
		private String customerEmail;
		private String customerPhno;
		private String breedName;
		private String date;
		private String time;
		private String description;
	

		@ManyToOne
		@JoinColumn(name = "userId")
		@JsonIgnore
		private UserEntity user;


		public Long getBookId() {
			return bookId;
		}


		public void setBookId(Long bookId) {
			this.bookId = bookId;
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


		public UserEntity getUser() {
			return user;
		}


		public void setUser(UserEntity user) {
			this.user = user;
		}


		public BookNowEntity() {
			super();
			// TODO Auto-generated constructor stub
		}


		public BookNowEntity(Long bookId, String customerName, String customerEmail, String customerPhno,
				String breedName, String date, String time, String description, UserEntity user) {
			super();
			this.bookId = bookId;
			this.customerName = customerName;
			this.customerEmail = customerEmail;
			this.customerPhno = customerPhno;
			this.breedName = breedName;
			this.date = date;
			this.time = time;
			this.description = description;
			this.user = user;
		}

		
		
	

}
