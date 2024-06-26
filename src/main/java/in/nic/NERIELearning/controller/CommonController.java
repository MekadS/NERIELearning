package in.nic.NERIELearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.nic.NERIELearning.helper.AuthenticationHelper;
import in.nic.NERIELearning.helper.CaptchaHelper;
import in.nic.NERIELearning.model.Userlogin;
import in.nic.NERIELearning.service.UserLoginService;

@Controller
public class CommonController{
	@Autowired
	UserLoginService userLoginService;
	
	@GetMapping("/")
	public String homepage() {
		System.out.println("/ to Homepage");
		return "homepage"; 
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied"; 
	}

	@GetMapping("/index")
	public String loginIndex(Model model) {
		try {
			if (AuthenticationHelper.authenticated()) {
				System.out.println("AUTHENTICATED");
				return "redirect:/home";
			}
			System.out.println("NOT AUTHENTICATED");
			Userlogin userLogin = new Userlogin();
			model.addAttribute("loginObj", userLogin);
			CaptchaHelper.getCaptcha(userLogin);
			return "index";
		} catch (Exception e) {
			return "redirect:/?error=" + e.getMessage();
		}
	}
	
	@GetMapping("/home")
	public String getHome(Model model) {
		System.out.println("HOME MEH");
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();

			Userlogin userlogin = userLoginService.getUserLoginByUserName(username);
//			model.addAttribute("username", username);
			
			System.out.println("LP:" + userlogin.role.getLandingPage());
			return "redirect:"+userlogin.role.getLandingPage();
		} catch (Exception e) {
			return "redirect:/?exc=Something";
		}
	}
	
	@GetMapping("/editor/dashboard")
	public String editorDashboard() {
		return "editor/dashboard"; 
	}

	@GetMapping("/testPage")
	public String testPage() {
		return "/testPage"; 
	}
}