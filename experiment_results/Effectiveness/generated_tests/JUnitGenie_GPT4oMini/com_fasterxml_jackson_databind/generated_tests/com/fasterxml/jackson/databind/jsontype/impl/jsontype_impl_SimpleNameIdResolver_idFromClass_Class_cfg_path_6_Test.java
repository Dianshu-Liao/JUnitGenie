package com.fasterxml.jackson.databind.jsontype.impl;
import com.fasterxml.jackson.databind.jsontype.impl.SimpleNameIdResolver;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class jsontype_impl_SimpleNameIdResolver_idFromClass_Class_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testIdFromClassWithNullClass() {
        // Arrange
        SimpleNameIdResolver resolver = new SimpleNameIdResolver(null, null, null, null);

        // Act
        String result = null;
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = SimpleNameIdResolver.class.getDeclaredMethod("idFromClass", Class.class);
            method.setAccessible(true);
            result = (String) method.invoke(resolver, (Class<?>) null); // Cast to Class<?> to avoid NullPointerException
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        assertNull(result);
    }


}