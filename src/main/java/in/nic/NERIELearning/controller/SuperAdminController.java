package in.nic.NERIELearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.nic.NERIELearning.model.MRole;
import in.nic.NERIELearning.model.Userlogin;
import in.nic.NERIELearning.service.MRoleService;
import in.nic.NERIELearning.service.UserLoginService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class SuperAdminController{
	@Autowired
	MRoleService mRoleService;
	@Autowired
	UserLoginService tUserLoginService;
	
	//	START: ADMIN Mappings
	//	START: ADMIN MRole Methods
	@GetMapping("editMRoles")
	public String adminEditRoles(Model model) {
		model.addAttribute("listMRoles", mRoleService.findAll());
		model.addAttribute("mRole", new MRole());

		return "admin/editMRoles";
	}
	
	@RequestMapping(value = "saveMRole", method = RequestMethod.POST)
	public String saveMRole(@ModelAttribute("MRole") @Valid MRole mRole, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/admin/editMRoles";
		} else {
			mRoleService.save(mRole);
		}
		return "redirect:/admin/editMRoles";
	}

	@RequestMapping("mRole/edit/{m_role_id}")
	public ModelAndView editMRole(@PathVariable(name = "m_role_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/editMRoles");
		
		mav.addObject("mRole", mRoleService.get(id));
		mav.addObject("listMRoles", mRoleService.findAll());
		
		return mav;
	}

	@RequestMapping("mRole/toggleStatus/{m_role_id}")
	public String toggleMRoleStatus(@PathVariable(name = "m_role_id") Long id) {
		MRole mRole = mRoleService.get(id);
		mRole.setIsActive(!(mRole.getIsActive()));
		mRoleService.save(mRole);

		return "redirect:/admin/editMRoles";
	}
	//	END: ADMIN MRole Methods
	
	//	START: ADMIN TUserLogin Methods
	@GetMapping("editTUserLogins")
	public String adminEditUserLogins(Model model) {
		model.addAttribute("listMRoles", mRoleService.findAll());
		model.addAttribute("listTUserLogins", tUserLoginService.findAll());
		model.addAttribute("tUserLogin", new Userlogin());
		
		System.out.println("Users: " + tUserLoginService.findAll());
		return "admin/editTUserLogins";
	}
	
	@RequestMapping(value = "saveUserLogin", method = RequestMethod.POST)
	public String saveTUserLogin(@ModelAttribute("Userlogin") @Valid Userlogin tUserLogin, BindingResult bindingResult) {
		System.out.println("Errors");
		if(bindingResult.hasErrors()) {
			System.out.println("Errors: " + bindingResult);
			return "/admin/editTUserLogins";
		} else {
			System.out.println("Saving");
			tUserLoginService.save(tUserLogin);
			System.out.println("saved");
		}
		return "redirect:/admin/editTUserLogins";
	}
	
	@RequestMapping("userLogin/edit/{t_user_login_id}")
	public ModelAndView editTUserLogin(@PathVariable(name = "t_user_login_id") Long id) {
		ModelAndView mav = new ModelAndView("/admin/editTUserLogins");
		
		mav.addObject("listMRoles", mRoleService.findAll());
		mav.addObject("tUserLogin", tUserLoginService.get(id));
		mav.addObject("listTUserLogins", tUserLoginService.findAll());
		
		return mav;
	}
	
	@RequestMapping("userLogin/toggleStatus/{t_user_login_id}")
	public String toggleTUserLoginStatus(@PathVariable(name = "t_user_login_id") Long id) {
		Userlogin tUserLogin = tUserLoginService.get(id);
		tUserLogin.setIsActive(!(tUserLogin.getIsActive()));
		tUserLoginService.save(tUserLogin);
		
		return "redirect:/admin/editTUserLogins";
	}
	//	END: ADMIN TUserLogin Methods
	

	//	END: ADMIN Mappings
}