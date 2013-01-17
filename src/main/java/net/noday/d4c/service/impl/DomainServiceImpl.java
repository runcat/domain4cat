/**
 * 
 */
package net.noday.d4c.service.impl;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.core.utils.PasswordUtil;
import net.noday.d4c.dao.DomainDao;
import net.noday.d4c.model.Domain;
import net.noday.d4c.model.Subdomain;
import net.noday.d4c.service.DnsrecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *
 */
@Service
public class DomainServiceImpl {

	@Autowired private DomainDao dao;
	@Autowired private DnsrecordService recordService;
	
	public Page<Subdomain> findPage(int index, Subdomain condition) {
		Page<Subdomain> pageData = new Page<Subdomain>(index, Page.DEFAULTSIZE);
		pageData.setPageCount(dao.findCount(condition));
		pageData.setRows(dao.findPage(condition, pageData.getPageIndex(), pageData.getSize()));
		return pageData;
	}
	
	public Long save(Subdomain obj) {
		PasswordUtil.entryptPassword(obj);
		Long id = dao.save(obj);
		return id;
	}
	
	public Long createSubdomain(Subdomain obj) {
		Long id = save(obj);
		recordService.createRecord(obj.setId(id));
		return id;
	}
	
	public Long createDomain(Subdomain obj) {
		
		return null;
	}
	
	public void update(Subdomain obj) {
		
	}
	
	public void delete(Long id) {
		
	}
	
	public Subdomain get(Long id) {
		return dao.get(id);
	}
	
	public List<Domain> findDomain() {
		return dao.findDomain();
	}
}
