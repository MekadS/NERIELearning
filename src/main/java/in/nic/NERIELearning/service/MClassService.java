package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.repo.MClassRepo;

@Service
public class MClassService {
    @Autowired
    private MClassRepo mClassRepo;
    
    public List<MClass> findAll() {
        return mClassRepo.findAll();
    }
     
    public void save(MClass mClass) {
        mClassRepo.save(mClass);
    }
     
    public MClass get(Long m_stage_id) {
        return mClassRepo.findById(m_stage_id).get();
    }

	public List<MClass> getMClassByIsActiveTrue () {
		return mClassRepo.findByIsActive(true);
	}
}