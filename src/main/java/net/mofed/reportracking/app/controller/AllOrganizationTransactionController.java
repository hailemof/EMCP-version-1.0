package net.mofed.reportracking.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.repository.MasterTransactionRepository;
import net.mofed.reportracking.app.repository.UserRepository;
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.MasterTransactionService;

@Controller

public class AllOrganizationTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MasterTransactionRepository mrepo;
	
		    @GetMapping("/allorgtransactionlists")
			public String  showTransactionbyUsername(Model  model,Principal principal)
		{
		 			String name= principal.getName();
			User user2= this.userRepo.getUserByUsername(name);
			
			List<MasterTransaction> allorgtransactionlist = this.masterTransactionService.getAllOrgTransaction(user2.getOrg_id());
				model.addAttribute("mastertransactionlists", allorgtransactionlist);
		
		    List<Document> doclist = documentService.getDocuments();
		    model.addAttribute("documents",doclist);
			return  "allorganizationtransaction";		
			
	         }
					
					
		} 
		
		


		
	
	

