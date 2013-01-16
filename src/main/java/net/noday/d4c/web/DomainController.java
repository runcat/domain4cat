/**
 * 
 */
package net.noday.d4c.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.noday.core.web.BaseController;
import net.noday.d4c.model.Domain;
import net.noday.d4c.service.DomainService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/domain")
public class DomainController extends BaseController {

	@Autowired private DomainService domainService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid Domain obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			Long id = domainService.save(obj);
			m.addAttribute("domain", null);
			responseData(m, id);
		}
		return "admin/article/add-success";
	}
	
	@RequestMapping("{id}/valid/{subdomain}")
	public String checkSubdomain(@PathVariable("id") Long id, @PathVariable("subdomain") String subdomain, Model m) {
		responseResult(m, domainService.checkSubdomain(id, subdomain));
		return "";
	}

	@RequestMapping(value = "share", method = RequestMethod.GET)
	public String share() {
		
		return null;
	}
	
	@RequestMapping(value = "share", method = RequestMethod.POST)
	public String share(@Valid Domain obj, BindingResult result, Model m) {
		
		return null;
	}
}
