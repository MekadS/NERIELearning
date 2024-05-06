package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TGoal;

@Repository
public interface TGoalRepo extends JpaRepository<TGoal, Long> {
}