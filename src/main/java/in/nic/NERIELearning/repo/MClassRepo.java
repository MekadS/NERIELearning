package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MClass;

@Repository
public interface MClassRepo extends JpaRepository<MClass, Long> {
	List<MClass> findByIsActive(boolean isActive);

}