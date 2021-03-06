package com.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {

	private int maximum;
	private int minimum;
	/**
	 * @param maximum the maximum to set
	 */
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	/**
	 * @param minimum the minimum to set
	 */
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	/**
	 * @return the maximum
	 */
	public int getMaximum() {
		return maximum;
	}
	/**
	 * @return the minimum
	 */
	public int getMinimum() {
		return minimum;
	}
	
	
	
}
