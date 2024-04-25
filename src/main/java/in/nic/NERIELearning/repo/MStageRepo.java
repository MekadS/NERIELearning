package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MStage;

@Repository
public interface MStageRepo extends JpaRepository<MStage, Long> {
	
}