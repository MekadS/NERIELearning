package in.nic.NERIELearning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevController{
	@GetMapping("/dev/devIndex")
	public String DevIndex() {
		return "dev/devIndex"; 
	}

	@GetMapping("/dev/dashboardSidebar")
	public String editorDashboardSidebar() {
		return "dev/dashboardSidebar"; 
	}
//	END: PUBLIC Mappings
}