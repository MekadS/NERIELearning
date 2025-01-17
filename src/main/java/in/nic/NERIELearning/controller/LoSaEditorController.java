package in.nic.NERIELearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MSubject;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.model.TCompetency;
import in.nic.NERIELearning.model.TGoal;
import in.nic.NERIELearning.model.TLoSa;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MCompetencyService;
import in.nic.NERIELearning.service.MGoalService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import in.nic.NERIELearning.service.TCompetencyService;
import in.nic.NERIELearning.service.TGoalService;
import in.nic.NERIELearning.service.TLoSaService;

@Controller
public class LoSaEditorController{
	@Autowired
	MStageService mStageService;
	@Autowired
	MClassService mClassService;
	@Autowired
	MSubjectService mSubjectService;
	@Autowired
	MapClassSubjectService mapClassSubjectService;
	@Autowired
	MGoalService mGoalService;
	@Autowired
	TGoalService tGoalService;
	@Autowired
	MCompetencyService mCompetencyService;
	@Autowired
	TCompetencyService tCompetencyService;
	@Autowired
	TLoSaService tLoSaService;
	

	@GetMapping("/editor/dashboard")
	public String editorDashboard(Model model) {
		model.addAttribute("countStages", mStageService.getMStageByIsActiveTrue().size());
		model.addAttribute("countClasses", mClassService.getMClassByIsActiveTrue().size());
		model.addAttribute("countSubjects", mSubjectService.getMSubjectByIsActiveTrue().size());
		model.addAttribute("countGoals", tGoalService.findAll().size());
		model.addAttribute("countCompetencies", tCompetencyService.findAll().size());
		model.addAttribute("countLoSas", tLoSaService.findAll().size());
		return "editor/dashboard"; 
	}
	
	//	START: HEAD-TEACHER MapClassSubject Methods
	@GetMapping("/editor/headTeacher/editMapClassSubjects")
	public String headTeacherEditClassSubjects(Model model) {
		model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
		model.addAttribute("listMClasses", mClassService.findAll());
		model.addAttribute("listMSubjects", mSubjectService.findAll());
		model.addAttribute("mapClassSubject", new MapClassSubject());

		return "editor/headTeacher/editMapClassSubjects";
	}
	@RequestMapping(value = "/editor/headTeacher/saveMapClassSubject", method = RequestMethod.POST)
	public String saveMapClassSubject(@ModelAttribute("MapClassSubject") MapClassSubject mapClassSubject, Model model) {
		try{
			System.out.println("Saving MapCS");
			mapClassSubjectService.save(mapClassSubject);
			return "redirect:/editor/headTeacher/editMapClassSubjects";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			System.out.println("Cannot save MapCS");
			return "redirect:/editor/headTeacher/editMapClassSubjects";
		}
	}

	@GetMapping("/editor/headTeacher/createMapClassSubject")
	public String addMapClassSubject(Model model) {
		model.addAttribute("listMSubjects", mSubjectService.findAll());

		return "editor/headTeacher/createMapClassSubject";
	}

	@RequestMapping("/editor/headTeacher/mapClassSubject/edit/{map_class_subject_id}")
	public ModelAndView editMapClassSubject(@PathVariable(name = "map_class_subject_id") Long id) {
		ModelAndView mav = new ModelAndView("/editor/headTeacher/editMapClassSubjects");
		
		mav.addObject("listMapClassSubjects", mapClassSubjectService.findAll());
		mav.addObject("listMClasses", mClassService.findAll());
		mav.addObject("listMSubjects", mSubjectService.findAll());
		mav.addObject("mapClassSubject", mapClassSubjectService.get(id));

		return mav;
	}

	@RequestMapping("/editor/headTeacher/mapClassSubject/toggleStatus/{m_stage_id}")
	public String toggleMapClassSubjectStatus(@PathVariable(name = "m_stage_id") Long id) {
		MapClassSubject mapClassSubject = mapClassSubjectService.get(id);
		mapClassSubject.setIsActive(!(mapClassSubject.getIsActive()));
		mapClassSubjectService.save(mapClassSubject);

		return "redirect:/editor/headTeacher/editMapClassSubjects";
	}
	//	END: HEAD-TEACHER MapClassSubject Methods
	
	//	START: TEACHER-EDUCATOR TGoal Methods
	@GetMapping("/editor/teacherEducator/editTGoals")
	public String teacherEducatorEditClassSubjects(Model model) {
		model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
		model.addAttribute("listMGoals", mGoalService.findAll());
		model.addAttribute("listTGoals", tGoalService.findAll());
		model.addAttribute("tGoal", new TGoal());
		
		return "editor/teacherEducator/editTGoals";
	}
	
	@RequestMapping(value = "/editor/teacherEducator/saveTGoal", method = RequestMethod.POST)
	public String saveTGoal(@ModelAttribute("TGoal") TGoal tGoal, Model model) {
		try{
			tGoalService.save(tGoal);
			return "redirect:/editor/teacherEducator/editTGoals";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			return "redirect:/editor/teacherEducator/editTGoals";
		}
	}
	
	@RequestMapping("/editor/teacherEducator/tGoal/edit/{t_goal_id}")
	public ModelAndView editTGoal(@PathVariable(name = "t_goal_id") Long id) {
		ModelAndView mav = new ModelAndView("/editor/teacherEducator/editTGoals");
		
		mav.addObject("listMapClassSubjects", mapClassSubjectService.findAll());
		mav.addObject("listMGoals", mGoalService.findAll());
		mav.addObject("listTGoals", tGoalService.findAll());
		mav.addObject("tGoal", tGoalService.get(id));
		mav.addObject("listMapClassSubjects", mapClassSubjectService.findAll());
		
		return mav;
	}
	
	@RequestMapping("/editor/teacherEducator/tGoal/toggleStatus/{t_goal_id}")
	public String toggleTGoalStatus(@PathVariable(name = "t_goal_id") Long id) {
		TGoal tGoal = tGoalService.get(id);
		tGoal.setIsActive(!(tGoal.getIsActive()));
		tGoalService.save(tGoal);
		
		return "redirect:/editor/teacherEducator/editTGoals";
	}
	//	END: TEACHER-EDUCATOR TGoal Methods
	
	//	START: TEACHER-EDUCATOR TCompetency Methods
	@GetMapping("/editor/teacherEducator/editTCompetencies")
	public String teacherEducatorEditCompetencies(Model model) {
		model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
		model.addAttribute("listTCompetencies", tCompetencyService.findAll());
		model.addAttribute("listMCompetencies", mCompetencyService.findAll());
		model.addAttribute("listMGoals", mGoalService.findAll());
		model.addAttribute("listTGoals", tGoalService.findAll());
		model.addAttribute("tCompetency", new TCompetency());
		
		return "editor/teacherEducator/editTCompetencies";
	}
	
	@GetMapping("/goalsList")
	@ResponseBody
	public ResponseEntity<List<TGoal>> getGoalList(@RequestParam("subjectId") Long mapClassSubjectId) {
		try {
			List<TGoal> goalList = tGoalService.getGoalsByMapCS(mapClassSubjectId);
			return new ResponseEntity<>(goalList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error fetching classes by mapClassSubjectId: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/editor/teacherEducator/saveTCompetency", method = RequestMethod.POST)
	public String saveTCompetency(@ModelAttribute("TCompetency") TCompetency tCompetency, Model model) {
		try{
			tCompetencyService.save(tCompetency);
			return "redirect:/editor/teacherEducator/editTCompetencies";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			return "redirect:/editor/teacherEducator/editTCompetencies";
		}
	}
	
	@GetMapping("/editor/teacherEducator/createTCompetency")
	public String addTCompetency(Model model) {
		model.addAttribute("listMSubjects", mSubjectService.findAll());
		
		return "editor/teacherEducator/createTCompetency";
	}
	
	@RequestMapping("/editor/teacherEducator/tCompetency/edit/{t_competency_id}")
	public ModelAndView editTCompetency(@PathVariable(name = "t_competency_id") Long id) {
		ModelAndView mav = new ModelAndView("/editor/teacherEducator/editTCompetencies");
		
		mav.addObject("tCompetency", tCompetencyService.get(id));
		mav.addObject("listMapClassSubjects", mapClassSubjectService.findAll());
		mav.addObject("listTCompetencies", tCompetencyService.findAll());
		mav.addObject("listMCompetencies", mCompetencyService.findAll());
		mav.addObject("listMGoals", mGoalService.findAll());
		mav.addObject("listTGoals", tGoalService.findAll());
		
		return mav;
	}
	
	@RequestMapping("/editor/teacherEducator/tCompetency/toggleStatus/{t_competency_id}")
	public String toggleTCompetencyStatus(@PathVariable(name = "t_competency_id") Long id) {
		TCompetency tCompetency = tCompetencyService.get(id);
		tCompetency.setIsActive(!(tCompetency.getIsActive()));
		tCompetencyService.save(tCompetency);
		return "redirect:/editor/teacherEducator/editTCompetencies";
	}
	//	END: TEACHER-EDUCATOR TCompetency Methods
	
	//	START: TEACHER-EDUCATOR TLoSa Methods
	@GetMapping("/editor/teacherEducator/editTLoSas")
	public String teacherEducatorEditLoSas(Model model) {
		model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
		model.addAttribute("listTGoals", tGoalService.findAll());
		model.addAttribute("listTCompetencies", tCompetencyService.findAll());
		model.addAttribute("listTLoSas", tLoSaService.findAll());
		model.addAttribute("tLoSa", new TLoSa());
		
		return "editor/teacherEducator/editTLoSas";
	}
	
	@GetMapping("/competenciesList")
	@ResponseBody
	public ResponseEntity<List<TCompetency>> getCompetencyList(@RequestParam("goalId") Long tGoalId) {
		try {
			System.out.println("goalId: " + tGoalId);
			List<TCompetency> competencyList = tCompetencyService.getCompetenciesByGoal(tGoalId);
			System.out.println("DD-Competencies " + competencyList);
			return new ResponseEntity<>(competencyList, HttpStatus.OK);
		} catch (Exception e) {
			System.err.println("Error fetching classes by mapClassSubjectId: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/editor/teacherEducator/saveTLoSa", method = RequestMethod.POST)
	public String saveTLoSa(@ModelAttribute("TLoSa") TLoSa tLoSa, Model model) {
		try{
			tLoSaService.save(tLoSa);
			return "redirect:/editor/teacherEducator/editTLoSas";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			return "redirect:/editor/teacherEducator/editTLoSas";
		}
	}
	
	@GetMapping("/editor/teacherEducator/createTLoSa")
	public String addTLoSa(Model model) {
		model.addAttribute("listMSubjects", mSubjectService.findAll());
		
		return "editor/teacherEducator/createTLoSa";
	}
	
	@RequestMapping("/editor/teacherEducator/tLoSa/edit/{t_lo_sa_id}")
	public ModelAndView editTLoSa(@PathVariable(name = "t_lo_sa_id") Long id) {
		ModelAndView mav = new ModelAndView("/editor/teacherEducator/editTLoSas");
		
		mav.addObject("tLoSa", tLoSaService.get(id));
		mav.addObject("listMapClassSubjects", mapClassSubjectService.findAll());
		mav.addObject("listTGoals", tGoalService.findAll());
		mav.addObject("listTCompetencies", tCompetencyService.findAll());
		mav.addObject("listTLoSas", tLoSaService.findAll());
		 
		return mav;
	}
	
	@RequestMapping("/editor/teacherEducator/tLoSa/toggleStatus/{t_lo_sa_id}")
	public String toggleTLoSaStatus(@PathVariable(name = "t_lo_sa_id") Long id) {
		TLoSa tLoSa = tLoSaService.get(id);
		tLoSa.setIsActive(!(tLoSa.getIsActive()));
		tLoSaService.save(tLoSa);
		
		return "redirect:/editor/teacherEducator/editTLoSas";
	}
	//	END: TEACHER-EDUCATOR TLoSa Methods
}