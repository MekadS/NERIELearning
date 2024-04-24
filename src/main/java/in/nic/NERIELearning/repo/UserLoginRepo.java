package in.nic.NERIELearning.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nic.NERIELearning.model.Userlogin;

public interface UserLoginRepo extends JpaRepository<Userlogin, Long> {

	Optional<Userlogin> findByUsername(String username);
}
