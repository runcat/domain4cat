/**
 * 
 */
package net.noday.d4c.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
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
	private Long domainId;
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
	public RecordType getRecordType() {
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
	public Long getDomainId() {
		return domainId;
	}
	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}
}
