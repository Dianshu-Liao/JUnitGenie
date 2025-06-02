package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.util.AccessPattern;
import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class deser_impl_NullsConstantProvider__init__Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithNonNullValue() {
        try {
            // Arrange
            Object nonNullValue = new Object();
            Constructor<NullsConstantProvider> constructor = NullsConstantProvider.class.getDeclaredConstructor(Object.class);
            constructor.setAccessible(true);

            // Act
            NullsConstantProvider provider = constructor.newInstance(nonNullValue);

            // Assert
            assertNotNull(provider);
            assertEquals(nonNullValue, provider._nullValue);
            assertEquals(AccessPattern.CONSTANT, provider._access);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullValue() {
        try {
            // Arrange
            Object nullValue = null;
            Constructor<NullsConstantProvider> constructor = NullsConstantProvider.class.getDeclaredConstructor(Object.class);
            constructor.setAccessible(true);

            // Act
            NullsConstantProvider provider = constructor.newInstance(nullValue);

            // Assert
            assertNotNull(provider);
            assertEquals(nullValue, provider._nullValue);
            assertEquals(AccessPattern.ALWAYS_NULL, provider._access);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}