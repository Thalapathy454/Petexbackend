package in.TrainingForm.repo;


	import org.springframework.data.jpa.repository.JpaRepository;

import in.TrainingForm.entity.UserEntity;

	public interface UserRepo extends JpaRepository<UserEntity, Long> {

		UserEntity findByEmailAndPwd(String email, String pwd);

}
