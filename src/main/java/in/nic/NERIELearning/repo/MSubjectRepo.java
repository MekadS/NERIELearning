package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MSubject;

@Repository
public interface MSubjectRepo extends JpaRepository<MSubject, Long> {
}