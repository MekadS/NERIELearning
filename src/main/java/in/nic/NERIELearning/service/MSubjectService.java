package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MSubject;
import in.nic.NERIELearning.repo.MSubjectRepo;

@Service
public class MSubjectService {
    @Autowired
    private MSubjectRepo mSubjectRepo;
    
    public List<MSubject> findAll() {
        return mSubjectRepo.findAll();
    }
     
    public void save(MSubject mSubject) {
        mSubjectRepo.save(mSubject);
    }
     
    public MSubject get(Long m_subject_id) {
        return mSubjectRepo.findById(m_subject_id).get();
    }

	public List<MSubject> getMSubjectByIsActiveTrue () {
		return mSubjectRepo.findByIsActive(true);
	}
}