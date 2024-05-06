package in.nic.NERIELearning.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MCompetency;

@Repository
public interface MCompetencyRepo extends JpaRepository<MCompetency, Long>{
	
}