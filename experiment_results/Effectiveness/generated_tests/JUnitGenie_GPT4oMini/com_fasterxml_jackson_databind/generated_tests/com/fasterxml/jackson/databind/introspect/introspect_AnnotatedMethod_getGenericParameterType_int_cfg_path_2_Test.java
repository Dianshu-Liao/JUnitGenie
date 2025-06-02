package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import static org.junit.Assert.assertNull;

public class introspect_AnnotatedMethod_getGenericParameterType_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetGenericParameterType_IndexOutOfBounds() throws NoSuchMethodException {
        // Create a mock Method object with no generic parameters
        Method mockMethod = createMockMethodWithNoGenericParameters();
        
        // Instantiate AnnotatedMethod with the mock Method
        AnnotatedMethod annotatedMethod = new AnnotatedMethod(null, mockMethod, null, null);
        
        // Test with an index that is out of bounds
        Type result = annotatedMethod.getGenericParameterType(1); // Assuming the method has no parameters
        assertNull(result);
    }

    private Method createMockMethodWithNoGenericParameters() throws NoSuchMethodException {
        // This method should return a Method object that has no generic parameters.
        // For the purpose of this example, we can return a real Method object.
        // Here, we will return a Method object from a sample class with no parameters.
        return SampleClass.class.getMethod("sampleMethod"); // Replace with actual Method retrieval logic
    }

    // Sample class to provide a method for reflection
    public static class SampleClass {
        public void sampleMethod() {
            // No parameters
        }
    }

}