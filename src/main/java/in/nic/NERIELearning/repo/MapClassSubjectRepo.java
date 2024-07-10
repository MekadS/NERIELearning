package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MapClassSubject;

@Repository
public interface MapClassSubjectRepo extends JpaRepository<MapClassSubject, Long> {

	List<MapClassSubject> findBymClassId(MClass class_id);
//	List<MapClassSubject> findBymClassIdAndMsubjectid(MClass m_class_id, MSubject m_subject_id);
}