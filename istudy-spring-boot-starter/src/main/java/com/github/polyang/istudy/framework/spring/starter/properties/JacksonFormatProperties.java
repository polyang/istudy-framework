package com.github.polyang.istudy.framework.spring.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * jackson格式化时属性值为null的默认值配置
 * @author polyang
 * @date 2021/6/12 16:09
 **/
@ConfigurationProperties("polyang.jackson.default")
public class JacksonFormatProperties {

	/**
	 * number类型的变量为null时的默认值
	 */
	private String numberValue = "0";
	/**
	 * 字符串为null时的默认值
	 */
	private String stringValue = "";
	/**
	 * boolean为null时的默认值
	 */
	private Boolean booleanValue = false;
	
	public String getNumberValue() {
		return numberValue;
	}
	public void setNumberValue(String numberValue) {
		this.numberValue = numberValue;
	}
	public String getStringValue() {
		return stringValue;
	}
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
	public Boolean getBooleanValue() {
		return booleanValue;
	}
	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}
	
}
