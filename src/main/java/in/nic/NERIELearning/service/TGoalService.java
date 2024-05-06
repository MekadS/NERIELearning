package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.TGoal;
import in.nic.NERIELearning.repo.TGoalRepo;

@Service
public class TGoalService {
	@Autowired
	private TGoalRepo tGoalRepo;
	
	public List<TGoal> findAll(){
		return tGoalRepo.findAll();
	}
	
	public void save(TGoal tGoal) {
		tGoalRepo.save(tGoal);
	}
	
	public TGoal get(Long t_goal_id) {
		return tGoalRepo.findById(t_goal_id).get();
	}
}