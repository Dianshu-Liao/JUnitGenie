package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.junit.Test;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

public class util_BeanUtil_okNameForRegularGetter_AnnotatedMethod_String_boolean_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testOkNameForRegularGetter_withGetMethodName() {
        // Arrange
        AnnotatedMethod am = createAnnotatedMethod("getSomeProperty"); // Create a valid AnnotatedMethod instance
        String name = "getSomeProperty";
        boolean stdNaming = true;

        // Act
        String result = BeanUtil.okNameForRegularGetter(am, name, stdNaming);

        // Assert
        assertEquals("someProperty", result); // Expecting the property name without "get"
    }

    @Test(timeout = 4000)
    public void testOkNameForRegularGetter_withGetCallbacks() {
        // Arrange
        AnnotatedMethod am = createAnnotatedMethod("getCallbacks"); // Create a valid AnnotatedMethod instance
        String name = "getCallbacks";
        boolean stdNaming = true;

        // Act
        String result = BeanUtil.okNameForRegularGetter(am, name, stdNaming);

        // Assert
        assertEquals("callbacks", result); // Expecting the property name without "get"
    }

    @Test(timeout = 4000)
    public void testOkNameForRegularGetter_withGetMetaClass() {
        // Arrange
        AnnotatedMethod am = createAnnotatedMethod("getMetaClass"); // Create a valid AnnotatedMethod instance
        String name = "getMetaClass";
        boolean stdNaming = true;

        // Act
        String result = BeanUtil.okNameForRegularGetter(am, name, stdNaming);

        // Assert
        assertEquals("metaClass", result); // Expecting the property name without "get"
    }

    @Test(timeout = 4000)
    public void testOkNameForRegularGetter_withNonGetMethodName() {
        // Arrange
        AnnotatedMethod am = createAnnotatedMethod("setSomeProperty"); // Create a valid AnnotatedMethod instance
        String name = "setSomeProperty";
        boolean stdNaming = true;

        // Act
        String result = BeanUtil.okNameForRegularGetter(am, name, stdNaming);

        // Assert
        assertNull(result); // Expecting null for non-getter method
    }

    private AnnotatedMethod createAnnotatedMethod(String methodName) {
        try {
            // Use reflection to create a Method object
            Method method = this.getClass().getDeclaredMethod(methodName);
            // Create a valid AnnotatedMethod instance using the Method object
            return new AnnotatedMethod(null, method, null, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null; // Handle the case where the method does not exist
        }
    }

    // Dummy getter for testing purposes
    public String getSomeProperty() {
        return "value";
    }

    public String getCallbacks() {
        return "callbacks";
    }

    public String getMetaClass() {
        return "metaClass";
    }

}