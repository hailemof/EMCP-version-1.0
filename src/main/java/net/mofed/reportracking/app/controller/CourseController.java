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
import net.mofed.reportracking.app.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	
	public String allCourse(Model model) {
		List <Course> allcourses = courseService.getAllCourse();
		model.addAttribute("courses",allcourses);
		return "course";
	}
	
	
	@PostMapping("/courses/addNew")
	
	public String addNew(Course  course) {
		courseService.save(course);
		return "redirect:/courses";
			}
	
	@RequestMapping("courses/findById")
	@ResponseBody
	public Optional<Course> findById(Integer  id){
		return courseService.findById(id);
			}
	
	@RequestMapping(value="/courses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update (Course course) {
		courseService.save(course);
		return "redirect:/courses";
	}
	
	
	@RequestMapping(value="/courses/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete (Integer id) {
		courseService.delete(id);
		return "redirect:/courses";
		}
	
	

}
