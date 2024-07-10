package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.model.TLoSa;

@Repository
public interface TLoSaRepo extends JpaRepository<TLoSa, Long> {
//	List<TLoSa> findBymapClassSubjectId(MapClassSubject map_class_subject_id);
}