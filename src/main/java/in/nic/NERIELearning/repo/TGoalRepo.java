package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TGoal;

@Repository
public interface TGoalRepo extends JpaRepository<TGoal, Long> {

	List<TGoal> findBymapClassSubjectId_mapClassSubjectId(Long mapCScode);
}