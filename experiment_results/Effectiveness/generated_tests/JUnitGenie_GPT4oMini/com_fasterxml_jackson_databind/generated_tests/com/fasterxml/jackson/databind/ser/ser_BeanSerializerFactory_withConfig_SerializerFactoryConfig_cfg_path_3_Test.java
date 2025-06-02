package com.fasterxml.jackson.databind.ser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class ser_BeanSerializerFactory_withConfig_SerializerFactoryConfig_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWithConfig_SameConfig_ReturnsSelf() {
        // Arrange
        SerializerFactoryConfig config = new SerializerFactoryConfig();
        BeanSerializerFactory factory = new BeanSerializerFactory(config);

        // Act
        SerializerFactory result = factory.withConfig(config);

        // Assert
        assertSame(factory, result);
    }

    @Test(timeout = 4000)
    public void testWithConfig_DifferentSubtype_ThrowsIllegalStateException() {
        // Arrange
        SerializerFactoryConfig config = new SerializerFactoryConfig();
        // Create a subclass of BeanSerializerFactory to invoke the exception
        BeanSerializerFactory factory = new BeanSerializerFactory(config) {
            // This subclass intentionally does not override withAdditionalSerializers
        };

        try {
            // Act
            factory.withConfig(new SerializerFactoryConfig());
        } catch (IllegalStateException e) {
            // Assert
            assert e.getMessage().contains("Subtype of BeanSerializerFactory");
            return; // Test passes if exception is thrown
        }
        
        // If we reach here, it means the exception was not thrown
        throw new AssertionError("Expected IllegalStateException not thrown");
    }

}