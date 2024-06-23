package in.nic.NERIELearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nic.NERIELearning.model.TLoSa;
import in.nic.NERIELearning.repo.TLoSaRepo;

@Service
public class TLoSaService {
	@Autowired
	private TLoSaRepo tLoSaRepo;
	
	public List<TLoSa> findAll(){
		return tLoSaRepo.findAll();
	}
	
	public void save(TLoSa tLoSa) {
		tLoSaRepo.save(tLoSa);
	}
	
	public TLoSa get(Long t_lo_sa_id) {
		return tLoSaRepo.findById(t_lo_sa_id).get();
	}
}