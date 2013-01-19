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
package net.noday.d4c.service;

import java.util.List;

import net.noday.core.pagination.Page;
import net.noday.d4c.model.Subdomain;

/**
 * domain4cat SubdomainService
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2013-1-9
 * @since 
 */
public interface SubdomainService {

	public abstract Page<Subdomain> findPage(int index, Subdomain condition);

	public abstract Long save(Subdomain obj);

	public abstract void update(Subdomain obj);

	public abstract void delete(Long id);

	public abstract Subdomain get(Long id);

	Long createSubdomain(Subdomain obj);

	boolean checkSubdomain(String dnspodDomainId, String name);

	/**
	 * @param dnspodDomainId
	 * @return
	 */
	List<Subdomain> findSubdomain(String dnspodDomainId);

}