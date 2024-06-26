package in.nic.NERIELearning.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import in.nic.NERIELearning.model.MClass;
import in.nic.NERIELearning.model.MContent;
import in.nic.NERIELearning.model.MStage;
import in.nic.NERIELearning.model.MSubject;
import in.nic.NERIELearning.model.MapClassSubject;
import in.nic.NERIELearning.service.CommonService;
import in.nic.NERIELearning.service.MClassService;
import in.nic.NERIELearning.service.MContentService;
import in.nic.NERIELearning.service.MStageService;
import in.nic.NERIELearning.service.MSubjectService;
import in.nic.NERIELearning.service.MapClassSubjectService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController{
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

	//	START: ADMIN Mappings
	@GetMapping("/home")
    public String getHomePage(Model model){
		System.out.println("ADMIN HOME");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());

        return "admin/dashboard";
    }
	
	@GetMapping("dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	//	START: ADMIN MStage Methods
	@GetMapping("editMStages")
	public String adminEditStages(Model model) {
		List<MStage> listMStage = mStageService.findAll();
		model.addAttribute("listMStages", listMStage);
		model.addAttribute("mStage", new MStage());

		return "admin/editMStages";
	}
	
	@RequestMapping(value = "saveMStage", method = RequestMethod.POST)
	public String saveMStage(@ModelAttribute("MStage") @Valid MStage mStage, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/editMStages";
		} else {
			mStageService.save(mStage);
		}
		return "redirect:/admin/editMStages";
	}

	@GetMapping("createMStage")
	public String addMStage(Model model) {
		model.addAttribute("mStage", new MStage());

		return "admin/createMStage";
	}

	@RequestMapping("mStage/edit/{m_stage_id}")
	public ModelAndView editMStage(@PathVariable(name = "m_stage_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMStage");

		MStage mStage = mStageService.get(id);
		mav.addObject("mStage", mStage);

		return mav;
	}

	@RequestMapping("mStage/toggleStatus/{m_stage_id}")
	public String toggleMStageStatus(@PathVariable(name = "m_stage_id") Long id) {
		MStage mStage = mStageService.get(id);
		mStage.setIsActive(!(mStage.getIsActive()));
		mStageService.save(mStage);

		return "redirect:/admin/editMStages";
	}
	//	END: ADMIN MStage Methods

	//	START: ADMIN MClass Methods
	@GetMapping("editMClasses")
	public String adminEditClasses(Model model) {
		model.addAttribute("listMClasses", mClassService.findAll());
		model.addAttribute("listMStages", mStageService.findAll());
		model.addAttribute("mClass", new MClass());

		return "admin/editMClasses";
	}
	@RequestMapping(value = "saveMClass", method = RequestMethod.POST)
	public String saveMClass(@ModelAttribute("MClass") MClass mClass, Model model) {
		try{
			mClassService.save(mClass);
//			model.addAttribute("message", "Success");
			return "redirect:/admin/editMClasses";
		} catch (DataIntegrityViolationException e) { // Catch data integrity violation (duplicate key)
			// Set error message for the view
//			model.addAttribute("message", "Error");
			return "redirect:/admin/editMClasses";
		}
	}

	@GetMapping("createMClass")
	public String addMClass(Model model) {
		model.addAttribute("listMStages", mStageService.findAll());

		return "admin/createMClass";
	}

	@RequestMapping("mClass/edit/{m_class_id}")
	public ModelAndView editMClass(@PathVariable(name = "m_class_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMClass");
		
		MClass mClass = mClassService.get(id);
		List<MStage> listMStages = mStageService.findAll();

		mav.addObject("mClass", mClass);
		mav.addObject("listMStages", listMStages);

		return mav;
	}

	@RequestMapping("mClass/toggleStatus/{m_stage_id}")
	public String toggleMClassStatus(@PathVariable(name = "m_stage_id") Long id) {
		MClass mClass = mClassService.get(id);
		mClass.setIsActive(!(mClass.getIsActive()));
		mClassService.save(mClass);

		return "redirect:/admin/editMClasses";
	}
	//	END: ADMIN MClass Methods

	//	START: ADMIN MSubject Methods
	@GetMapping("editMSubjects")
	public String adminEditMSubjects(Model model) {
		List<MSubject> listMSubject = mSubjectService.findAll();
		model.addAttribute("listMSubjects", listMSubject);
		model.addAttribute("mSubject", new MSubject());

		return "admin/editMSubjects";
	}

	@RequestMapping(value = "saveMSubject", method = RequestMethod.POST)
	public String saveMSubject(@ModelAttribute("MSubject") MSubject mSubject) {
		mSubjectService.save(mSubject);
		return "redirect:/admin/editMSubjects";
	}

	@GetMapping("/admin/createMSubject")
	public String addMSubject(Model model) {
		model.addAttribute("mSubject", new MSubject());

		return "admin/createMSubject";
	}

	@RequestMapping("mSubject/edit/{m_subject_id}")
	public ModelAndView editMSubject(@PathVariable(name = "m_subject_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMSubject");

		MSubject mSubject = mSubjectService.get(id);
		mav.addObject("mSubject", mSubject);

		return mav;
	}

	@RequestMapping("mSubject/toggleStatus/{m_subject_id}")
	public String toggleMSubjectStatus(@PathVariable(name = "m_subject_id") Long id) {
		MSubject mSubject = mSubjectService.get(id);
		mSubject.setIsActive(!(mSubject.getIsActive()));
		mSubjectService.save(mSubject);

		return "redirect:/admin/editMSubjects";
	}
	//	END: ADMIN MSubject Methods

	//	START: ADMIN MContent Methods
	@GetMapping("editMContent")
	public String adminEditMContent(Model model) throws IOException{
		List<MContent> listMContent = mContentService.findAll();
		model.addAttribute("listMContent", listMContent);
		model.addAttribute("mContent", new MContent());
		model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
		return "admin/editMContent";
	}
	
	@RequestMapping(value = "saveMContent", method = RequestMethod.POST)
	public String saveMContent(@ModelAttribute("MContent") @Valid MContent mContent,@RequestParam(name = "file", required = true) MultipartFile file, BindingResult result, Model model) throws IOException {
		
		if(result.hasErrors()) {
			List<MContent> listMContent = mContentService.findAll();
			model.addAttribute("listMContent", listMContent);
			model.addAttribute("mContent", mContent);
			model.addAttribute("listMapClassSubjects", mapClassSubjectService.findAll());
			return "redirect:/admin/editMContent";
		}
		if(file.getSize() > 3) {
			mContent.setMContentFile(file.getBytes());
		}
	    mContentService.save(mContent);
		return "redirect:/admin/editMContent";
	}
	
	@GetMapping("/admin/createMContent")
	public String addMContent(Model model) {
		model.addAttribute("mContent", new MContent());
		
		return "admin/createMContent";
	}
	
	@RequestMapping("mContent/edit/{m_content_id}")
	public ModelAndView editMContent(@PathVariable(name = "m_content_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/createMContent");
		List<MapClassSubject> listMapClassSubjects = mapClassSubjectService.findAll();
		
		MContent mContent = mContentService.get(id);
		mav.addObject("mContent", mContent);
		mav.addObject("listMapClassSubjects", listMapClassSubjects);

		return mav;
	}
	
	@RequestMapping("mContent/getDocument/{m_content_id}")
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
	
	@RequestMapping("mContent/toggleStatus/{m_content_id}")
	public String toggleMContentStatus(@PathVariable(name = "m_content_id") Long id) {
		MContent mContent = mContentService.get(id);
		mContent.setIsActive(!(mContent.getIsActive()));
		mContentService.save(mContent);
		
		return "redirect:/admin/editMContent";
	}
	//	END: ADMIN MContent Methods
	//	END: ADMIN Mappings
}