package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import in.nic.NERIELearning.model.MCompetency;
import in.nic.NERIELearning.repo.MCompetencyRepo;

public class MCompetencyService {
	@Autowired
	private MCompetencyRepo mCompetencyRepo;
	
	public List<MCompetency> findAll(){
		return mCompetencyRepo.findAll();
	}
	
	public void save(MCompetency mCompetency) {
		mCompetencyRepo.save(mCompetency);
	}
	
	public MCompetency get(Long m_competency_id) {
		return mCompetencyRepo.findById(m_competency_id).get();
	}
}