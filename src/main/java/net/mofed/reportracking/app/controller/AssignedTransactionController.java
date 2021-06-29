package net.mofed.reportracking.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.repository.MasterTransactionRepository;
import net.mofed.reportracking.app.repository.UserRepository;
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.MasterTransactionService;
import net.mofed.reportracking.app.service.UserService;

@Controller

public class AssignedTransactionController {
	 
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
	
		    @GetMapping("/assignedtransactionlists")
			public String  showTransactionbyUsername(Model  model,Principal principal)
		{
		 			String name= principal.getName();
			User user2= this.userRepo.getUserByUsername(name);
			
			List<MasterTransaction> assignedtransactionlist = this.masterTransactionService.getExpertTransaction(user2.getId());
				model.addAttribute("mastertransactionlists", assignedtransactionlist);
		
		    List<Document> doclist = documentService.getDocuments();
		    model.addAttribute("documents",doclist);
		    
		    Iterable<User> userlist = myuserservice.getAllUsers();
			
			
	        model.addAttribute("userlist",userlist);
		    
			return  "experttransaction";		
			
	         }
				
		    
		    
		    @RequestMapping(value="/assignedtransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
			 public String update(MasterTransaction  mastertransaction) {
				 	 	 masterTransactionService.save(mastertransaction);
				 return "redirect:/assignedtransactionlists";
			  }
					
		} 
		
		


		
	
	

