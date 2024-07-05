package in.nic.NERIELearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MRole;

@Repository
public interface MRoleRepo extends JpaRepository<MRole, Long> {
	List<MRole> findByIsActive(boolean isActive);

}