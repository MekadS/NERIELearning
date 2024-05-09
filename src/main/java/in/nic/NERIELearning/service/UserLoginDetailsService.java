package in.nic.NERIELearning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.nic.NERIELearning.mapper.UserLoginUserDetails;
import in.nic.NERIELearning.model.Userlogin;
import in.nic.NERIELearning.repo.UserLoginRepo;

public class UserLoginDetailsService implements UserDetailsService {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Userlogin> userLogin = userLoginRepo.findByUsername(username);

		return userLogin.map(UserLoginUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));

	}
}
