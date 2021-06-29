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

import net.mofed.reportracking.app.model.Course;
import net.mofed.reportracking.app.model.Organization;
import net.mofed.reportracking.app.model.Trainee;
import net.mofed.reportracking.app.service.CourseService;
import net.mofed.reportracking.app.service.OrganizationService;
import net.mofed.reportracking.app.service.TraineeService;

@Controller
public class TraineeController {

	 @Autowired
	 private TraineeService traineeService;
	 @Autowired
	 private OrganizationService organizationService;
	 
	 @Autowired
	 private CourseService courseService;
	 
	 
	 
	 @GetMapping("/trainees")
	 public String getTrainees(Model model) {
		 List<Trainee> mytrainee = traineeService.getTrainees();
		 model.addAttribute("trainees",mytrainee);
		 
		 List <Course>  mycourse = courseService.getAllCourse();
		 model.addAttribute("courses",mycourse);
		 
		 List <Organization> myorg = organizationService.getOrganizations();
		 model.addAttribute("organizations",myorg);
		 
				 return "trainee";
	 }
	 
	 
	 @PostMapping("/trainees/addNew")
	 public String  addNew (Trainee trainee) {
		 traineeService.save(trainee);
		 return "redirect:/trainees";
	   }
	 
	 @RequestMapping("trainees/findById")
		@ResponseBody
		public Optional<Trainee> findBy(Integer id) {
		 return traineeService.findById(id);
	 }
	 
	 @RequestMapping(value="/trainees/update", method= {RequestMethod.PUT, RequestMethod.GET})
	 public String update(Trainee  trainee) {
		 traineeService.save(trainee);
		 return "redirect:/trainees";
	 }
	 
	 @RequestMapping(value="/trainees/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	 public String delete(Integer id) {
		 traineeService.delete(id);
		return "redirect:/trainees";
	 }
	 
	 
	 
	 
}
