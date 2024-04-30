package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MapClassSubject;

@Repository
public interface MapClassSubjectRepo extends JpaRepository<MapClassSubject, Long> {
}