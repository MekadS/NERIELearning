package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.TCompetency;
import in.nic.NERIELearning.repo.TCompetencyRepo;

@Service
public class TCompetencyService {
	@Autowired
	private TCompetencyRepo tCompetencyRepo;
	
	public List<TCompetency> findAll(){
		return tCompetencyRepo.findAll();
	}
	
	public void save(TCompetency tCompetency) {
		tCompetencyRepo.save(tCompetency);
	}
	
	public TCompetency get(Long t_competency_id) {
		return tCompetencyRepo.findById(t_competency_id).get();
	}
}