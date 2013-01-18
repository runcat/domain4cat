/*
 * Copyright 2012 the original author or authors.
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

import net.noday.core.web.BaseController;
import net.noday.d4c.service.impl.DomainServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * cat MainController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Controller
public class MainController extends BaseController {

	@Autowired private DomainServiceImpl domainService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model m) {
		responseData(m, domainService.findDomain());
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String preLogin() {
		
		return "login";
	}
	
	@RequestMapping("admin")
	public String switchPage() {
		if (getSubject().hasRole("domain")) {
			return "redirect:/admin/domain";
		} else if (getSubject().hasRole("subdomain")) {
			return "redirect:/admin/subdomain";
		}
		
		return "redirect:/";
	}
}
