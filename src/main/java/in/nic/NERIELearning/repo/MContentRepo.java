package in.nic.NERIELearning.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nic.NERIELearning.model.MContent;

@Repository
public interface MContentRepo extends JpaRepository<MContent, Long>{
	List<MContent> findByIsActive(boolean isActive);

}