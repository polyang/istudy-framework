package com.github.polyang.istudy.framework.spring.starter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.polyang.istudy.framework.spring.starter.properties.JacksonFormatProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.annotation.Resource;

/**
 * 处理属性值为null时的配置处理
 * @author polyang
 * @date 2021/6/12 16:09
 **/
@Configuration
@ConditionalOnClass(MyBeanSerializerModifier.class) 
@EnableConfigurationProperties(JacksonFormatProperties.class)
public class JsonConfiguration {

	@Resource
	private JacksonFormatProperties properties;

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        MyBeanSerializerModifier modifier = new MyBeanSerializerModifier(properties.getNumberValue(), properties.getStringValue(), properties.getBooleanValue());
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(modifier));
        return objectMapper;
    }
	
}
