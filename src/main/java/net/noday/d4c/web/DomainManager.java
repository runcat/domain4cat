/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.noday.d4c.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.noday.core.web.GeneralController;
import net.noday.d4c.model.Domain;
import net.noday.d4c.model.Subdomain;
import net.noday.d4c.service.SubdomainService;
import net.noday.d4c.service.impl.DomainServiceImpl;

/**
 * domain4cat DomainManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-19
 * @since 
 */
@Controller @RequestMapping("admin/domain")
public class DomainManager extends GeneralController<Domain, Long> {

	@Autowired private DomainServiceImpl domainService;
	@Autowired private SubdomainService subdomainService;
	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#create()
	 */
	@Override
	public String create() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#save(java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String save(Domain obj, BindingResult result, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#delete(java.io.Serializable, org.springframework.ui.Model)
	 */
	@Override
	public String delete(Long id, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#edit(java.io.Serializable, org.springframework.ui.Model)
	 */
	@Override
	public String edit(Long id, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#modify(java.io.Serializable, java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String modify(Long id, Domain obj, BindingResult result, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#list(int, org.springframework.ui.Model)
	 */
	@Override
	public String list(int index, Model m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list(Model m) {
		Domain domain = domainService.get(getUser().getId());
		m.addAttribute("domain", domain);
		List<Subdomain> subdomains = subdomainService.findSubdomain(domain.getDnspodDomainId());
		m.addAttribute("subdomains", subdomains);
		return "domain";
	}
	
	@RequestMapping("status")
	public String checkStatus(@RequestParam("dnspodDomainId") String dnspodDomainId, Model m) {
		responseData(m, domainService.updateStatus(dnspodDomainId));
		return "";
	}
}
