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

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 *
 */
@Service
public class DomainServiceImpl implements SecurityService<Domain> {

	@Autowired private DomainDao dao;
	
	public Page<Domain> findPage(int index, Domain condition) {
		Page<Domain> pageData = new Page<Domain>(index, Page.DEFAULTSIZE);
		pageData.setPageCount(dao.findCount(condition));
		pageData.setRows(dao.findPage(condition, pageData.getPageIndex(), pageData.getSize()));
		return pageData;
	}
	
	public Long save(Domain obj) {
		PasswordUtil.entryptPassword(obj);
		
		return dao.save(obj);
	}
	
	public void update(Domain obj) {
		
	}
	
	public void delete(String id) {
		
	}
	
	public Domain get(String id) {
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
	
	public boolean checkSubdomain(String domain) {
		return dao.has(domain);
	}
	
	public List<Domain> findDomain() {
		return dao.findDomain();
	}
}
