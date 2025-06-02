package com.fasterxml.jackson.databind.cfg;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.*;

public class cfg_DeserializerFactoryConfig__init__Deserializers_____KeyDeserializers_____BeanDeserializerModifier_____AbstractTypeResolver_____ValueInstantiators_____cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testConstructor() {
        // Prepare test parameters
        Deserializers[] additionalDeserializers = new Deserializers[]{};
        KeyDeserializers[] additionalKeyDeserializers = new KeyDeserializers[]{};
        BeanDeserializerModifier[] modifiers = new BeanDeserializerModifier[]{};
        AbstractTypeResolver[] atr = null; // Testing with the null case
        ValueInstantiators[] vi = null; // Testing with the null case

        try {
            // Use reflection to access the protected constructor
            Constructor<DeserializerFactoryConfig> constructor = DeserializerFactoryConfig.class.getDeclaredConstructor(
                Deserializers[].class,
                KeyDeserializers[].class,
                BeanDeserializerModifier[].class,
                AbstractTypeResolver[].class,
                ValueInstantiators[].class
            );

            constructor.setAccessible(true); // Make the constructor accessible

            // Create an instance of DeserializerFactoryConfig
            DeserializerFactoryConfig config = constructor.newInstance(
                additionalDeserializers, 
                additionalKeyDeserializers, 
                modifiers, 
                atr, 
                vi
            );

            // Assertions to verify the internal state
            assertNotNull(config);
            assertNotNull(config._additionalDeserializers); // Should not be null
            assertNotNull(config._additionalKeyDeserializers); // Should not be null
            assertNotNull(config._modifiers); // Should not be null
            assertTrue(config._abstractTypeResolvers.length == 0); // Should be initialized to NO_ABSTRACT_TYPE_RESOLVERS
            assertTrue(config._valueInstantiators.length == 0); // Should be initialized to NO_VALUE_INSTANTIATORS

        } catch (Exception e) {
            e.printStackTrace(); // Handle exception, if any
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }

}