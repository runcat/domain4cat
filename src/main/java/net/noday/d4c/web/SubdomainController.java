/**
 * 
 */
package net.noday.d4c.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.noday.core.web.BaseController;
import net.noday.d4c.model.Subdomain;
import net.noday.d4c.service.SubdomainService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/subdomain")
public class SubdomainController extends BaseController {

	@Autowired private SubdomainService subdomainService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid Subdomain obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			Long id = subdomainService.createSubdomain(obj);
			m.addAttribute("domain", null);
			responseData(m, id);
		}
		return null;
	}
	
	@RequestMapping("/valid")
	public String checkSubdomain(@RequestParam("domainId") Long domainId, @RequestParam("name") String name, Model m) {
		responseResult(m, subdomainService.checkSubdomain(domainId, name));
		return "";
	}

	@RequestMapping(value = "share", method = RequestMethod.GET)
	public String share() {
		
		return null;
	}
	
	@RequestMapping(value = "share", method = RequestMethod.POST)
	public String share(@Valid Subdomain obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			Long id = subdomainService.save(obj);
			m.addAttribute("domain", null);
			responseData(m, id);
		}
		return null;
	}
}
