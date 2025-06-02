package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethodMap;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Method;

public class introspect_AnnotatedMethodMap_size__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSizeWhenMethodsIsNull() {
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap();
        // Assuming _methods is initialized to null by default
        assertEquals(0, annotatedMethodMap.size());
    }

    @Test(timeout = 4000)
    public void testSizeWhenMethodsIsNotNull() throws NoSuchMethodException {
        // Create a sample method for testing
        Method sampleMethod = SampleClass.class.getDeclaredMethod("sampleMethod");
        AnnotatedMethod annotatedMethod = new AnnotatedMethod(null, sampleMethod, null, null); // Pass the proper parameters as needed
        MemberKey memberKey = new MemberKey(sampleMethod); // Use appropriate constructor
        
        Map<MemberKey, AnnotatedMethod> methods = new HashMap<>();
        methods.put(memberKey, annotatedMethod);
        
        AnnotatedMethodMap annotatedMethodMap = new AnnotatedMethodMap(methods);
        // Assuming _methods is initialized with the provided map
        assertEquals(1, annotatedMethodMap.size());
    }

    public static class SampleClass {
        public void sampleMethod() {}
    }

}