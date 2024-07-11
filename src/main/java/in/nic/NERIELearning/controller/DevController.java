package in.nic.NERIELearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MContentService;
import in.nic.NERIELearning.service.MRoleService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import in.nic.NERIELearning.service.TLoSaService;
import in.nic.NERIELearning.service.UserLoginService;

@Controller

public class DevController{
	@Autowired
	UserLoginService userLoginService;
	@Autowired
	MRoleService mRoleService;
	@Autowired
	MStageService mStageService;
	@Autowired
	MClassService mClassService;
	@Autowired
	MSubjectService mSubjectService;
	@Autowired
	MContentService mContentService;
	@Autowired
	MapClassSubjectService mapClassSubjectService;
	@Autowired
	TLoSaService tLoSaService;
	
	@GetMapping("/dev/devIndex")
	public String DevIndex() {
		return "dev/devIndex"; 
	}

	@GetMapping("/dev/dashboardSidebar")
	public String editorDashboardSidebar(Model model) {
		model.addAttribute("listClasses", mClassService.findAll());
		
		return "dev/dashboardSidebar"; 
	}
	
	@GetMapping("/dev/dashboardSidebar2")
	public String editorDashboardSidebar2(Model model) {
		model.addAttribute("listClasses", mClassService.findAll());
		model.addAttribute("listTLoSas", tLoSaService.findAll());
		
		return "dev/dashboardSidebar2"; 
	}
	//	END: DEV Mappings
}