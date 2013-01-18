/**
 * 
 */
package net.noday.d4c.service;

import java.util.regex.Pattern;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.noday.core.security.Loginable;
import net.noday.core.security.ShiroDbRealm.ShiroUser;
import net.noday.core.service.SecurityService;
import net.noday.d4c.dao.DomainDao;
import net.noday.d4c.dao.SubdomainDao;

/**
 * @author Administrator
 *
 */
@Service
public class LoginService implements SecurityService<Loginable<Long>> {

	@Autowired private SubdomainDao subdomainDao;
	@Autowired private DomainDao domainDao;
	
	@Override
	public Loginable<Long> findUserByLoginName(String loginName) {
		switch (getLoginType(loginName)) {
		case 1:
			return domainDao.findUserByDomain(loginName);
		case 2:
			return subdomainDao.findUserBySubdomain(loginName);
		default:
			throw new RuntimeException("域名格式不正确");
		}
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
	
	private int getLoginType(String loginName) {
		if (Pattern.matches("\\w+\\.\\w+\\.\\w+$", loginName)) {
			return 2;
		} else if (Pattern.matches("\\w+\\.\\w+$", loginName)) {
			return 1;
		}
		return 0;
	}
}
