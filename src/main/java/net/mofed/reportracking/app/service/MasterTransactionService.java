package net.mofed.reportracking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.repository.MasterTransactionRepository;

@Service
public class MasterTransactionService {
	
	@Autowired
	private MasterTransactionRepository  masterTransactionRepository;
	
	
	public List<MasterTransaction> getMasterTransaction(String keyword)
	{
		 if (keyword != null) {
			return masterTransactionRepository.findByDirectorate(keyword);
		}
		else
		return masterTransactionRepository.findAll();
	}
		
	public List <MasterTransaction> getOrgTrans(Long  id){
		return masterTransactionRepository.findTransactionByOrg(id);
	}
	
	public List<MasterTransaction>getExpertTransaction(Long assigned_expert_id){
		return masterTransactionRepository.findTransactionByExpert(assigned_expert_id);
	}
	
	
	public List<MasterTransaction> getAllOrgTransaction(String organizaid){
		return masterTransactionRepository.findAllTransactionByOrg(organizaid);
	}
	
	
	
	
	
	public Optional <MasterTransaction> findById(Integer id){
			    return  masterTransactionRepository.findById(id);
		}
	
	public void delete(Integer id) {
		masterTransactionRepository.deleteById(id);
	}
	
	 public Optional<MasterTransaction> getFile(Integer fileId) {
		  return masterTransactionRepository.findById(fileId);
	  }

	public void save(MasterTransaction trans) {
		// TODO Auto-generated method stub
		masterTransactionRepository.save(trans);
	}
	
	
	public void updateReportStatusWithCustomQuery(Integer id ,String reportstatus) {
		masterTransactionRepository.updateReportStatus(id, reportstatus);
	}
	
	public MasterTransaction get(Integer id) {
		return masterTransactionRepository.findById(id).get();
	}
	
	

}

