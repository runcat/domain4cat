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
 * domain4cat SubdomainController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-18
 * @since 
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
			m.addAttribute("subdomain", null);
			responseData(m, id);
		}
		return null;
	}
	
	@RequestMapping("/valid")
	public String checkSubdomain(@RequestParam("dnspodDomainId") String dnspodDomainId, @RequestParam("name") String name, Model m) {
		responseResult(m, subdomainService.checkSubdomain(dnspodDomainId, name));
		return "";
	}
}
