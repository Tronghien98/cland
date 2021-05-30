package edu.vinaenter.controllers.admin;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.constant.URLConstant;
import edu.vinaenter.models.Categories;
import edu.vinaenter.models.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_LAND)
public class AdminLandsController {
	@Resource
	MessageSource messageSource;
	
	@Autowired
	private LandsService landsService;
	
	@Autowired
	private CatService catService;
	
	@GetMapping({URLConstant.INDEX, URLConstant.INDEX_PAGE})
	public String index(Model model, @PathVariable(required = false) Integer page) {
		if(page==null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.ADMIN_TOTAL_ROW);
		List<Lands> landList = landsService.getAll(offset, GlobalConstant.ADMIN_TOTAL_ROW);
		
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landsService.getRow(), GlobalConstant.ADMIN_TOTAL_ROW));
		model.addAttribute("landList", landList);
		return "admin.land.index";
	}
	
	@GetMapping(URLConstant.ADD)
	public String add(Model model) {
		model.addAttribute("listCat", catService.getAll());
		return "admin.land.add";
	}
	
	@PostMapping(URLConstant.ADD)
	public String add(@Valid @ModelAttribute("land") Lands land, BindingResult br,
			@RequestParam("catId") int cid,
			@RequestParam("file") MultipartFile file, HttpServletRequest request,
			RedirectAttributes ra) {
		if(br.hasErrors()) {
			return "admin.land.add";
		}
		String filename = FileUtil.upload(file, request);
		land.setPicture(filename);
		land.setCat(new Categories(cid, null));
		if(landsService.save(land)>0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		} 
		return "admin.land.add";
	}
	
	@GetMapping(URLConstant.DEL + "/{id}")
	public String del(@PathVariable Integer id, RedirectAttributes ra) {
		if (landsService.del(id)>0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		} else {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
	}
	
	
	@GetMapping(URLConstant.UPDATE + "/{id}")
	public String update(@PathVariable Integer id, Model model, RedirectAttributes ra) {
		Lands lands = landsService.findById(id);
		model.addAttribute("land", lands);
		if (lands==null) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
		model.addAttribute("listCat", catService.getAll());
		return "admin.land.update";
	}
	
	@PostMapping(URLConstant.UPDATE + "/{id}")
	public String update(@ModelAttribute("land") Lands landUpdate, @PathVariable Integer id,
			@RequestParam("catId") Integer cid , @RequestParam("file") MultipartFile file, 
			HttpServletRequest request, RedirectAttributes ra) {
		Lands lands = landsService.findById(id);
		String filename = FileUtil.upload(file, request);
		if("".equals(filename)) {
			landUpdate.setPicture(lands.getPicture());
		} else {
			landUpdate.setPicture(filename);
		}
		
		landUpdate.setCat(new Categories(cid, null));
		if(landsService.update(landUpdate, id)>0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		} else {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
	}
	
	
	@GetMapping({URLConstant.SEARCH, URLConstant.SEARCH_PAGE})
	public String searchLand(@RequestParam("ql") String searchLand,
			@PathVariable(required = false) Integer page,
			Model model, RedirectAttributes rd) {
		if(page == null) {
			page = 1;
		}
		if ("".equals(searchLand)) {
			rd.addFlashAttribute("err", messageSource.getMessage("err.required", null, Locale.getDefault()));
			return "redirect:/admin/land/index";
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.ADMIN_TOTAL_ROW);
		List<Lands> landList = landsService.findAll(searchLand, offset, GlobalConstant.ADMIN_TOTAL_ROW);
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landsService.getRowSearch(searchLand), GlobalConstant.ADMIN_TOTAL_ROW));
		model.addAttribute("landList", landList);
		model.addAttribute("searchLand", searchLand);
		return "admin.land.resultSearch";
	}
	
}
