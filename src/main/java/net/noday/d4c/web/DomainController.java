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

import net.noday.core.web.GeneralController;
import net.noday.d4c.model.Domain;
import net.noday.d4c.service.DomainService;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/domain")
public class DomainController extends GeneralController<Domain, Long> {

	@Autowired private DomainService domainService;
	
	@Override
	public String create() {
		return "";
	}

	@Override
	public String save(@Valid Domain obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			Long id = domainService.save(obj);
			responseData(m, id);
		}
		return "admin/article/add-success";
	}

	@Override
	public String delete(@PathVariable("id") Long id, Model m) {
		domainService.delete(id);
		responseResult(m, true);
		return "";
	}

	@Override
	public String edit(@PathVariable("id") Long id, Model m) {
		m.addAttribute(domainService.get(id));
		return "admin/article/add";
	}

	@Override
	public String modify(@PathVariable("id") Long id, @Valid Domain obj, BindingResult result, Model m) {
		domainService.update(obj);
		responseData(m, id);
		return "admin/article/add-success";
	}

	@Override
	public String list(@PathVariable("index") int index, Model m) {
		responseData(m, domainService.findPage(index, null));
		return "admin/article/list";
	}
	
	@RequestMapping("{id}/valid/{subdomain}")
	public String checkSubdomain(@PathVariable("id") Long id, @PathVariable("subdomain") String subdomain, Model m) {
		responseResult(m, domainService.checkSubdomain(id, subdomain));
		return "";
	}

}
