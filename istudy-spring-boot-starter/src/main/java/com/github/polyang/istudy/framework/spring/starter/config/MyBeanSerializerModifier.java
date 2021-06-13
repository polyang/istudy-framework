package com.github.polyang.istudy.framework.spring.starter.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * 处理属性值为null时赋予默认值
 * @author polyang
 * @date 2021/6/12 15:58
 **/
public class MyBeanSerializerModifier extends BeanSerializerModifier {

    private String numberValue;
    private String stringValue;
    private Boolean booleanValue;

    public MyBeanSerializerModifier(String numberValue, String stringValue, Boolean booleanValue) {
        super();
        this.numberValue = numberValue;
        this.stringValue = stringValue;
        this.booleanValue = booleanValue;
    }

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                     List<BeanPropertyWriter> beanProperties) {
        //循环所有的beanPropertyWriter
        for (int i = 0; i < beanProperties.size(); i++) {
            BeanPropertyWriter writer = beanProperties.get(i);
            if(writer.hasNullSerializer()) {
                continue;
            }
            JavaType type = writer.getType();
            Class<?> clazz = type.getClass();
            if(type.isTypeOrSubTypeOf(Number.class)) {
                writer.assignNullSerializer(numberJsonSerializers);
            } else if(type.isTypeOrSubTypeOf(Boolean.class)) {
                writer.assignNullSerializer(booleanJsonSerializers);
            } else if(type.isTypeOrSubTypeOf(Character.class)) {
                writer.assignNullSerializer(stringJsonSerializers);
            } else if(type.isTypeOrSubTypeOf(String.class)) {
                writer.assignNullSerializer(stringJsonSerializers);
            } else if(type.isArrayType() || clazz.isArray()
                    || type.isTypeOrSubTypeOf(List.class)) {
                writer.assignNullSerializer(arrayJsonSerializers);
            } else if(type.isTypeOrSubTypeOf(Date.class) || type.isTypeOrSubTypeOf(java.sql.Date.class)
                    || type.isTypeOrSubTypeOf(LocalDate.class) || type.isTypeOrSubTypeOf(LocalDateTime.class)){
                writer.assignNullSerializer(stringJsonSerializers);
            } else {
                writer.assignNullSerializer(objectJsonSerializers);
            }
        }
        return super.changeProperties(config, beanDesc, beanProperties);
    }

    private JsonSerializer<Object> numberJsonSerializers = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeNumber(numberValue);
        }
    };

    private JsonSerializer<Object> stringJsonSerializers = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(stringValue);
        }
    };

    private JsonSerializer<Object> booleanJsonSerializers = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeObject(booleanValue);
        }
    };
    private JsonSerializer<Object> arrayJsonSerializers = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartArray();
            gen.writeEndArray();
        }
    };
    private JsonSerializer<Object> objectJsonSerializers = new JsonSerializer<Object>() {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeEndObject();
        }
    };

}
