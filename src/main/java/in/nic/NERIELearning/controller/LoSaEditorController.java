package in.nic.NERIELearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MSubject;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.model.TGoal;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import in.nic.NERIELearning.service.TGoalService;

@Controller
public class LoSaEditorController{
	@Autowired
	MapClassSubjectService mapClassSubjectService;
	@Autowired
	TGoalService tGoalService;
	@Autowired
	MClassService mClassService;
	@Autowired
	MSubjectService mSubjectService;

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
			mapClassSubjectService.save(mapClassSubject);
			return "redirect:/editor/headTeacher/editMapClassSubjects";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
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
		ModelAndView mav = new ModelAndView("/editor/headTeacher/createMapClassSubject");
		
		MapClassSubject mapClassSubject = mapClassSubjectService.get(id);
		List<MClass> listMClasses = mClassService.findAll();
		List<MSubject> listMSubjects = mSubjectService.findAll();

		mav.addObject("mapClassSubject", mapClassSubject);
		mav.addObject("listMClasses", listMClasses);
		mav.addObject("listMSubjects", listMSubjects);

		System.out.println("mapClassSubject: " + mapClassSubject);
		System.out.println("mClassesList: " + listMClasses);
		System.out.println("mSubjectsList: " + listMSubjects);
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
		model.addAttribute("listTGoals", tGoalService.findAll());
		model.addAttribute("listMClasses", mClassService.findAll());
		model.addAttribute("listMSubjects", mSubjectService.findAll());
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
	
	@GetMapping("/editor/teacherEducator/createTGoal")
	public String addTGoal(Model model) {
		model.addAttribute("listMSubjects", mSubjectService.findAll());
		
		return "editor/teacherEducator/createTGoal";
	}
	
	@RequestMapping("/editor/teacherEducator/tGoal/edit/{map_class_subject_id}")
	public ModelAndView editTGoal(@PathVariable(name = "map_class_subject_id") Long id) {
		ModelAndView mav = new ModelAndView("/editor/teacherEducator/createTGoal");
		
		TGoal tGoal = tGoalService.get(id);
		List<MClass> listMClasses = mClassService.findAll();
		List<MSubject> listMSubjects = mSubjectService.findAll();
		
		mav.addObject("tGoal", tGoal);
		mav.addObject("listMClasses", listMClasses);
		mav.addObject("listMSubjects", listMSubjects);
		
		System.out.println("tGoal: " + tGoal);
		System.out.println("mClassesList: " + listMClasses);
		System.out.println("mSubjectsList: " + listMSubjects);
		return mav;
	}
	
//	@RequestMapping("/editor/teacherEducator/tGoal/toggleStatus/{m_stage_id}")
//	public String toggleTGoalStatus(@PathVariable(name = "m_stage_id") Long id) {
//		TGoal tGoal = tGoalService.get(id);
//		tGoal.setIsActive(!(tGoal.getIsActive()));
//		tGoalService.save(tGoal);
//		
//		return "redirect:/editor/teacherEducator/editTGoals";
//	}
	//	END: TEACHER-EDUCATOR TGoal Methods
}