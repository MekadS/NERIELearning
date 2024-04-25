package in.nic.NERIELearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController{
	@GetMapping("/")
	public String index() {
		return "index"; 
	}
	
	@GetMapping("/admin")
	public String adminIndex() {
		return "admin/adminIndex"; 
	}

	@GetMapping("/testPage")
	public String testPage() {
		return "/testPage"; 
	}
	
//	START: PUBLIC Mappings
	@GetMapping("/public/schoolEducation")
	public String schoolEducation() {
		return "public/schoolEducation"; 
	}

	@GetMapping("/public/NAS")
	public String NAS() {
		return "public/NAS"; 
	}

	@GetMapping("/public/contact")
	public String contact() {
		return "public/contact"; 
	}
//	END: PUBLIC Mappings
}