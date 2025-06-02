package com.fasterxml.jackson.databind.cfg;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.BeanDescription;
import org.junit.Test;
import static org.junit.Assert.*;

public class cfg_DeserializerFactoryConfig__init__Deserializers_____KeyDeserializers_____BeanDeserializerModifier_____AbstractTypeResolver_____ValueInstantiators_____cfg_path_22_Test {


    @Test(timeout = 4000)
    public void testConstructorWithNullParameters() {
        Deserializers[] deserializers = null;
        KeyDeserializers[] keyDeserializers = null;
        BeanDeserializerModifier[] modifiers = null;
        AbstractTypeResolver[] atr = null;
        ValueInstantiators[] vi = null;

        try {
            DeserializerFactoryConfig config = (DeserializerFactoryConfig) DeserializerFactoryConfig.class
                    .getDeclaredConstructor(Deserializers[].class, KeyDeserializers[].class, BeanDeserializerModifier[].class, AbstractTypeResolver[].class, ValueInstantiators[].class)
                    .newInstance(deserializers, keyDeserializers, modifiers, atr, vi);
            assertNotNull(config);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }
    }


}
