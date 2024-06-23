package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.TLoSa;

@Repository
public interface TLoSaRepo extends JpaRepository<TLoSa, Long> {
}