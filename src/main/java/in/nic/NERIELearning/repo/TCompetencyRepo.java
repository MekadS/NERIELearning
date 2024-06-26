package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TCompetency;

@Repository
public interface TCompetencyRepo extends JpaRepository<TCompetency, Long> {
	List<TCompetency> findBytGoalId_tGoalId(Long tGoalCode);
}