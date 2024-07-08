package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.repo.MapClassSubjectRepo;

@Service
public class MapClassSubjectService {
    @Autowired
    private MapClassSubjectRepo mapClassSubjectRepo;

    public List<MapClassSubject> findAll() {
        return mapClassSubjectRepo.findAll();
    }
     
    public void save(MapClassSubject mapClassSubject) {
        mapClassSubjectRepo.save(mapClassSubject);
    }
     
    public MapClassSubject get(Long map_class_subject_id) {
        return mapClassSubjectRepo.findById(map_class_subject_id).get();
    }
    
    public List<MapClassSubject> getSubjectsByClass(MClass class_id){
    	return mapClassSubjectRepo.findBymClassId(class_id);
    }
}