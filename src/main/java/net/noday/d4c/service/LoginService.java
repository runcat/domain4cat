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
 * domain4cat LoginService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
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
