package in.nic.NERIELearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.nic.NERIELearning.helper.AuthenticationHelper;
import in.nic.NERIELearning.helper.CaptchaHelper;
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
		try {
			System.out.println("LAH TRY MEH");
			if (AuthenticationHelper.authenticated()) {
				System.out.println("AUTHENTICATED MEH");
				return "redirect:/home";
			}
			System.out.println("NOT AUTHENTICATED MEH");
			Userlogin userLogin = new Userlogin();
			model.addAttribute("loginObj", userLogin);
			CaptchaHelper.getCaptcha(userLogin);
			return "index";
		} catch (Exception e) {
			System.out.println("LAH CATCH MEH");
			return "redirect:/?error=" + e.getMessage();
		}
	}
	
//	@GetMapping("/home")
//	public String getHome(Model model) {
//		try {
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			String username = auth.getName();
//
//			Userlogin userlogin = UserLoginDetailsService.getUserByUsername(username);
//			model.addAttribute("username", username);
//			
//			return "redirect:"+userlogin.role.getLandingPage();
//		} catch (Exception e) {
//			return "redirect:/?exc=Something";
//		}
//	}
	
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
	
	@GetMapping("/public/learningOutcomes")
	public String learningOutcomes() {
		return "public/learningOutcomes"; 
	}

	@GetMapping("/public/contact")
	public String contact() {
		return "public/contact"; 
	}
//	END: PUBLIC Mappings
}