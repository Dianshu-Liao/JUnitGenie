package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.util.AccessPattern;
import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class deser_impl_NullsConstantProvider__init__Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNullValue() {
        try {
            // Accessing the protected constructor using reflection
            Constructor<NullsConstantProvider> constructor = NullsConstantProvider.class.getDeclaredConstructor(Object.class);
            constructor.setAccessible(true);
            NullsConstantProvider provider = constructor.newInstance(null);

            // Validate the _nullValue field
            assertNotNull(provider);
            assertEquals(null, provider.getClass().getDeclaredField("_nullValue").get(provider));
            assertEquals(AccessPattern.ALWAYS_NULL, provider.getClass().getDeclaredField("_access").get(provider));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNonNullValue() {
        try {
            // Accessing the protected constructor using reflection
            Constructor<NullsConstantProvider> constructor = NullsConstantProvider.class.getDeclaredConstructor(Object.class);
            constructor.setAccessible(true);
            Object nonNullValue = new Object();
            NullsConstantProvider provider = constructor.newInstance(nonNullValue);

            // Validate the _nullValue field
            assertNotNull(provider);
            assertEquals(nonNullValue, provider.getClass().getDeclaredField("_nullValue").get(provider));
            assertEquals(AccessPattern.CONSTANT, provider.getClass().getDeclaredField("_access").get(provider));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}