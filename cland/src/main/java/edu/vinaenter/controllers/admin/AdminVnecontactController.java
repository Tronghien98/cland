package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Vnecontact;
import edu.vinaenter.service.VnecontactService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CONTACT)
public class AdminVnecontactController {
	
	@Autowired
	private VnecontactService vneConService;
	
	@Resource
	MessageSource messageSource;
	
	@GetMapping({URLConstant.INDEX, URLConstant.INDEX_PAGE})
	public String index(Model model, @PathVariable(required = false) Integer page) {
		if(page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.ADMIN_TOTAL_ROW);
		List<Vnecontact> contactList = vneConService.getAll(offset, GlobalConstant.ADMIN_TOTAL_ROW);
		model.addAttribute("contactList", contactList);
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(vneConService.getRow(), GlobalConstant.ADMIN_TOTAL_ROW));
		return "admin.contact.index";
	}
	
	@GetMapping(URLConstant.DEL + "/id={id}")
	public String del(@PathVariable Integer id, RedirectAttributes rd) {
		if(vneConService.del(id)>0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/contact/index";
		}
		return "admin.contact.index";
	}
	
	
	
	@GetMapping({URLConstant.SEARCH, URLConstant.SEARCH_PAGE})
	public String search(@RequestParam("ql") String searchContact,
			@PathVariable(required = false) Integer page,
			Model model, RedirectAttributes rd) {
		if(page == null) {
			page = 1;
		}
		if ("".equals(searchContact)) {
			rd.addFlashAttribute("err", messageSource.getMessage("err.required", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.ADMIN_TOTAL_ROW);
		List<Vnecontact> landList = vneConService.findAll(searchContact, offset, GlobalConstant.ADMIN_TOTAL_ROW);
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(vneConService.getRowSearch(searchContact), GlobalConstant.ADMIN_TOTAL_ROW));
		model.addAttribute("contactList", landList);
		model.addAttribute("searchContact", searchContact);
		return "admin.contact.index";
	}
}
