package in.nic.NERIELearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController{
//	START: ADMIN Mappings
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	@GetMapping("/admin/editStages")
	public String adminEditStages() {
		return "admin/editStages";
	}
//	END: ADMIN Mappings
}