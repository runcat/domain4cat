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
package net.noday.d4c.dao;

import java.util.List;

import net.noday.d4c.model.DnsRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat DnsrecordDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-1-9
 * @since 
 */
@Repository
public class DnsrecordDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedjdbc;

	public long save(DnsRecord obj) {
        String sql = "insert into dnsrecord(id,sub_domain,record_type,record_line,value,mx,ttl,subdomain_id,dnspod_record_id,dnspod_domain_id)" +
        		" values(:id,:subDomain,:recordType,:recordLine,:value,:mx,:ttl,:subdomainId,:dnspodRecordId,:dnspodDomainId)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedjdbc.update(sql, new BeanPropertySqlParameterSource(obj), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public void update(DnsRecord obj) {
		String sql = "update dnsrecord set record_type=:recordType,value=:value,ttl=:ttl where id=:id";
		namedjdbc.update(sql, new BeanPropertySqlParameterSource(obj));
	}
	
	public void delete(Long id) {
		String sql = "delete dnsrecord where id=?";
		jdbc.update(sql, id);
	}
	
	public DnsRecord get(Long id) {
		String sql = "select * from dnsrecord a where a.id=?";
		DnsRecord r = jdbc.queryForObject(sql, new BeanPropertyRowMapper<DnsRecord>(DnsRecord.class), id);
		return r;
	}
	
	public List<DnsRecord> findBySubdomainId(Long subdomainId) {
		String sql = "select * from dnsrecord a where a.subdomain_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<DnsRecord>(DnsRecord.class), subdomainId);
	}
	
	public List<DnsRecord> findPage(DnsRecord condition, int pIndex, int pSize) {
		StringBuffer sql = new StringBuffer("select * from dnsrecord r where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		sql.append(" order by r.record_type")
			.append(" limit ").append((pIndex - 1) * pSize)
			.append(",").append(pSize);
		List<DnsRecord> list = namedjdbc.query(sql.toString(), ps, new BeanPropertyRowMapper<DnsRecord>(DnsRecord.class));
		return list;
	}
	public int findCount(DnsRecord condition) {
		StringBuffer sql = new StringBuffer("select count(r.id) from dnsrecord r where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		return namedjdbc.queryForInt(sql.toString(), ps);
	}
	
	private String toConditionSql(DnsRecord d) {
		StringBuffer s = new StringBuffer();
//		if (StringUtils.isNotBlank(d.getEmail())) {
//			s.append(" and u.email like %:email%");
//		}
//		if (StringUtils.isNotBlank(d.getName())) {
//			s.append(" and u.name like %:name%");
//		}
		return s.toString();
	}
}
