/**
 * 
 */
package net.noday.d4c.service.impl;

import java.io.IOException;

import net.noday.core.pagination.Page;
import net.noday.core.security.ShiroDbRealm.ShiroUser;
import net.noday.core.service.SecurityService;
import net.noday.core.utils.PasswordUtil;
import net.noday.d4c.dao.DomainDao;
import net.noday.d4c.model.Domain;

import org.apache.shiro.SecurityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
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
		try {
			Document doc = Jsoup.connect("").data("", "").userAgent("").cookie("", "").timeout(0).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.save(obj);
	}
	
	public void update(Domain obj) {
		
	}
	
	public void delete(long id) {
		
	}
	
	public Domain get(long id) {
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
	
	
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://dwz.cn/create.php")
					.data("url", "http://www.hao123.com/")
//					.userAgent("")
//					.cookie("", "")
//					.timeout(0)
					.post();
			System.out.println(doc.body().text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
