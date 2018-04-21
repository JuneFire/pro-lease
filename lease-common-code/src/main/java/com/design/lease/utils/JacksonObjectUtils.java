package com.design.lease.utils;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class JacksonObjectUtils implements Serializable{

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    }

    public static ObjectMapper getMapper() {
        if(mapper == null){
            mapper = new ObjectMapper();
        }
        return mapper;
    }

    public static String jacksonObjectToSerializable(Object value){
        try {
            return getMapper().writeValueAsString(value);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
