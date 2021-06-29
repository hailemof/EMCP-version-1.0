package net.mofed.reportracking.app.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.mofed.reportracking.app.exception.CustomeFieldValidationException;
import net.mofed.reportracking.app.exception.UsernameOrIdNotFound;
import net.mofed.reportracking.app.model.Directorate;
import net.mofed.reportracking.app.model.Organization;
import net.mofed.reportracking.app.model.Role;
import net.mofed.reportracking.app.model.User;
import net.mofed.reportracking.app.repository.RoleRepository;
import net.mofed.reportracking.app.service.OrganizationService;
import net.mofed.reportracking.app.service.UserService;
import net.mofed.reportracking.app.service.UserServiceImpl;
import net.mofed.reportracking.app.util.ChangePasswordForm;
import net.mofed.reportracking.app.validation.UserValidator;



@Controller

public class UserRegisterController {


	@Autowired
	UserService userService;
	
	@Autowired
	UserServiceImpl uservice;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private OrganizationService orgservice;
	@Autowired
	private net.mofed.reportracking.app.service.DirectorateService dirservice;
	
	 @Autowired
	private UserValidator userValidator;
	
	@GetMapping({"/login"})
	public String login(Model model,String error, String logout) {
		model.addAttribute("userForm", new User());
		if (error != null)
            model.addAttribute("error", "Your username or password is invalid.");
		 if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
		 
		return "login";
	}
	//for login form validation
	 @RequestMapping(value= "/login", method= RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("userForm") User user, BindingResult result) {
	        if (result.hasErrors()) {
	            return "redirect:/login";
	        }
	 
	        return "login";
	    }
	@GetMapping("/userlist")
	public String userList(Model model,User user) {
		
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new User());
		model.addAttribute("roles",roles);
		
		//for user role and organization list
		model.addAttribute("userForm", user);
		model.addAttribute("userlist", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		
		//to display list if Organization
		List<Organization> orglist = orgservice.getOrganizations();
		model.addAttribute("organizations",orglist);
		
		//to display list of directorate
		List<Directorate> dirList=dirservice.GetAllDirectorates();
		model.addAttribute("directorates",dirList);
		
		return "user-register";
	}
	
	

	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("user")User user, BindingResult result, ModelMap model) {
		userValidator.validate(user, result);
		
		
		Role userRole = roleRepository.findByName("USER");
		List<Role> roles = Arrays.asList(userRole);
		model.addAttribute("user", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
            
			//to display list of Organization in the validation user
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate in the validation user
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
			
			//to get list of roles in the validation user
			Iterable<Role> role = roleRepository.findAll();
			model.addAttribute("roles",role);
			
			
			return "validation-error";
		}else {
			try {
				userService.createUser(user);
				model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + 
						" registered successfully");
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
               
			}catch (Exception e) {
				model.addAttribute("errors",e.getMessage());
				
			}
		}
		return "user-register-success";
	}
	
	  /**
     * This method will provide the medium to update an existing user.
	 * @throws Exception 
     */
	  @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.GET)
	    public String editUser(@PathVariable Long id, ModelMap model) throws Exception {
	        User user = userService.getUserById(id);
	        model.addAttribute("user", user);
	        model.addAttribute("edit", true);
	        return "emcp/user-register";
	    }
    /**
     * This method will be called on form submission, handling POST request for
     * updating user in database. It also validates the user input
     * @throws Exception 
     */
    @RequestMapping(value = { "/edit-user-{id}" }, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String ssoId) throws Exception {
 
        if (result.hasErrors()) {
            return "user-register";
        }

       
			userService.updateUser(user);
	
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        return "emcp/user-register";
    }
     
    /**
     * This method will delete an user by it's ID value.
     * @throws UsernameOrIdNotFound 
     */
	
    @RequestMapping(value = { "/delete-user-{id}" }, method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) throws UsernameOrIdNotFound {
        userService.deleteUser(id);
        return "redirect:/userlist";
    }
    @GetMapping("/change-password")
	public String chnangePassword() {
		return "changepassword";
	}
    
    
    
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid  ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}

	
	    //user profile handler
		@GetMapping("/profile")
		public String yourProfile(Model model,Principal principal) {
			String un = principal.getName();
			model.addAttribute("user",userService.getUserByUsername(un) );
			System.out.println(un);
			
			return "profile";
			
		}
		
		@GetMapping("/auditexperts")
		public String getAuditExperts(Model model,String user_dir_name,String org_id) {
			user_dir_name ="Audit";
			org_id ="MOF-01";
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
		 List <User> auditusers= uservice.getExpertByDirectorate(user_dir_name, org_id);
		 model.addAttribute("auditexperts", auditusers);
		 
			return "auditexpertfiltered";
		}
		
		
		@GetMapping("/budgetexperts")
		public String getbudgetExperts(Model model,String user_dir_name,String org_id) {
			user_dir_name ="Budget";
			org_id ="MOF-01";
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
		 List <User> budgetusers= uservice.getExpertByDirectorate(user_dir_name, org_id);
		 model.addAttribute("budgetexperts", budgetusers);
		 
			return "budgetexpertfiltered";
		}
		
		@GetMapping("/cashexperts")
		public String getCashExperts(Model model,String user_dir_name,String org_id) {
			user_dir_name ="Cash";
			org_id ="MOF-01";
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
		 List <User> cashusers= uservice.getExpertByDirectorate(user_dir_name, org_id);
		 model.addAttribute("cashexperts", cashusers);
		 
			return "cashexpertfiltered";
		}
	
		@GetMapping("/purchaseexperts")
		public String getPurchaseExperts(Model model,String user_dir_name,String org_id) {
			user_dir_name ="Purchase";
			org_id ="MOF-01";
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
		 List <User> purchaseusers= uservice.getExpertByDirectorate(user_dir_name, org_id);
		 model.addAttribute("purchaseexperts", purchaseusers);
		 
			return "purhcaseexpertfiltered";
		}
		
		@GetMapping("/accountexperts")
		public String getAccountExperts(Model model,String user_dir_name,String org_id) {
			user_dir_name ="Account";
			org_id ="MOF-01";
			List<Organization> orglist = orgservice.getOrganizations();
			model.addAttribute("organizations",orglist);
			
			//to display list of directorate
			List<Directorate> dirList=dirservice.GetAllDirectorates();
			model.addAttribute("directorates",dirList);
		 List <User> accountusers= uservice.getExpertByDirectorate(user_dir_name, org_id);
		 model.addAttribute("accountexperts", accountusers);
		 
			return "accountexpertfiltered";
		}
		
}