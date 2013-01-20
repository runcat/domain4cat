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

import net.noday.d4c.model.DnsRecord;
import net.noday.d4c.model.Domain;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
	@SuppressWarnings("unused")
	private static final String USER_ID = "user_id";
	
	private static Map<String, String> data = new HashMap<String, String>();
	static {
		data.put(LOGIN_EMAIL, "-@gmail.com");
		data.put(LOGIN_PASSWORD, "-");
		data.put(FORMAT, "json");
		data.put(LANG, "cn");
		data.put(ERROR_ON_EMPTY, "no");
	}
	
	private static final String user_agent = "domain cat/1.0 (at1943@163.com)";
	private static final String url_version = "https://dnsapi.cn/Info.Version";
	
	public static String getApiVersion() throws IOException {
		Document doc = Jsoup.connect(url_version)
				.data(data)
				.userAgent(user_agent)
				.post();
		return doc.body().text();
	}
	
	public static final String urlDomainList = "https://dnsapi.cn/Domain.List";
	/**
	 * 获取域名列表
	 * @return
	 * @throws IOException
	 */
	public static String domainList() throws IOException {
		Document doc = Jsoup.connect(urlDomainList)
				.data(data)
				.data("type", "all")
//				.data("offset", "")
//				.data("length", "")
//				.data("group_id", "")
				.userAgent(user_agent)
				.post();
		JSONObject o = JSON.parseObject(doc.body().text());
		return o.toString();
	}
	
	private static final String url_domainInfo = "https://dnsapi.cn/Domain.Info";
	public static String domainInfo(String dnspodDomainId) {
		Document doc;
		try {
			doc = Jsoup.connect(url_domainInfo)
					.data(data)
					.data("domain_id", dnspodDomainId)
					.userAgent(user_agent)
					.post();
			JSONObject o = JSON.parseObject(doc.body().text());
			String code = o.getJSONObject("status").getString("code");
			if (StringUtils.equals(code, "1")) {
				return o.getJSONObject("domain").getString("ext_status");
			}
			throw new DnspodException(o.getJSONObject("status").getString("message"));
		} catch (IOException e) {
			throw new DnspodException(e.getMessage());
		}
	}
	
	private static final String url_domainCreate = "https://dnsapi.cn/Domain.Create";
	public static String domainCreate(Domain obj) {
		Document doc;
		try {
			doc = Jsoup.connect(url_domainCreate)
					.data(data)
					.data("domain", obj.getName())
					.userAgent(user_agent)
					.post();
			JSONObject o = JSON.parseObject(doc.body().text());
			String code = o.getJSONObject("status").getString("code");
			if (StringUtils.equals(code, "1")) {
				return o.getJSONObject("domain").getString("id");
			}
			throw new DnspodException(o.getJSONObject("status").getString("message"));
		} catch (IOException e) {
			throw new DnspodException(e.getMessage());
		}
	}
	
	private static final String url_domainRemove = "https://dnsapi.cn/Domain.Remove";
	public static void domainRemove(String dnspodDomainId) {
		Document doc;
		try {
			doc = Jsoup.connect(url_domainRemove)
					.data(data)
					.data("domain_id", dnspodDomainId)
					.userAgent(user_agent)
					.post();
			JSONObject o = JSON.parseObject(doc.body().text());
			String code = o.getJSONObject("status").getString("code");
			if (!StringUtils.equals(code, "1")) {
				throw new DnspodException(o.getJSONObject("status").getString("message"));
			}
		} catch (IOException e) {
			throw new DnspodException(e.getMessage());
		}
	}
	
	private static final String urlRecordCreate = "https://dnsapi.cn/Record.Create";
	/**
	 * 新增记录
	 * domain_id 域名ID 
	 * sub_domain - 主机记录, 如 www 
	 * record_type 记录类型，通过API记录类型获得，大写英文，比如：A 
	 * record_line 记录线路，通过API记录线路获得，中文，比如：默认 
	 * value - 记录值, 如 IP:200.200.200.200, CNAME: cname.dnspod.com., MX: mail.dnspod.com.
	 * mx {1-20} - MX优先级, 当记录类型是 MX 时有效，范围1-20 
	 * ttl {1-604800} - TTL，范围1-604800，不同等级域名最小值不同
	 */
	public static String recordCreate(DnsRecord obj) {
		Document doc;
		try {
			doc = Jsoup.connect(urlRecordCreate)
					.data(data)
					.data("domain_id", obj.getDnspodDomainId())
					.data("sub_domain", obj.getSubDomain())
					.data("record_type", obj.getRecordTypeE().name())
					.data("record_line", "默认")
					.data("value", obj.getValue())
					.data("mx", "1")
					.data("ttl", obj.getTtl()+"")
					.userAgent(user_agent)
					.post();
			JSONObject o = JSON.parseObject(doc.body().text());
			String code = o.getJSONObject("status").getString("code");
			if (StringUtils.equals(code, "1")) {
				return o.getJSONObject("record").getString("id");
			}
			throw new DnspodException(o.getJSONObject("status").getString("message"));
		} catch (IOException e) {
			throw new DnspodException(e.getMessage());
		}
	}
	
	private static final String urlRecordModify = "https://dnsapi.cn/Record.Modify";
	/**
	 * 修改记录
	 * domain_id 域名ID 
	 * record_id 记录ID 
	 * sub_domain - 主机记录, 如 www 
	 * record_type 记录类型，通过API记录类型获得，大写英文，比如：A 
	 * record_line 记录线路，通过API记录线路获得，中文，比如：默认 
	 * value - 记录值, 如 IP:200.200.200.200, CNAME: cname.dnspod.com., MX: mail.dnspod.com.
	 * mx {1-20} - MX优先级, 当记录类型是 MX 时有效，范围1-20 
	 * ttl {1-604800} - TTL，范围1-604800，不同等级域名最小值不同
	 */
	public static String recordModify(DnsRecord obj) {
		try {
			Document doc = Jsoup.connect(urlRecordModify)
					.data(data)
					.data("domain_id", obj.getDnspodDomainId())
					.data("record_id", obj.getDnspodRecordId())
					.data("sub_domain", obj.getSubDomain())
					.data("record_type", obj.getRecordTypeE().name())
					.data("record_line", "默认")
					.data("value", obj.getValue())
					.data("mx", "1")
					.data("ttl", obj.getTtl()+"")
					.userAgent(user_agent)
					.post();
			JSONObject o = JSON.parseObject(doc.body().text());
			String code = o.getJSONObject("status").getString("code");
			if (StringUtils.equals(code, "1")) {
				return o.getJSONObject("record").getString("id");
			}
			throw new DnspodException(o.getJSONObject("status").getString("message"));
		} catch (IOException e) {
			throw new DnspodException(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		domainInfo("2723144");
	}
}
