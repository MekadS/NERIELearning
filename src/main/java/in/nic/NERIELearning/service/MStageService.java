package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MStage;
import in.nic.NERIELearning.repo.MStageRepo;

@Service
public class MStageService {
    @Autowired
    private MStageRepo mStageRepo;
    
    public List<MStage> findAll() {
        return mStageRepo.findAll();
    }
     
    public void save(MStage mStage) {
        mStageRepo.save(mStage);
    }
     
    public MStage get(Long m_stage_id) {
        return mStageRepo.findById(m_stage_id).get();
    }

	public List<MStage> getMStageByIsActiveTrue () {
		return mStageRepo.findByIsActive(true);
	}
}