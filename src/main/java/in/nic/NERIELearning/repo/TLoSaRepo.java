package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TLoSa;

@Repository
public interface TLoSaRepo extends JpaRepository<TLoSa, Long> {
//  @Query("SELECT lo, mapCS.mClassId.mClassName, mapCS.mSubjectId.mSubjectName " +
  @Query("SELECT lo " +
         "FROM TLoSa lo " +
         "JOIN TCompetency c ON lo.tCompetencyId = c " +
         "JOIN TGoal g ON c.tGoalId = g " +              
         "JOIN MapClassSubject mapCS ON g.mapClassSubjectId = mapCS " +
         "JOIN MClass cl ON mapCS.mClassId = cl " +
         "JOIN MSubject s ON mapCS.mSubjectId = s " +
		 "WHERE cl.id = :classId AND s.id = :subjectId")
     List<TLoSa> findTLoSaByClassAndSubject(Long classId, Long subjectId);
//		  "WHERE mapCS.mClass.id = :classId AND mapCS.mSubject.id = :subjectId")
}