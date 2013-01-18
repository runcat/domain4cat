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
package net.noday.d4c.service.impl;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.core.utils.PasswordUtil;
import net.noday.d4c.dao.SubdomainDao;
import net.noday.d4c.model.Subdomain;
import net.noday.d4c.service.DnsrecordService;
import net.noday.d4c.service.SubdomainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * domain4cat SubdomainServiceImpl
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
@Service
public class SubdomainServiceImpl implements SubdomainService {

	@Autowired private SubdomainDao dao;
	@Autowired private DnsrecordService recordService;
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#findPage(int, net.noday.d4c.model.Domain)
	 */
	@Override
	public Page<Subdomain> findPage(int index, Subdomain condition) {
		Page<Subdomain> pageData = new Page<Subdomain>(index, Page.DEFAULTSIZE);
		pageData.setPageCount(dao.findCount(condition));
		pageData.setRows(dao.findPage(condition, pageData.getPageIndex(), pageData.getSize()));
		return pageData;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#save(net.noday.d4c.model.Domain)
	 */
	@Override
	public Long save(Subdomain obj) {
		PasswordUtil.entryptPassword(obj);
		Long id = dao.save(obj);
		return id;
	}
	
	@Override
	public Long createSubdomain(Subdomain obj) {
		Long id = save(obj);
		recordService.createRecord(obj.setId(id));
		return id;
	}
	
	public Long createDomain(Subdomain obj) {
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#update(net.noday.d4c.model.Domain)
	 */
	@Override
	public void update(Subdomain obj) {
		
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#delete(java.lang.String)
	 */
	@Override
	public void delete(Long id) {
		
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#get(java.lang.String)
	 */
	@Override
	public Subdomain get(Long id) {
		return dao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#checkSubdomain(java.lang.String)
	 */
	@Override
	public boolean checkSubdomain(String dnspodDomainId, String name) {
		return dao.has(dnspodDomainId, name);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#findDomain()
	 */
	@Override
	public List<Subdomain> findDomain() {
		return dao.findDomain();
	}
}
