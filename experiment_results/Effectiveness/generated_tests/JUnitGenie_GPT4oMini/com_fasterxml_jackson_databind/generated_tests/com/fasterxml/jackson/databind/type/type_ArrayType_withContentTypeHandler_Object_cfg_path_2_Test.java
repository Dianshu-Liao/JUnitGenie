package com.fasterxml.jackson.databind.type;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.TypeBindings;

public class type_ArrayType_withContentTypeHandler_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWithContentTypeHandler() {
        try {
            // Create an instance of JavaType
            JavaType mockJavaType = mock(JavaType.class);
            Object mockTypeHandler = new Object();
            // Stubbing the getTypeHandler method to return the same type handler as expected
            when(mockJavaType.getTypeHandler()).thenReturn(mockTypeHandler);

            // Creating an instance of ArrayType using reflection to access the protected constructor
            ArrayType arrayTypeInstance = (ArrayType) ArrayType.class.getDeclaredConstructor(JavaType.class, TypeBindings.class, Object.class, Object.class, Object.class, boolean.class)
                .newInstance(mockJavaType, null, null, null, null, false);

            // Call the focal method with the same type handler
            ArrayType result = arrayTypeInstance.withContentTypeHandler(mockTypeHandler);

            // Verify the result is the same instance of ArrayType
            assertSame(arrayTypeInstance, result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}