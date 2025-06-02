package com.fasterxml.jackson.databind.cfg;
import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Constructor;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;

public class cfg_DeserializerFactoryConfig__init__Deserializers_____KeyDeserializers_____BeanDeserializerModifier_____AbstractTypeResolver_____ValueInstantiators_____cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testDeserializerFactoryConfig() {
        Deserializers[] deserializersArray = null; // Testing with null
        KeyDeserializers[] keyDeserializersArray = new KeyDeserializers[0]; // Changed to empty array
        BeanDeserializerModifier[] modifiersArray = null; // Testing with null
        AbstractTypeResolver[] atrArray = null; // Testing with null
        ValueInstantiators[] viArray = null; // Testing with null
        
        try {
            // Access the protected constructor via reflection
            Constructor<DeserializerFactoryConfig> constructor = DeserializerFactoryConfig.class.getDeclaredConstructor(
                Deserializers[].class, 
                KeyDeserializers[].class, 
                BeanDeserializerModifier[].class, 
                AbstractTypeResolver[].class, 
                ValueInstantiators[].class
            );
            constructor.setAccessible(true); // make it accessible
            
            // Create an instance of DeserializerFactoryConfig using the constructor
            DeserializerFactoryConfig config = constructor.newInstance(
                deserializersArray,
                keyDeserializersArray,
                modifiersArray,
                atrArray,
                viArray
            );
            
            // Asserting the expected values
            assertNotNull(config);
            assertArrayEquals(new Deserializers[0], config._additionalDeserializers);
            assertArrayEquals(new KeyDeserializers[0], config._additionalKeyDeserializers); // Changed to empty array
            assertArrayEquals(new BeanDeserializerModifier[0], config._modifiers);
            assertArrayEquals(new AbstractTypeResolver[0], config._abstractTypeResolvers);
            assertArrayEquals(new ValueInstantiators[0], config._valueInstantiators);
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }


}