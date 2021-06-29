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
public class OrganizationTransactionService {
	
	@Autowired
	private MasterTransactionRepository  masterTransactionRepository;
	
	public List<MasterTransaction> getTransactionByUsrname(String uuname){
		 {
			return masterTransactionRepository.findTransactionByUsername(uuname);
		 }
		 
						
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
	
	
}

