package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.Userlogin;
import in.nic.NERIELearning.repo.UserLoginRepo;

@Service
public class UserLoginService{

	@Autowired
	private UserLoginRepo mUserloginRepo;
	
	public List<Userlogin> findAll() {
		return mUserloginRepo.findAll();
	}
	
	public void save(Userlogin mUserlogin) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("PT: " + mUserlogin.getPassword());
		mUserlogin.setPassword(passwordEncoder.encode(mUserlogin.getPassword()));
		System.out.println("CT: " + mUserlogin.getPassword());

		mUserloginRepo.save(mUserlogin);
	}
	
	public Userlogin get(Long m_stage_id) {
		return mUserloginRepo.findById(m_stage_id).get();
	}

	public Userlogin getUserLoginByUserName (String username) {
		return mUserloginRepo.findByUsername(username).get();
	}

	public List<Userlogin> getUserLoginByIsActiveTrue () {
		return mUserloginRepo.findByIsActive(true);
	}
}
