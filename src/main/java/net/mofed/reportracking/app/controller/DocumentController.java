package net.mofed.reportracking.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.mofed.reportracking.app.model.Directorate;
import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.service.DirectorateService;
import net.mofed.reportracking.app.service.DocumentService;

@Controller
public class DocumentController {
	
	@Autowired
	private DocumentService documentservice;
	@Autowired
	private DirectorateService directorateService;
	
	@GetMapping("/documents")
	public String getDocuments(Model model) {	
		
		List<Document> documentList = documentservice.getDocuments();	
		model.addAttribute("documents", documentList);	
		
		List<Directorate> directorateList = directorateService.GetAllDirectorates();
		model.addAttribute("directorates",directorateList);
		
		return "document";
	}
	
	@PostMapping("/documents/addNew")
	public String addNew(Document document) {
		documentservice.save(document);
		return "redirect:/documents";
	}
	
	
	@RequestMapping("documents/findById")
	@ResponseBody
	public Optional<Document> findById(String id) {
	  return documentservice.findBy(id)	;
	}	
	
	@RequestMapping(value="/documents/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Document document) {
		documentservice.save(document);
		return "redirect:/documents";
	}
	
	@RequestMapping(value="/documents/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(String id) {
		documentservice.delete(id);
		return "redirect:/documents";
	}
	@GetMapping("/toaudit")
	public String ShowToAuditForm(Model model ,String directorname){
		
		directorname="Audit";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("auditdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToAuditDirectorateReport";
	}
	
	
	@GetMapping("/tobudget")
	public String ShowTobudgetForm(Model model ,String directorname){
		
		directorname="Budget";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("budgetdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToBudgetDirectorateReport";
	}
	
	@GetMapping("/tocash")
	public String ShowToCashForm(Model model ,String directorname){
		
		directorname="Cash";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("cashdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToCashDirectorateReport";
	}
	@GetMapping("/toproperty")
	public String ShowToPropertyForm(Model model ,String directorname){
		
		directorname="Property";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("propdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToPropertyDirectorateReport";
	}
	
	
	@GetMapping("/topurchase")
	public String ShowToPurchaseForm(Model model ,String directorname){
		
		directorname="Purchase";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("purdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToPurchaseDirectorateReport";
	}
	
	@GetMapping("/toaccount")
	public String ShowAccountancyForm(Model model ,String directorname){
		
		directorname="Account";
		List<Document> doclist = documentservice.getDirectorDoc(directorname);
		 model.addAttribute("acdocs", doclist);
		 
		 List<Directorate> directorateList = directorateService.GetAllDirectorates();
			model.addAttribute("directorates",directorateList);
			
		return "ToAccountDirectorateReport";
	}
	
}
