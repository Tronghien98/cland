package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Role;
import edu.vinaenter.models.Users;
import edu.vinaenter.service.RoleService;
import edu.vinaenter.service.UserService;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_USER)
public class AdminUserController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(URLConstant.INDEX)
	public String index(Model model) {
		List<Users> userList = userService.getAll();
		model.addAttribute("userList", userList);
		return "admin.user.index";
	}
	
	@GetMapping(URLConstant.ADD)
	public String add(Model model) {
		List<Role> listRole = roleService.getAll();
		
		model.addAttribute("listRole", listRole);
		return "admin.user.add";
	}
	
	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("user") Users user, 
			BindingResult br, Model model,
			@RequestParam String repassword, 
			@RequestParam("roleId") int roleId ,  RedirectAttributes ra) {
		if(br.hasErrors()) {
			List<Role> listRole = roleService.getAll();
			
			model.addAttribute("listRole", listRole);
			return "admin.user.add";
		}
		if(!repassword.equals(user.getPassword())) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/user/add";
		} else if(user.getUsername().equals
				(userService.findByUsername(user.getUsername()).getUsername())){
			ra.addFlashAttribute("errEqual", messageSource.getMessage("msg.errEqual", null, Locale.getDefault()));
			return "redirect:/admin/user/add";
		} else {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			user.setEnable(true);
			user.setRole(new Role(roleId, null));
			if(userService.save(user)>0) {
			
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
				return "redirect:/admin/user/index";
			}
		}
		return "admin.user.add";
	}
	
	@GetMapping(URLConstant.UPDATE + "/id={id}")
	public String update(@PathVariable Integer id, Model model, RedirectAttributes rd) {
		Users user = userService.findById(id);
		
		if (user == null) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		model.addAttribute("user", user);
		model.addAttribute("listRole", roleService.getAll());
		return "admin.user.update";
	}
	@PostMapping(URLConstant.UPDATE + "/id={id}")
	public String update(@PathVariable Integer id,@RequestParam String repassword,
			@ModelAttribute("user") Users user,
			@RequestParam("roleId") int roleId, 
			RedirectAttributes ra) {
		Users userById = userService.findById(id);
		if(!repassword.equals(user.getPassword())) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/user/update/id" + id;
		} else if(user.getUsername().equals
				(userService.findByUsername(user.getUsername()).getUsername())){
			ra.addFlashAttribute("errEqual", messageSource.getMessage("err.errEqual", null, Locale.getDefault()));
			return "redirect:/admin/user/update/id=" + id;
		} else {
			if("".equals(user.getPassword())) {
				user.setPassword(userById.getPassword());
			} else {
				user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			}
			user.setRole(new Role(roleId, null));
			if(userService.update(user, id)>0) {
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
				return "redirect:/admin/user/index";
			}
		}
		return "admin.user.index";
	}
	@GetMapping(URLConstant.DEL + "/id={id}")
	public String del(@PathVariable Integer id, RedirectAttributes rd) {
		if(userService.del(id)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		return "admin.user.index";
	}
	
	
	@GetMapping(URLConstant.URL_ADMIN_USER_PROFILE)
	public String profile(@PathVariable("username") String username, Model model) {
		Users user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "admin.user.profile";
	}
	
	@GetMapping(URLConstant.URL_ADMIN_UPDATE_USER)
	public String updateProfile(@PathVariable("username") String username,
			Authentication authentication,
			Model model) {
		if(!username.equals(authentication.getName())) {
			return "error.403";
		} 
		Users user = userService.findByUsername(username);
		model.addAttribute("user", user);
		return "admin.user.update.profile";
	}
	
	@PostMapping(URLConstant.URL_ADMIN_UPDATE_USER)
	public String updateProfile(@PathVariable("username") String username,
			@Valid @ModelAttribute("user") Users user, 
			BindingResult br , Model model,
			HttpSession session,
			@RequestParam("repassword") String repass,
			RedirectAttributes ra) {
		Users userByUsername = userService.findByUsername(username);
		
		if (br.hasErrors()) {
			return "admin.user.update.profile";
		} else
		if(!repass.equals(user.getPassword())) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/user/profile/update/" + username;
		} else if(user.getUsername().equals
				(userService.findByUsername(user.getUsername()).getUsername())){
			ra.addFlashAttribute("errEqual", messageSource.getMessage("err.errEqual", null, Locale.getDefault()));
			return "redirect:/admin/user/profile/update/" + username;
		}else {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			user.setEnable(true);
			user.setRole(new Role(3, null));
			if (userService.update(user, userByUsername.getId()) > 0) {
				model.addAttribute("user", user);
				session.setAttribute("username", user.getUsername());
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
				
				return "admin.user.profile";
			} else {
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
				return "redirect:/admin/user/profile/update" + username;
			}
		}
	}
}
