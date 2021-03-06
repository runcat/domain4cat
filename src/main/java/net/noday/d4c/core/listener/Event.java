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
package net.noday.d4c.core.listener;

import org.springframework.context.ApplicationEvent;

/**
 * domain4cat Event
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-10-17
 * @since 
 */
public class Event extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param source
	 */
	public Event(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

}
