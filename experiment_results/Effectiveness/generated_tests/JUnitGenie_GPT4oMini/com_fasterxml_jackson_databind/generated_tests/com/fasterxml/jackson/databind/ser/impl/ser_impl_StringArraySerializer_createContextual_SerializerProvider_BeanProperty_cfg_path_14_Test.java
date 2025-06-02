package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ser_impl_StringArraySerializer_createContextual_SerializerProvider_BeanProperty_cfg_path_14_Test {

    private StringArraySerializer stringArraySerializer;
    private SerializerProvider provider;
    private BeanProperty property;

    @Before
    public void setUp() {
        stringArraySerializer = new StringArraySerializer();
        provider = mock(SerializerProvider.class);
        property = mock(BeanProperty.class);
    }

    @Test(timeout = 4000)
    public void testCreateContextual_withPropertyOverrides() throws JsonMappingException {
        JsonSerializer<?> result = stringArraySerializer.createContextual(provider, property);
        // You can add assertions here based on expected behavior
        // e.g., assertNotNull(result);
    }
    
    @Test(timeout = 4000)
    public void testCreateContextual_withoutProperty() throws JsonMappingException {
        JsonSerializer<?> result = stringArraySerializer.createContextual(provider, null);
        // You can add assertions here based on expected behavior
        // e.g., assertNotNull(result);
    }

}