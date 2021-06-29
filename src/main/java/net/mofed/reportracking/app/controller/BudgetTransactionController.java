package net.mofed.reportracking.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.MasterTransactionService;
import net.mofed.reportracking.app.service.UserServiceImpl;

@Controller

public class BudgetTransactionController {
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private UserServiceImpl uservice;
	
	@GetMapping("/budgettransactionlists")
	
	public String  showTransaction(Model  model,String keyword,String user_dir_name,String org_id) {
		keyword ="budget";
		user_dir_name="Budget";
		org_id="MOF-01";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
Iterable<User> userlist = uservice.getExpertByDirectorate(user_dir_name, org_id);
		
        model.addAttribute("budgetexperts",userlist);
		return  "budgettransactionlist";		
	}
	
	@RequestMapping(value="/budgettransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
	 public String update(MasterTransaction  mastertransaction) {
		 	 	 masterTransactionService.save(mastertransaction);
		 return "redirect:/budgettransactionlists";
	  }
	


	
}
