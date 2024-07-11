package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TLoSa;

@Repository
public interface TLoSaRepo extends JpaRepository<TLoSa, Long> {
  @Query("SELECT lo " +
         "FROM TLoSa lo " +
         "JOIN TCompetency c ON lo.tCompetencyId = c " +
         "JOIN TGoal g ON c.tGoalId = g " +              
         "JOIN MapClassSubject mapCS ON g.mapClassSubjectId = mapCS " +
         "JOIN MClass cl ON mapCS.mClassId = cl " +
         "JOIN MSubject s ON mapCS.mSubjectId = s " +
		  "WHERE cl.mClassId = :selectedClassId AND s.mSubjectId = :selectedSubjectId")
     List<TLoSa> findTLoSaByClassAndSubject(@Param("selectedClassId") Long selectedClassId,@Param("selectedSubjectId") Long selectedSubjectId);
}