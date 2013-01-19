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

import net.noday.core.web.BaseController;
import net.noday.d4c.model.Domain;
import net.noday.d4c.service.impl.DomainServiceImpl;

/**
 * domain4cat DomainController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-18
 * @since 
 */
@Controller @RequestMapping("domain")
public class DomainController extends BaseController {

	@Autowired private DomainServiceImpl domainService;

	@RequestMapping(value = "share", method = RequestMethod.GET)
	public String share() {
		
		return "share";
	}
	
	@RequestMapping(value = "share", method = RequestMethod.POST)
	public String share(@Valid Domain obj, BindingResult result, Model m) {
		try {
			if (result.hasErrors()) {
				m.addAttribute(result.getFieldErrors());
			} else {
				Long id = domainService.createDomain(obj);
				m.addAttribute("domain", null);
				responseData(m, id);
				return "redirect:/login";
			}
		} catch (Exception e) {
			responseMsg(m, false, e.getMessage());
		}
		return "share";
	}
}
