package in.Training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Training.entity.UserEntity;

public interface UserRepo   extends JpaRepository<UserEntity, Long>{

	}


