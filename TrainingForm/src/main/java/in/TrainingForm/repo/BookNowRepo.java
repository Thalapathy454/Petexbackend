package in.TrainingForm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.TrainingForm.entity.BookNowEntity;

	public interface BookNowRepo  extends JpaRepository<BookNowEntity, Long>{


}
