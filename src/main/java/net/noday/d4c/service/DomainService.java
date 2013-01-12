package net.noday.d4c.service;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.d4c.model.Domain;

public interface DomainService {

	public abstract Page<Domain> findPage(int index, Domain condition);

	public abstract Long save(Domain obj);

	public abstract void update(Domain obj);

	public abstract void delete(Long id);

	public abstract Domain get(Long id);

	public abstract boolean checkSubdomain(Long id, String subdomain);

	public abstract List<Domain> findDomain();

}