package in.petex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.petex.entity.BreedingEntity;

public interface BreedingRespository extends JpaRepository<BreedingEntity, Long> {

}
