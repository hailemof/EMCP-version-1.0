package net.mofed.reportracking.app.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import net.mofed.reportracking.app.model.Document;
import net.mofed.reportracking.app.model.FileUploadResponse;
import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.repository.MasterTransactionRepository;
import net.mofed.reportracking.app.repository.UserRepository;
import net.mofed.reportracking.app.service.DocumentService;
import net.mofed.reportracking.app.service.FileStorageService;
//import net.mofed.reportracking.app.service.FileStorageService;
import net.mofed.reportracking.app.service.MasterTransactionService;
import net.mofed.reportracking.app.service.OrganizationService;
import net.mofed.reportracking.app.service.UserService;

@Controller

public class MasterTransactionController {
	@Autowired
	private FileStorageService fileStorageService;

	Path copyLocation;
	
	 
	@Autowired
	private MasterTransactionService masterTransactionService;
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserRepository  urepo;
	
	
	
	@Autowired
	private UserService myuserservice;
		
	@GetMapping("/mastertransactionlists")
	
	public String  showTransaction(Model  model,String keyword) {
		keyword ="";
	List<MasterTransaction> transactionlist =  masterTransactionService.getMasterTransaction(keyword);
	
		model.addAttribute("mastertransactionlists", transactionlist);
		
		List<Document> doclist = documentService.getDocuments();
		model.addAttribute("documents",doclist);
		
		
		Iterable<User> userlist = myuserservice.getAllUsers();
		
		
        model.addAttribute("userlist",userlist);
				
		return  "mastertransactionlist";		
	}
	
	@RequestMapping("mastertransactionlists/findById")
	@ResponseBody
	public Optional<MasterTransaction> findBy(Integer id) {
	 return masterTransactionService.findById(id);
 }
 
 @RequestMapping(value="/mastertransactionlists/update", method= {RequestMethod.PUT, RequestMethod.GET})
 public String update(MasterTransaction  mastertransaction) {
	 	 	 masterTransactionService.save(mastertransaction);
	 return "redirect:/mastertransactionlists";
  }
 
 	@PostMapping("/uploadFiles")
	public String uploadMultipleFiles(@RequestParam("files") MultipartFile files,
			@RequestParam("transactiondocumentid") String transactiondocumentid,
			@RequestParam("reportstatus") String reportstatus,ModelMap modelMap,
			@RequestParam("organizaid") String organizaid,
			@RequestParam("remarks") String remarks,
			@RequestParam("assigned_expert_user_id") String assigned_expert_user_id,
			Principal principal,MasterTransaction mastu,
			RedirectAttributes ra) throws IOException {
		     String name= principal.getName();
		 
		   net.mofed.reportracking.app.model.User user= this.urepo.getUserByUsername(name);
		   String organizaid1 = user.getOrg_id();
		//   mastu.setOrganizaid(organizaid1)= user.;
		   	   
	     mastu.setUser(user);
	    mastu.setOrganizaid(organizaid1);
	    mastu.setRemarks(remarks);
		mastu.setTransactiondocumentid(transactiondocumentid);
		mastu.setReportstatus(reportstatus);
		mastu.setAssigned_expert_user_id(Long.valueOf(assigned_expert_user_id));
		mastu.setDocname(files.getOriginalFilename());
		singleFileUpload(files).getUrl();
		
		masterTransactionService.save(mastu);
		
				
		return "redirect:/uploadstatus";
	
	}
	
	
	FileUploadResponse singleFileUpload(@RequestParam("file") MultipartFile file){
		User userr = new User();
		String docname = fileStorageService.storeFile(file);
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download")
				.path(docname)
				.toString();
		String contentType = file.getContentType();
		FileUploadResponse response = new FileUploadResponse(docname,contentType,url);
		return response;
	}
	
	@RequestMapping("/download")
	public ResponseEntity<Resource>  download(@RequestParam("id") Integer id, HttpServletResponse response) throws MalformedURLException{
		MasterTransaction trans = masterTransactionService.findById(id).get();
			Resource resource=null;
		try {
			resource = fileStorageService.downloadFile(trans.getDocname());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MediaType contentType = MediaType.APPLICATION_OCTET_STREAM;
		
		return ResponseEntity.ok()
				.contentType(contentType)
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachement;filename="+resource.getFilename())
				.body(resource);
			}	
		@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("edit_transaction");
		
		MasterTransaction transact = masterTransactionService.get(id);
		mav.addObject("transact",transact);
		return mav;
	}	
	
}
