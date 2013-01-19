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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.noday.core.web.GeneralController;
import net.noday.d4c.model.Subdomain;
import net.noday.d4c.service.DnsrecordService;
import net.noday.d4c.service.SubdomainService;

/**
 * domain4cat SubdomainManager
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-18
 * @since 
 */
@Controller
@RequestMapping("/admin/subdomain")
public class SubdomainManager extends GeneralController<Subdomain, Long> {

	@Autowired private SubdomainService domainService;
	@Autowired private DnsrecordService recordService;
	
	@Override
	public String create() {
		return "";
	}

	@Override
	public String save(@Valid Subdomain obj, BindingResult result, Model m) {
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
	public String modify(@PathVariable("id") Long id, @Valid Subdomain obj, BindingResult result, Model m) {
		domainService.update(obj);
		responseData(m, id);
		return "admin/article/add-success";
	}

	@Override
	public String list(Model m) {
		responseData(m, recordService.findBySubdomainId(getUser().getId()));
		return "subdomain";
	}
	@Override
	public String list(@PathVariable("index") int index, Model m) {
		responseData(m, domainService.findPage(index, null));
		return "admin/article/list";
	}

}
