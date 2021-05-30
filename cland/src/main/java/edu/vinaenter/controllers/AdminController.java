package edu.vinaenter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.service.UserService;
import edu.vinaenter.service.VnecontactService;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private LandsService landService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private VnecontactService contactService;
	
	@GetMapping()
	public String index(HttpSession session, Authentication authentication, Model model) {
		session.setAttribute("username", authentication.getName());
		
		
		model.addAttribute("numberOfCat", catService.getRow());
		model.addAttribute("numberOfLand", landService.getRow());
		model.addAttribute("numberOfUser", userService.getRow());
		model.addAttribute("numberOfContact", contactService.getRow());
		
		return "admin.index";
	}
	
	
}
