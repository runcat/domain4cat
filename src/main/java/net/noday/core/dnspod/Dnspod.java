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
package net.noday.core.dnspod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * cat AppStartupException
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-17
 * @since 
 */
public class Dnspod {

	//用户帐号，必选
	private static final String LOGIN_EMAIL = "login_email";
	//用户密码，必选
	private static final String LOGIN_PASSWORD = "login_password";
	//{json,xml} 返回的数据格式，可选，默认为xml，建议用json
	private static final String FORMAT = "format";
	//{en,cn} 返回的错误语言，可选，默认为en，建议用cn
	private static final String LANG = "lang";
	//{yes,no} 没有数据时是否返回错误，可选，默认为yes，建议用no
	private static final String ERROR_ON_EMPTY = "error_on_empty";
	//用户的ID，可选，仅代理接口需要， 用户接口不需要提交此参数
	private static final String USER_ID = "user_id";
	
	private static Map<String, String> data = new HashMap<String, String>();
	static {
		data.put(LOGIN_EMAIL, "yaoniming2000@gmail.com");
		data.put(LOGIN_PASSWORD, "yaoniming");
		data.put(FORMAT, "json");
		data.put(LANG, "cn");
		data.put(ERROR_ON_EMPTY, "no");
	}
	
	private static final String user_agent = "domain cat/1.0 (at1943@163.com)";
	private static final String url_version = "https://dnsapi.cn/Info.Version";
	private static final String url_domainCreate = "https://dnsapi.cn/Domain.Create";
	
	public static String getApiVersion() throws IOException {
		Document doc = Jsoup.connect(url_version)
				.data(data)
				.userAgent(user_agent)
				.post();
		return doc.body().text();
	}
	public static String domainCreate(String domain) throws IOException {
		Document doc = Jsoup.connect(url_domainCreate)
				.data(data)
				.data("domain", domain)
				.userAgent(user_agent)
				.post();
		return doc.body().text();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(domainCreate("baoliao.info"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
