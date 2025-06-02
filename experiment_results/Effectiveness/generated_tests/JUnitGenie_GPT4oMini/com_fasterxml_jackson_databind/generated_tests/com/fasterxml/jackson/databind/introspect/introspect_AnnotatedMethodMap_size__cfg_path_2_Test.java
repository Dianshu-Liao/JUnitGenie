package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class introspect_AnnotatedMethodMap_size__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSizeWhenMethodsIsNull() {
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap();
        // Simulating _methods being null
        // Since _methods is protected, we cannot directly set it, 
        // but we can assume the constructor initializes it to null.
        
        int size = annotatedMethodMap.size();
        assertEquals(0, size);
    }

    @Test(timeout = 4000)
    public void testSizeWhenMethodsIsNotNull() {
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap(new java.util.HashMap<>());
        // Assuming _methods is initialized with an empty map
        int size = annotatedMethodMap.size();
        assertEquals(0, size);
        
        // Adding an entry to the map to test the size
        // Assuming we have valid constructor parameters for MemberKey and AnnotatedMethod

        // Create a dummy method for testing
        java.lang.reflect.Method method = null; // Replace with an actual Method object if needed
        AnnotatedMethod annotatedMethod = new AnnotatedMethod(null, method, null, null);

        // Use a valid constructor for MemberKey, passing the necessary parameters
        annotatedMethodMap._methods.put(new MemberKey(method), annotatedMethod);
        size = annotatedMethodMap.size();
        assertEquals(1, size);
    }

}