package com.fasterxml.jackson.databind.ser;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_BeanSerializerFactory_withConfig_SerializerFactoryConfig_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithConfigThrowsIllegalStateException() {
        // Arrange
        SerializerFactoryConfig config = new SerializerFactoryConfig();
        BeanSerializerFactory factory = new BeanSerializerFactory(config);
        
        // Act & Assert
        try {
            factory.withConfig(config);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Subtype of BeanSerializerFactory (" + factory.getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': cannot instantiate subtype with additional serializer definitions", e.getMessage());
        }
    }


}