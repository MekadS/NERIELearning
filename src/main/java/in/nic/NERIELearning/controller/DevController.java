package in.nic.NERIELearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.model.TLoSa;
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
		
		return "dev/dashboardSidebar2"; 
	}
	
	@GetMapping("/subjectListByClass")
	@ResponseBody
	public ResponseEntity<List<MapClassSubject>> getSubjectList(@RequestParam("classId") MClass classId) {
		try {
			List<MapClassSubject> mapClassSubjectList = mapClassSubjectService.getSubjectsByClass(classId);
			return new ResponseEntity<>(mapClassSubjectList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error fetching classes by subjectId: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/losaByMapCSToo")
	@ResponseBody
	public ResponseEntity<List<TLoSa>> getLoSaListByMapCS(@RequestParam("selectedClassId") Long classId, @RequestParam("selectedSubjectId") Long subjectId) {
		System.out.println("In meh: losaByMapCS");
		try {
			List<TLoSa> loSaList = tLoSaService.getLoSaByClassSubject(classId, subjectId);
			System.out.println("Class: " + classId);
			System.out.println("Subject: " + subjectId);
			System.out.println("LoSas for Class-Subject: " + loSaList);
			return new ResponseEntity<>(loSaList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error fetching classes by subjectId: " + e.getMessage());
			
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//	END: PUBLIC Mappings
}