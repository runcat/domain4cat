/**
 * 
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
 * @author Administrator
 *
 */
@Repository
public class DnsRecordDao {

	@Autowired private JdbcTemplate jdbc;
	@Autowired private NamedParameterJdbcTemplate namedjdbc;

	public long save(DnsRecord obj) {
        String sql = "insert into dnsrecord(sub_domain,record_type,record_line,value,mx,ttl,domain_id)" +
        		" values(:subDomain,:recordTypeVal,:recordLine,:value,:mx,:ttl,:domainId)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedjdbc.update(sql, new BeanPropertySqlParameterSource(obj), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public void update(DnsRecord obj) {
		String sql = "update dnsrecord set sub_domain=:subDomain,record_type=:recordTypeVal,record_line=:recordLine" +
				",value=:value,ttl=:ttl where id=:id";
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
	
	public List<DnsRecord> findByDomainId(Long did) {
		String sql = "select * from dnsrecord a where a.domain_id=?";
		return jdbc.query(sql, new BeanPropertyRowMapper<DnsRecord>(DnsRecord.class), did);
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
