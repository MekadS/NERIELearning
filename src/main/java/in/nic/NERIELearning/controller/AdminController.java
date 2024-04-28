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
import in.nic.NERIELearning.model.MStage;
import in.nic.NERIELearning.model.MSubject;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;

@Controller
public class AdminController{
	@Autowired
	MStageService mStageService;
	@Autowired
	MClassService mClassService;
	@Autowired
	MSubjectService mSubjectService;

	//	START: ADMIN Mappings
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	//	START: ADMIN MStage Methods
	@GetMapping("/admin/editMStages")
	public String adminEditStages(Model model) {
		List<MStage> listMStage = mStageService.findAll();
		model.addAttribute("listMStages", listMStage);
		model.addAttribute("mStage", new MStage());

		return "admin/editMStages";
	}
	@RequestMapping(value = "/admin/saveMStage", method = RequestMethod.POST)
	public String saveMStage(@ModelAttribute("MStage") MStage mStage) {
		mStageService.save(mStage);
		return "redirect:/admin/editMStages";
	}

	@GetMapping("/admin/createMStage")
	public String addMStage(Model model) {
		model.addAttribute("mStage", new MStage());

		return "/admin/createMStage";
	}

	@RequestMapping("/admin/mStage/edit/{m_stage_id}")
	public ModelAndView editMStage(@PathVariable(name = "m_stage_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMStage");

		MStage mStage = mStageService.get(id);
		mav.addObject("mStage", mStage);

		return mav;
	}

	@RequestMapping("/admin/mStage/toggleStatus/{m_stage_id}")
	public String toggleMStageStatus(@PathVariable(name = "m_stage_id") Long id) {
		MStage mStage = mStageService.get(id);
		mStage.setIsActive(!(mStage.getIsActive()));
		mStageService.save(mStage);

		return "redirect:/admin/editMStages";
	}
	//	END: ADMIN MStage Methods

	//	START: ADMIN MClass Methods
	@GetMapping("/admin/editMClasses")
	public String adminEditClasses(Model model) {
		model.addAttribute("listMClasses", mClassService.findAll());
		model.addAttribute("listMStages", mStageService.findAll());
		model.addAttribute("mClass", new MClass());

		return "admin/editMClasses";
	}
	@RequestMapping(value = "/admin/saveMClass", method = RequestMethod.POST)
	public String saveMClass(@ModelAttribute("MClass") MClass mClass, Model model) {
		try{
			mClassService.save(mClass);
//			model.addAttribute("message", "Success");
			return "redirect:/admin/editMClasses";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			// Set error message for the view
//			model.addAttribute("message", "Error");
//			System.out.println(model);
			return "redirect:/admin/editMClasses";
		}
	}

	@GetMapping("/admin/createMClass")
	public String addMClass(Model model) {
		model.addAttribute("listMStages", mStageService.findAll());

		return "/admin/createMClass";
	}

	@RequestMapping("/admin/mClass/edit/{m_class_id}")
	public ModelAndView editMClass(@PathVariable(name = "m_class_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMClass");
		
		MClass mClass = mClassService.get(id);
		List<MStage> listMStages = mStageService.findAll();

		mav.addObject("mClass", mClass);
		mav.addObject("listMStages", listMStages);

		System.out.println("mClass: " + mClass);
		System.out.println("mStagesList: " + listMStages);
		return mav;
	}

	@RequestMapping("/admin/mClass/toggleStatus/{m_stage_id}")
	public String toggleMClassStatus(@PathVariable(name = "m_stage_id") Long id) {
		MClass mClass = mClassService.get(id);
		mClass.setIsActive(!(mClass.getIsActive()));
		mClassService.save(mClass);

		return "redirect:/admin/editMClasses";
	}
	//	END: ADMIN MClass Methods
	//	END: ADMIN Mappings

	//	START: ADMIN MSubject Methods
	@GetMapping("/admin/editMSubjects")
	public String adminEditMSubjects(Model model) {
		List<MSubject> listMSubject = mSubjectService.findAll();
		model.addAttribute("listMSubjects", listMSubject);
		model.addAttribute("mSubject", new MSubject());

		return "admin/editMSubjects";
	}
	@RequestMapping(value = "/admin/saveMSubject", method = RequestMethod.POST)
	public String saveMSubject(@ModelAttribute("MSubject") MSubject mSubject) {
		mSubjectService.save(mSubject);
		return "redirect:/admin/editMSubjects";
	}

	@GetMapping("/admin/createMSubject")
	public String addMSubject(Model model) {
		model.addAttribute("mSubject", new MSubject());

		return "/admin/createMSubject";
	}

	@RequestMapping("/admin/mSubject/edit/{m_subject_id}")
	public ModelAndView editMSubject(@PathVariable(name = "m_subject_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMSubject");

		MSubject mSubject = mSubjectService.get(id);
		mav.addObject("mSubject", mSubject);

		return mav;
	}

	@RequestMapping("/admin/mSubject/toggleStatus/{m_subject_id}")
	public String toggleMSubjectStatus(@PathVariable(name = "m_subject_id") Long id) {
		MSubject mSubject = mSubjectService.get(id);
		mSubject.setIsActive(!(mSubject.getIsActive()));
		mSubjectService.save(mSubject);

		return "redirect:/admin/editMSubjects";
	}
	//	END: ADMIN MSubject Methods
}