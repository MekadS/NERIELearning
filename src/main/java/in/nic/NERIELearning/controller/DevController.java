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
	
	@GetMapping("/dev/devIndex")
	public String DevIndex() {
		return "dev/devIndex"; 
	}

	@GetMapping("/dev/dashboardSidebar")
	public String editorDashboardSidebar(Model model) {
		model.addAttribute("countUsers", userLoginService.getUserLoginByIsActiveTrue().size());
		model.addAttribute("countRoles", mRoleService.getMRoleByIsActiveTrue().size());
		model.addAttribute("countStages", mStageService.getMStageByIsActiveTrue().size());
		model.addAttribute("countClasses", mClassService.getMClassByIsActiveTrue().size());
		model.addAttribute("countSubjects", mSubjectService.getMSubjectByIsActiveTrue().size());
		model.addAttribute("countContent", mContentService.getMContentByIsActiveTrue().size());
		return "dev/dashboardSidebar"; 
	}
//	END: PUBLIC Mappings
}