package net.mofed.reportracking.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadStatusController {
	
	
	@GetMapping("/uploadstatus")
	
	public String uploadstatus() {
		
		return "uploadstatus";
	}
	
	
	
}
