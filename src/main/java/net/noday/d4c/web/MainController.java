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
package net.noday.d4c.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

//import net.noday.cat.model.Duoshuo;
//import net.noday.cat.service.ArticleService;
import net.noday.core.model.User;
import net.noday.core.utils.Captcha;
import net.noday.core.web.BaseController;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * cat MainController
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-11-24
 * @since 
 */
@Controller
public class MainController extends BaseController {

//	@Autowired private ArticleService articleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		return page(1, model);
	}
	
	@RequestMapping(value = "/p/{index}", method = RequestMethod.GET)
	public String page(@PathVariable("index") int index, Model model) {
//		model.addAttribute(articleService.listPage(index));
		return "index";
	}
	

	/**
	 * 注册页
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String preRegist() {
		
		return "user/regist";
	}
	/**
	 * 注册提交
	 * @param u
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String regist(User u) {
		
		return "user/regist-success";
	}
	
	@RequestMapping(value = "/login")
	public String preLogin() {
		
		return "user/login";
	}
	
//	@Deprecated //如果有这个方法，登录失败后就不会回到登录页
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String login() {
//		
//		return "redirect:/";
//	}
	
	@RequestMapping(value = "/captcha", method = RequestMethod.GET) @ResponseBody
	public byte[] loginCaptcha() throws IOException {
		return FileCopyUtils.copyToByteArray(Captcha.captchInputStream(getSession(), 60, 30));
	}
	
}
