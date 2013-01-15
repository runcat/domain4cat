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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.noday.core.dnspod.Dnspod;
import net.noday.core.pagination.Page;
import net.noday.d4c.dao.DnsRecordDao;
import net.noday.d4c.model.DnsRecord;
import net.noday.d4c.model.Domain;
import net.noday.d4c.model.RecordType;
import net.noday.d4c.service.DnsRecordService;
import net.noday.d4c.service.DomainService;

/**
 * domain4cat DnsRecordServiceImpl
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
@Service
public class DnsRecordServiceImpl implements DnsRecordService {

	@Autowired private DnsRecordDao dao;
	@Autowired private DomainService domainService;
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DnsRecordService#save(net.noday.d4c.model.DnsRecord)
	 */
	@Override
	public Long save(DnsRecord obj) {
		return dao.save(obj);
	}
	
	@Override
	public void createRecord(Domain obj) {
		DnsRecord r = new DnsRecord();
		r.setDomainId(obj.getPid());
		r.setOwnerId(obj.getId());
		r.setSubDomain(obj.getName());
		r.setRecordType(RecordType.CNAME);
		r.setValue("www.runcat.org.");
		r.setMx("-");
		r.setTtl(600);
		String recordId = Dnspod.recordCreate(r);
		try {
			r.setId(Long.parseLong(recordId));
			save(r);
		} catch (RuntimeException e) {
			// TODO 删除dnspod中的记录
			throw e;
		}
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DnsRecordService#update(net.noday.d4c.model.DnsRecord)
	 */
	@Override
	public void update(DnsRecord obj) {
		dao.update(obj);
		DnsRecord r = get(obj.getId());
		Dnspod.recordModify(r);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DnsRecordService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DnsRecordService#get(java.lang.Long)
	 */
	@Override
	public DnsRecord get(Long id) {
		return dao.get(id);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DnsRecordService#findPage(int, net.noday.d4c.model.DnsRecord)
	 */
	@Override
	public Page<DnsRecord> findPage(int index, DnsRecord condition) {
		Page<DnsRecord> page = new Page<DnsRecord>(index, Page.DEFAULTSIZE);
		page.setPageCount(dao.findCount(condition));
		page.setRows(dao.findPage(condition, page.getPageIndex(), page.getPageCount()));
		return page;
	}
	
	@Override
	public List<DnsRecord> findByDomainId(Long id) {
		return dao.findByOwnerId(id);
	}
}
