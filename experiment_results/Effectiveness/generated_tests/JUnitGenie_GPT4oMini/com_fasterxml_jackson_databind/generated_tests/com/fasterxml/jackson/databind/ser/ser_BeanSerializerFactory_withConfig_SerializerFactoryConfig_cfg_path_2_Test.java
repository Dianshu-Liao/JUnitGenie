package com.fasterxml.jackson.databind.ser;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_BeanSerializerFactory_withConfig_SerializerFactoryConfig_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithConfig_ValidConfig() {
        // Set up the SerializerFactoryConfig with necessary properties
        SerializerFactoryConfig validConfig = new SerializerFactoryConfig();
        
        // Create an instance of BeanSerializerFactory
        BeanSerializerFactory factory = new BeanSerializerFactory(validConfig);
        
        // Invoke the method under test
        SerializerFactory result = factory.withConfig(validConfig);
        
        // Verify the result is the same instance
        assertSame(factory, result);
    }

    @Test(timeout = 4000)
    public void testWithConfig_InvalidSubtype() {
        // Set up a config (not using directly required properties for throw case)
        SerializerFactoryConfig validConfig = new SerializerFactoryConfig();
        
        // Create a subclass of BeanSerializerFactory to test exception throwing
        BeanSerializerFactory factory = new BeanSerializerFactory(validConfig) {
            @Override
            public SerializerFactory withConfig(SerializerFactoryConfig config) {
                return super.withConfig(config);
            }
        };

        // Verify that the exception is thrown
        try {
            factory.withConfig(validConfig);
            fail("Expected an IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Subtype of BeanSerializerFactory (" + factory.getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions", e.getMessage());
        }
    }

}