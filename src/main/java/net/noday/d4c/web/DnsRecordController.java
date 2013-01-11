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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import net.noday.core.web.GeneralController;
import net.noday.d4c.model.DnsRecord;
import net.noday.d4c.service.impl.DnsRecordServiceImpl;

/**
 * domain4cat DnsRecordController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
public class DnsRecordController extends GeneralController<DnsRecord, Long> {

	@Autowired private DnsRecordServiceImpl service;
	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#create()
	 */
	@Override
	public String create() {
		return "";
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#save(java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String save(@Valid DnsRecord obj, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute(result.getFieldErrors());
		} else {
			Long id = service.save(obj);
			responseData(m, id);
		}
		return "admin/article/add-success";
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#delete(long, org.springframework.ui.Model)
	 */
	@Override
	public String delete(@PathVariable("id") Long id, Model m) {
		service.delete(id);
		responseResult(m, true);
		return "";
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#edit(long, org.springframework.ui.Model)
	 */
	@Override
	public String edit(@PathVariable("id") Long id, Model m) {
		m.addAttribute(service.get(id));
		return "admin/article/add";
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#modify(long, java.lang.Object, org.springframework.validation.BindingResult, org.springframework.ui.Model)
	 */
	@Override
	public String modify(@PathVariable("id") Long id, @Valid DnsRecord obj, BindingResult result, Model m) {
		service.update(obj);
		responseData(m, id);
		return "admin/article/add-success";
	}

	/* (non-Javadoc)
	 * @see net.noday.core.web.GeneralController#list(int, org.springframework.ui.Model)
	 */
	@Override
	public String list(@PathVariable("index") int index, Model m) {
		responseData(m, service.findPage(index, null));
		return "admin/article/list";
	}

}
