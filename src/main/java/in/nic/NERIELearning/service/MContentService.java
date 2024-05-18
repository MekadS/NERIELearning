package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.MContent;
import in.nic.NERIELearning.repo.MContentRepo;

@Service
public class MContentService {
	@Autowired
	private MContentRepo mContentRepo;
	
	public List<MContent> findAll(){
		return mContentRepo.findAll();
	}
	
	public void save(MContent mContent) {
		mContentRepo.save(mContent);
	}
	
	public MContent get(Long m_content_id) {
		return mContentRepo.findById(m_content_id).get();
	}
}