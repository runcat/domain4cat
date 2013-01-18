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
package net.noday.d4c.model;

import java.io.Serializable;
import java.util.Date;

import net.noday.core.security.Loginable;
import net.noday.core.security.Registable;

/**
 * domain4cat Subdomain
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
public class Subdomain implements Registable, Loginable<Long>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String fullname;
	private String password;
	private String salt;
	private String email;
	private int status;
	private String dnspodDomainId;
	private Date registTime;
	private String registIp;
	private Date lastTime;
	private String lastIp;
	private String description;

	@Override
	public Long getId() {
		return id;
	}
	public Subdomain setId(Long id) {
		this.id = id;
		return this;
	}
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getSalt() {
		return salt;
	}
	@Override
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDnspodDomainId() {
		return dnspodDomainId;
	}
	public void setDnspodDomainId(String dnspodDomainId) {
		this.dnspodDomainId = dnspodDomainId;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public String getRegistIp() {
		return registIp;
	}
	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String getPlainPassword() {
		return password;
	}
	public void setPlainPassword(String plainPassword) {
		this.password = plainPassword;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	@Override
	public String getLoginName() {
		return fullname;
	}
	@Override
	public String getRole() {
		return "subdomain";
	}
}
