package in.nic.NERIELearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MClass;

@Repository
public interface MClassRepo extends JpaRepository<MClass, Long> {
}