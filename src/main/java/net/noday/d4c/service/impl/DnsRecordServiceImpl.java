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
package net.noday.d4c.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.noday.core.pagination.Page;
import net.noday.d4c.dao.DnsRecordDao;
import net.noday.d4c.model.DnsRecord;

/**
 * domain4cat DnsRecordServiceImpl
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
@Service
public class DnsRecordServiceImpl {

	@Autowired private DnsRecordDao dao;
	
	public Long save(DnsRecord obj) {
		return dao.save(obj);
	}
	
	public void update(DnsRecord obj) {
		dao.update(obj);
	}
	
	public void delete(Long id) {
		dao.delete(id);
	}
	
	public DnsRecord get(Long id) {
		return dao.get(id);
	}
	
	public Page<DnsRecord> findPage(int index, DnsRecord condition) {
		Page<DnsRecord> page = new Page<DnsRecord>(index, Page.DEFAULTSIZE);
		page.setPageCount(dao.findCount(condition));
		page.setRows(dao.findPage(condition, page.getPageIndex(), page.getPageCount()));
		return page;
	}

	public DnsRecordServiceImpl() {
		super();
	}
}
