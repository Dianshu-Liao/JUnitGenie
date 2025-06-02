package com.fasterxml.jackson.databind.deser;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import static org.junit.Assert.*;

public class deser_BeanDeserializerFactory_withConfig_DeserializerFactoryConfig_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithConfigThrowsExceptionWhenNotOverridden() {
        // Arrange
        DeserializerFactoryConfig config = new DeserializerFactoryConfig();
        BeanDeserializerFactory factory = new BeanDeserializerFactory(config); // Pass config to constructor

        // Act & Assert
        try {
            factory.withConfig(config);
            fail("Expected an exception to be thrown due to not overriding the method.");
        } catch (Exception e) {
            // Verify that the exception is of the expected type or contains the expected message
            assertTrue(e.getMessage().contains("must override"));
        }
    }

    @Test(timeout = 4000)
    public void testWithConfigReturnsNewInstanceWhenConfigIsDifferent() {
        // Arrange
        DeserializerFactoryConfig config1 = new DeserializerFactoryConfig();
        DeserializerFactoryConfig config2 = new DeserializerFactoryConfig();
        BeanDeserializerFactory factory = new BeanDeserializerFactory(config1); // Pass config to constructor

        // Act
        BeanDeserializerFactory result = (BeanDeserializerFactory) factory.withConfig(config2); // Cast to BeanDeserializerFactory

        // Assert
        assertNotNull(result);
        assertNotSame(factory, result);
    }


}