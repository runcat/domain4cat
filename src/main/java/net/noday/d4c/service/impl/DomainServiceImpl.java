/**
 * 
 */
package net.noday.d4c.service.impl;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.core.security.ShiroDbRealm.ShiroUser;
import net.noday.core.service.SecurityService;
import net.noday.core.utils.PasswordUtil;
import net.noday.d4c.dao.DomainDao;
import net.noday.d4c.model.Domain;
import net.noday.d4c.service.DomainService;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *
 */
@Service
public class DomainServiceImpl implements SecurityService<Domain>, DomainService {

	@Autowired private DomainDao dao;
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#findPage(int, net.noday.d4c.model.Domain)
	 */
	@Override
	public Page<Domain> findPage(int index, Domain condition) {
		Page<Domain> pageData = new Page<Domain>(index, Page.DEFAULTSIZE);
		pageData.setPageCount(dao.findCount(condition));
		pageData.setRows(dao.findPage(condition, pageData.getPageIndex(), pageData.getSize()));
		return pageData;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#save(net.noday.d4c.model.Domain)
	 */
	@Override
	public Long save(Domain obj) {
		PasswordUtil.entryptPassword(obj);
		
		return dao.save(obj);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#update(net.noday.d4c.model.Domain)
	 */
	@Override
	public void update(Domain obj) {
		
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
	public Domain get(Long id) {
		return null;
	}

	@Override
	public Domain findUserByLoginName(String loginName) {
		Domain u = dao.findUserByDomain(loginName);
		return u;
	}

	@Override
	public Domain getUserByToken(String token) {
		return null;
	}

	@Override
	public boolean checkLogin(Domain u) {
		return false;
	}

	@Override
	public boolean isSupervisor(Long id) {
		return id == 1;
	}

	@Override
	public String getCurrentUserName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#checkSubdomain(java.lang.String)
	 */
	@Override
	public boolean checkSubdomain(Long id, String subdomain) {
		return dao.has(id, subdomain);
	}
	
	/* (non-Javadoc)
	 * @see net.noday.d4c.service.impl.DomainService#findDomain()
	 */
	@Override
	public List<Domain> findDomain() {
		return dao.findDomain();
	}
}
