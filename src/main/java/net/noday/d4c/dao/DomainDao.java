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

import net.noday.d4c.model.Domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 * cat SecurityDao
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-24
 * @since 
 */
@Repository
public class DomainDao {

	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public long save(Domain obj) {
        String sql = "insert into domain(name,password,salt,pid) values(:name,:password,:salt,:pid)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(obj), keyHolder);
        return keyHolder.getKey().longValue();
	}
	
	public Domain findUserByDomain(String domain) {
		String sql = "select * from domain d where d.name=? limit 1";
		Domain u = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Domain>(Domain.class), domain);
		return u;
	}
	
	public List<Domain> findPage(Domain condition, int pIndex, int pSize) {
		StringBuffer sql = new StringBuffer("select * from domain d where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		sql.append(" order by d.regist_time desc")
			.append(" limit ").append((pIndex - 1) * pSize)
			.append(",").append(pSize);
		List<Domain> list = namedJdbcTemplate.query(sql.toString(), ps, new BeanPropertyRowMapper<Domain>(Domain.class));
		return list;
	}
	public int findCount(Domain condition) {
		StringBuffer sql = new StringBuffer("select count(d.id) from domain d where 1=1");
		SqlParameterSource ps = null;
		if (condition != null) {
			ps = new BeanPropertySqlParameterSource(condition);
			sql.append(toConditionSql(condition));
		}
		return namedJdbcTemplate.queryForInt(sql.toString(), ps);
	}
	
	private String toConditionSql(Domain d) {
		StringBuffer s = new StringBuffer();
		if (StringUtils.isNotBlank(d.getEmail())) {
			s.append(" and u.email like %:email%");
		}
		if (StringUtils.isNotBlank(d.getName())) {
			s.append(" and u.name like %:name%");
		}
		return s.toString();
	}
	
	///---------------------
	protected Domain safeQueryForObject(String sql, RowMapper<Domain> rowMapper, Object... args) {
		List<Domain> results = jdbcTemplate.query(sql, args, new RowMapperResultSetExtractor<Domain>(rowMapper, 1));
		int size = (results != null ? results.size() : 0);
		if (results.size() > 1) {
			throw new IncorrectResultSizeDataAccessException(1, size);
		}
		return results.iterator().next();
	}
}
