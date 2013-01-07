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
package net.noday.core.exception;

/**
 * cat AppStartupException
 *
 * @author <a href="http://www.noday.net">Noday</a>
 * @version , 2012-12-17
 * @since 
 */
public class AppStartupException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppStartupException() {
		super();
	}
	
	public AppStartupException(String message) {
		super(message);
	}
	
	public AppStartupException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public AppStartupException(Throwable cause) {
		super(cause);
	}
}
