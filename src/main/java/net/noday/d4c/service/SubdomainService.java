package net.noday.d4c.service;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.d4c.model.Subdomain;

public interface SubdomainService {

	public abstract Page<Subdomain> findPage(int index, Subdomain condition);

	public abstract Long save(Subdomain obj);

	public abstract void update(Subdomain obj);

	public abstract void delete(Long id);

	public abstract Subdomain get(Long id);

	public abstract boolean checkSubdomain(Long id, String subdomain);

	public abstract List<Subdomain> findDomain();

	Long createSubdomain(Subdomain obj);

}