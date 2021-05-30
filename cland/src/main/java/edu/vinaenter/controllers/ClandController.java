package edu.vinaenter.controllers;

import java.util.List;
import java.util.Locale;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constant.GlobalConstant;
import edu.vinaenter.dao.CatDtoDAO;
import edu.vinaenter.models.Lands;
import edu.vinaenter.models.Vnecontact;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.service.VnecontactService;
import edu.vinaenter.util.DateUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping
public class ClandController {
	
	@Autowired
	private VnecontactService vneConService;
	
	@Autowired
	private LandsService landService;
	
	@Autowired
	private CatService catService;
	
	@Autowired
	private CatDtoDAO catDtoDAO;
	
	@Autowired
	private LandsService landsService;
	
	@Autowired
	private MessageSource messageSource;
	

	@GetMapping({"", "/{page}"})
	public String index(Model model, @PathVariable(required = false) Integer page) {
		if(page==null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.CLAND_TOTAL_ROW);
		model.addAttribute("listLand", landService.getAll(offset, GlobalConstant.CLAND_TOTAL_ROW));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landService.getRow(), GlobalConstant.CLAND_TOTAL_ROW));
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		
		return "cland.index";
	}
	@GetMapping({"cat/{cid}", "cat/{cid}/page={page}"})
	public String cat(Model model,
			@PathVariable("cid") Integer cid,
			@PathVariable(required = false) Integer page) {
		if(page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.CLAND_TOTAL_ROW);
		model.addAttribute("listLand", landService.findAllByCatId(cid, offset, GlobalConstant.CLAND_TOTAL_ROW));
		model.addAttribute("cat", catService.findById(cid));
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landService.getRowCat(cid), GlobalConstant.CLAND_TOTAL_ROW));
		return "cland.cat";
	}
	
	@GetMapping({"catHot/{cid}", "catHot/{cid}/page={page}"})
	public String catHot(Model model,
			@PathVariable("cid") Integer cid,
			@PathVariable(required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		model.addAttribute("listLand", landService.findAllByHotCatId(cid, 
				DateUtil.getPreDate(), DateUtil.getPosDate(),
				PageUtil.getOffset(page, GlobalConstant.CLAND_TOTAL_ROW),
				GlobalConstant.CLAND_TOTAL_ROW));
		model.addAttribute("cat", catService.findById(cid));
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", 
				PageUtil.numberPage(landService.getRowHotCat(cid, DateUtil.getPreDate(), DateUtil.getPosDate()),
						GlobalConstant.CLAND_TOTAL_ROW));
		return "cland.cat";
	}
	@GetMapping("contact")
	public String contact(Model model) {
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		return "cland.contact";
	}
	@GetMapping({"single", "single/{lid}", "single/{lid}/page={page}"})
	public String sigle(@PathVariable(required = false) Integer lid,
			@PathVariable(required = false) Integer page,
			Model model, RedirectAttributes ra) {
		Lands land;
		if (page == null) {
			page = 1;
		}
		
		if (lid == null) {
			land = landService.getNewLand();
		} else {
			land = landService.findById(lid);
		}
		if(land == null) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/single";
		}
		
		model.addAttribute("land", land);
		model.addAttribute("listLandOfCat", landService.findAllByCatId(land.getCat().getCid(), 
				PageUtil.getOffset(page, GlobalConstant.CLAND_RELATE_ROW),
				GlobalConstant.CLAND_RELATE_ROW));
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landService.getRowCat(land.getCat().getCid()),
				GlobalConstant.CLAND_TOTAL_ROW));
		return "cland.single";
	}
	
	@PostMapping("contact/add")
	public String addContact(@Valid @ModelAttribute("contact") Vnecontact contact,
			BindingResult br,
			RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "cland.contact";
		}
		if(vneConService.save(contact)>0) {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/contact";
		} else {
			ra.addFlashAttribute("msg", messageSource.getMessage("msg.err", null, Locale.getDefault()));
			return "redirect:/contact";
		}
		
	}
	
	@GetMapping({"search", "search/{page}"})
	public String search(@RequestParam("ql") String searchLand,
			@PathVariable(required = false) Integer page,
			Model model, RedirectAttributes rd) {
		if(page == null) {
			page = 1;
		}
		if ("".equals(searchLand)) {
			rd.addFlashAttribute("err", messageSource.getMessage("err.required", null, Locale.getDefault()));
			return "redirect:/";
		}
		int offset = PageUtil.getOffset(page, GlobalConstant.CLAND_TOTAL_ROW);
		List<Lands> landList = landsService.findAll(searchLand, offset, GlobalConstant.CLAND_TOTAL_ROW);
		model.addAttribute("curPage", page);
		model.addAttribute("totalPage", PageUtil.numberPage(landsService.getRowSearch(searchLand), GlobalConstant.CLAND_TOTAL_ROW));
		model.addAttribute("listCatDTO", catDtoDAO.getTotalPostCat());
		model.addAttribute("listCat", catService.getAll());
		model.addAttribute("listLand", landList);
		model.addAttribute("listHotCat", catDtoDAO.getHotPostCat(DateUtil.getPreDate(), DateUtil.getPosDate()));
		model.addAttribute("listLandMostView", landService.getMostView(GlobalConstant.MOST_VIEW_ROW));
		model.addAttribute("searchLand", searchLand);
		return "cland.index";
	}
	
}
