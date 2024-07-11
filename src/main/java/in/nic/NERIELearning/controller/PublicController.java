package in.nic.NERIELearning.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MContent;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.model.TLoSa;
import in.nic.NERIELearning.service.CommonService;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MContentService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import in.nic.NERIELearning.service.TCompetencyService;
import in.nic.NERIELearning.service.TGoalService;
import in.nic.NERIELearning.service.TLoSaService;
import jakarta.servlet.http.HttpServletResponse;

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
	@Autowired
	MContentService mContentService;
	@Autowired
	TLoSaService tLoSaService;

	//	START: PUBLIC Mappings
	@GetMapping("/public/learningOutcomes")
	public String learningOutcomes() {
		return "public/learningOutcomes"; 
	}
	
	@GetMapping("/public/schoolEducation")
	public String schoolEducation() {
		return "public/schoolEducation"; 
	}

	@GetMapping("/public/test")
	public String publicTest() {
		return "public/test"; 
	}

	@GetMapping("/public/contact")
	public String contact() {
		return "public/contact"; 
	}
	
	@GetMapping("/public/about")
	public String about() {
		return "public/about"; 
	}
	
	@GetMapping("/public/viewLearningOutcomes")
	public String viewLearningOutcomes(Model model) {
		model.addAttribute("listClasses", mClassService.findAll());
		model.addAttribute("listSubjects", mapClassSubjectService.findAll());
		
		return "public/viewLearningOutcomes";
	}
	
	@GetMapping("/public/subjectListByClass")
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
	
	@GetMapping("/public/losaByMapCS")
	@ResponseBody
	public ResponseEntity<List<TLoSa>> getLoSaListByMapCS(@RequestParam("selectedClassId") Long selectedClassId, @RequestParam("selectedSubjectId") Long selectedSubjectId) {
		try {
			List<TLoSa> loSaList = tLoSaService.getLoSaByClassSubject(selectedClassId, selectedSubjectId);
			return new ResponseEntity<>(loSaList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/public/NAS")
	public String NAS(Model mContent) {
		mContent.addAttribute("listContent", mContentService.findAll());
		return "public/NAS"; 
	}

	@RequestMapping("/public/mContent/getDocument/{m_content_id}")
	public void getDocument(HttpServletResponse response, @PathVariable(name = "m_content_id") Long id) throws IOException {
		MContent mContent = mContentService.get(id);
		byte[] file = mContent.getMContentFile();
		if(file != null) {
			response.reset();
			response.setContentType(CommonService.detectMimeType(file));
			response.setContentLength(file.length);
			response.getOutputStream().write(file);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
	//	END: PUBLIC Mappings
}