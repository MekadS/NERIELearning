package in.nic.NERIELearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.nic.NERIELearning.model.Userlogin;

@Controller
public class CommonController{
	
	@GetMapping("/")
	public String home() {
		return "home"; 
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied"; 
	}

	@GetMapping("/index")
	public String loginIndex(Model model) {
		model.addAttribute("userLogin",new Userlogin());
		return "index"; 
	}
	
	@GetMapping("/editor/dashboard")
	public String editorDashboard() {
		return "editor/dashboard"; 
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