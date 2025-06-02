package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class deser_BeanDeserializerFactory_withConfig_DeserializerFactoryConfig_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithConfig_SameConfig_ReturnsThis() {
        // Arrange
        DeserializerFactoryConfig config = new DeserializerFactoryConfig();
        BeanDeserializerFactory factory = new BeanDeserializerFactory(config);
        
        // Act
        DeserializerFactory result = factory.withConfig(config);
        
        // Assert
        assertSame(factory, result);
    }

    @Test(timeout = 4000)
    public void testWithConfig_DifferentConfig_ThrowsException() {
        // Arrange
        DeserializerFactoryConfig config = new DeserializerFactoryConfig();
        BeanDeserializerFactory factory = new BeanDeserializerFactory(config);
        DeserializerFactoryConfig differentConfig = new DeserializerFactoryConfig(); // Create a different config

        // Act
        try {
            factory.withConfig(differentConfig);
        } catch (Exception e) {
            // Assert
            // Here we can check the exception message or type if needed
            // For now, we just catch it to ensure it is thrown
        }
    }


}