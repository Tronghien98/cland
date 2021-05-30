package edu.vinaenter.controllers.admin.auth;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.models.Role;
import edu.vinaenter.models.Users;
import edu.vinaenter.service.UserService;

@Controller
@RequestMapping("auth")
public class AuthSignUpController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	UserService userService;
	
	@GetMapping("signup")
	public String signup() {
		return "auth.signup";
	}
	@PostMapping("signup")
	public String signup(@Valid @ModelAttribute("user") Users user,
			BindingResult br, @RequestParam("repassword") String repass,
			RedirectAttributes ra) {
		
		if (br.hasErrors()) {
			return "auth.signup";
		}
		if(!repass.equals(user.getPassword())) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/auth/signup";
		} else {
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
			user.setRole(new Role(3, null));
			if(userService.save(user)>0) {
				ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
				return "redirect:/auth/login";
			} else {
				return "auth.signup";
			}
		}
	}
}
