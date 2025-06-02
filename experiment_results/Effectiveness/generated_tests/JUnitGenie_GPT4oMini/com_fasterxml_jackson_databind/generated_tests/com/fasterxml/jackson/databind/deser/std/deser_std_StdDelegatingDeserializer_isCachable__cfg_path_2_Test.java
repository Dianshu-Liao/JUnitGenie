package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class deser_std_StdDelegatingDeserializer_isCachable__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsCachableWhenDelegateDeserializerIsNull() {
        // Use a generic type for the StdDelegatingDeserializer
        StdDelegatingDeserializer<Object> deserializer = new StdDelegatingDeserializer<Object>(null, TypeFactory.defaultInstance().constructType(Object.class), null);
        boolean result = deserializer.isCachable();
        assertTrue("Expected isCachable to return false when _delegateDeserializer is null", !result);
    }

    @Test(timeout = 4000)
    public void testIsCachableWhenDelegateDeserializerIsNotNull() {
        JsonDeserializer<Object> mockDeserializer = new JsonDeserializer<Object>() {
            @Override
            public Object deserialize(JsonParser p, DeserializationContext ctxt) {
                return null; // Implementing the abstract method
            }

            @Override
            public boolean isCachable() {
                return true; // Simulating a cachable deserializer
            }
        };
        
        // Use a generic type for the StdDelegatingDeserializer
        StdDelegatingDeserializer<Object> deserializer = new StdDelegatingDeserializer<Object>(null, TypeFactory.defaultInstance().constructType(Object.class), mockDeserializer);
        boolean result = deserializer.isCachable();
        assertTrue("Expected isCachable to return true when _delegateDeserializer is not null and cachable", result);
    }

}