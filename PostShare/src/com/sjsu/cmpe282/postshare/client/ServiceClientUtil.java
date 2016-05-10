/**
 * 
 */
package com.sjsu.cmpe282.postshare.client;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author ruchira
 *
 */
public class ServiceClientUtil {

	public static RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(
				new StringHttpMessageConverter());

		return restTemplate;
	}
}
