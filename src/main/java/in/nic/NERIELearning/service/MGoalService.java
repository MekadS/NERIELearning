package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MGoal;
import in.nic.NERIELearning.repo.MGoalRepo;

@Service
public class MGoalService {
	@Autowired
	private MGoalRepo mGoalRepo;
	
	public List<MGoal> findAll(){
		return mGoalRepo.findAll();
	}
	
	public void save(MGoal mGoal) {
		mGoalRepo.save(mGoal);
	}
	
	public MGoal get(Long m_goal_id) {
		return mGoalRepo.findById(m_goal_id).get();
	}
}