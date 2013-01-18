/**
 * 
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
 * @author Administrator
 *
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
