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
import net.mofed.reportracking.app.service.UserService;


@Controller

public class OrganizationTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private MasterTransactionRepository mrepo;
		
	
	@Autowired
	private UserService myuserservice;
	
		    @GetMapping("/orgtransactionlists")
			public String  showTransactionbyUsername(Model  model,Principal principal)
		{
		 			String name= principal.getName();
			User user= this.userRepo.getUserByUsername(name);
			
			List<MasterTransaction> orgtransactionlist = this.masterTransactionService.getOrgTrans(user.getId());
				model.addAttribute("mastertransactionlists", orgtransactionlist);
		
		    List<Document> doclist = documentService.getDocuments();
		    model.addAttribute("documents",doclist);
		    
		    
          Iterable<User> userlist = myuserservice.getAllUsers();
			
			
	        model.addAttribute("userlist",userlist);
			return  "organizationtransaction";		
			
	         }
					
					
		} 
		
		


		
	
	

