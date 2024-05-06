package in.nic.NERIELearning.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MGoal;

@Repository
public interface MGoalRepo extends JpaRepository<MGoal, Long>{
	
}