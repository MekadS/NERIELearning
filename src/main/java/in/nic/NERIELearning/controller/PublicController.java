package in.nic.NERIELearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.nic.NERIELearning.model.TCompetency;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import in.nic.NERIELearning.service.TCompetencyService;
import in.nic.NERIELearning.service.TGoalService;

@Controller
public class PublicController{
	@Autowired
	MStageService mStageService;
	@Autowired
	MClassService mClassService;
	@Autowired
	MSubjectService mSubjectService;
	@Autowired
	MapClassSubjectService mapClassSubjectService;
	@Autowired
	TGoalService tGoalService;
	@Autowired
	TCompetencyService tCompetencyService;

	@GetMapping("/public/viewLearningOutcomes")
	public String viewLearningOutcomes(Model mClass) {
		List<TCompetency> listCompetency = tCompetencyService.findAll();
		mClass.addAttribute("listCompetency", listCompetency);
		System.out.println("••• Getting Stages List •••");    
		System.out.println(listCompetency);    
		return "public/viewLearningOutcomes";
	}
	//	END: ViewFullLoSas
	//	END: HEAD-TEACHER MapClassSubject Methods
}