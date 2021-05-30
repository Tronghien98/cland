package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Categories;
import edu.vinaenter.service.CatService;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CAT)
public class AdminCategoryController {
	
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private CatService catService;
	
	@GetMapping(URLConstant.INDEX)
	public String index(Model model) {
		List<Categories> catList = catService.getAll();
		model.addAttribute("catList", catList);
		return "admin.cat.index";
	}
	
	@GetMapping(URLConstant.ADD)
	public String add() {
		return "admin.cat.add";
	}
	
	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("cat") Categories category,
			BindingResult br,
			RedirectAttributes rd) {
		if(br.hasErrors()) {
			return "admin.cat.add";
		}
		if(catService.save(category)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null,Locale.getDefault() ));
			return "redirect:/admin/cat/index";
		}
		
		return "admin.cat.add";
	}
	
	@GetMapping(URLConstant.UPDATE + "/id={id}")
	public String update(@PathVariable Integer id, Model model) {
		Categories cat = catService.findById(id);
		model.addAttribute("cat", cat);
		return "admin.cat.update";
	}
	@PostMapping(URLConstant.UPDATE + "/id={cid}")
	public String update(@PathVariable Integer cid,@ModelAttribute("cat") @Valid Categories cat,
			BindingResult br,
			RedirectAttributes rd) {
		if(br.hasErrors()) {
			return "admin.cat.update";
		}

		if(catService.update(cat, cid)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null,Locale.getDefault() ));
			return "redirect:/admin/cat/index";
		}
		
		return "admin.cat.index";
	}
	
	@GetMapping(URLConstant.DEL + "/id={cid}")
	public String del(@PathVariable Integer cid, RedirectAttributes rd) {
		if(catService.del(cid)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null,Locale.getDefault() ));
			return "redirect:/admin/cat/index";
		}
		return "admin.cat.index";
	}
	
	
}
