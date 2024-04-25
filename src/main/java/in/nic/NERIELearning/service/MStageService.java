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
     
    public void save(MStage stage) {
        mStageRepo.save(stage);
    }
     
    public MStage get(long id) {
        return mStageRepo.findById(id).get();
    }
     
    public void delete(long id) {
        mStageRepo.deleteById(id);
    }
}