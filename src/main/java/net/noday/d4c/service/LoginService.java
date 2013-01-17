/**
 * 
 */
package net.noday.d4c.service;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.noday.core.security.Loginable;
import net.noday.core.security.ShiroDbRealm.ShiroUser;
import net.noday.core.service.SecurityService;
import net.noday.d4c.dao.SubdomainDao;
import net.noday.d4c.model.Subdomain;

/**
 * @author Administrator
 *
 */
@Service
public class LoginService implements SecurityService<Loginable<Long>> {

	@Autowired private SubdomainDao dao;
	
	@Override
	public Loginable<Long> findUserByLoginName(String loginName) {
		Subdomain u = dao.findUserByDomain(loginName);
		return u;
	}

	@Override
	public Loginable<Long> getUserByToken(String token) {
		return null;
	}

	@Override
	public boolean checkLogin(Loginable<Long> u) {
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
}
