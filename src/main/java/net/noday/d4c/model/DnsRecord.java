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

/**
 * domain4cat DnsRecord
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
public class DnsRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String subDomain;
	private RecordType recordType;
	private int recordLine;
	private String value;
	private String mx;
	private int ttl;
	private boolean stopable;
	private Long subdomainId;
	private String dnspodRecordId;
	private String dnspodDomainId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubDomain() {
		return subDomain;
	}
	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}
	public int getRecordType() {
		return recordType.ordinal();
	}
	public void setRecordType(int ordinal) {
		this.recordType = RecordType.valueOf(ordinal);
	}
	public RecordType getRecordTypeE() {
		return recordType;
	}
	public void setRecordType(RecordType recordType) {
		this.recordType = recordType;
	}
	public int getRecordLine() {
		return recordLine;
	}
	public void setRecordLine(int recordLine) {
		this.recordLine = recordLine;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMx() {
		return mx;
	}
	public void setMx(String mx) {
		this.mx = mx;
	}
	public int getTtl() {
		return ttl;
	}
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
	public boolean isStopable() {
		return stopable;
	}
	public void setStopable(boolean stopable) {
		this.stopable = stopable;
	}
	public Long getSubdomainId() {
		return subdomainId;
	}
	public void setSubdomainId(Long subdomainId) {
		this.subdomainId = subdomainId;
	}
	public String getDnspodRecordId() {
		return dnspodRecordId;
	}
	public void setDnspodRecordId(String dnspodRecordId) {
		this.dnspodRecordId = dnspodRecordId;
	}
	public String getDnspodDomainId() {
		return dnspodDomainId;
	}
	public void setDnspodDomainId(String dnspodDomainId) {
		this.dnspodDomainId = dnspodDomainId;
	}
}
