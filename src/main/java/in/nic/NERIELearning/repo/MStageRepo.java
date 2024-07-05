package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MStage;

@Repository
public interface MStageRepo extends JpaRepository<MStage, Long> {
	List<MStage> findByIsActive(boolean isActive);
}