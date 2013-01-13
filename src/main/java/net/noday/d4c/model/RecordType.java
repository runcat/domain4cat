/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License,  Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,  software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,  either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.noday.d4c.model;

/**
 * domain4cat RecordType
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version ,  2013-1-12
 * @since 
 */
public enum RecordType {
	A("A"), CNAME("A"), TXT("A"), NS("A"), AAAA("A"), MX("A"), URL("A"), SRV("A");
	
	private String value;
	
	RecordType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
