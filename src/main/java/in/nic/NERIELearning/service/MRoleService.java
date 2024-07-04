package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MRole;
import in.nic.NERIELearning.repo.MRoleRepo;

@Service
public class MRoleService {
    @Autowired
    private MRoleRepo mRoleRepo;
    
    public List<MRole> findAll() {
        return mRoleRepo.findAll();
    }
     
    public void save(MRole mRole) {
        mRoleRepo.save(mRole);
    }
     
    public MRole get(Long id) {
        return mRoleRepo.findById(id).get();
    }
}