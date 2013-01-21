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

import net.noday.core.dnspod.Dnspod;
import net.noday.core.utils.PasswordUtil;
import net.noday.d4c.dao.DomainDao;
import net.noday.d4c.model.Domain;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * domain4cat DnsRecordController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
@Service
public class DomainServiceImpl {
	
	private static final Logger log = Logger.getLogger(DomainServiceImpl.class);

	@Autowired private DomainDao dao;
	
	public Long save(Domain obj) {
		PasswordUtil.entryptPassword(obj);
		Long id = dao.save(obj);
		return id;
	}
	
	public Long createDomain(Domain obj) {
		obj.setStatus(2);
		String domainId = Dnspod.domainCreate(obj);
		try {
			return save(obj.setDnspodDomainId(domainId));
		} catch (RuntimeException e) {
			log.error(String.format("系统保存域名失败[域名:%s,dnspodDomainId:%s]", obj.getName(), obj.getDnspodDomainId()), e);
			Dnspod.domainRemove(domainId);
			throw e;
		}
	}
	
	public String updateStatus(String dnspodDomainId) {
		String ext_status = Dnspod.domainInfo(dnspodDomainId);
		if (StringUtils.isBlank(ext_status)) {
			dao.updateDomainStatus(dnspodDomainId);
		}
		return ext_status;
	}
	
	public void update(Domain obj) {
		
	}
	
	public void delete(Long id) {
		
	}
	
	public Domain get(Long id) {
		return dao.get(id);
	}
	
	public List<Domain> findDomain() {
		return dao.findDomain();
	}
}
