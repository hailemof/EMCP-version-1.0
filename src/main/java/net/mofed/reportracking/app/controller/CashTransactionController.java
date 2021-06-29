package net.mofed.reportracking.app.controller;

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
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.MasterTransactionService;
import net.mofed.reportracking.app.service.UserService;
import net.mofed.reportracking.app.service.UserServiceImpl;

@Controller

public class CashTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService myuserservice;
	
	@Autowired
	private UserServiceImpl  uservice;
	
		@GetMapping("/cashtransactionlists")
		public String  showTransaction(Model  model,String keyword,String user_dir_name,String org_id) {
		keyword ="cash";
		user_dir_name="Cash";
		org_id ="MOF-01";
	   List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		Iterable<User> userlist = uservice.getExpertByDirectorate(user_dir_name, org_id);
		
        model.addAttribute("cashexperts",userlist);
		return  "cashtransactionlist";		
	}
		@RequestMapping(value="/cashtransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
		 public String update(MasterTransaction  mastertransaction) {
			 	 	 masterTransactionService.save(mastertransaction);
			 return "redirect:/cashtransactionlists";
		  }
		
	
	
	
}
