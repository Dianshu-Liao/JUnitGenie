package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testSetValue_NonPublicMethod_NonPublicClass() {
        // Arrange
        Object bean = new NonPublicClass();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("nonPublicProperty");
        Object value = "testValue";

        // Act
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Assert
            assertEquals("Cannot modify property: NonPublicClass.nonPublicProperty", e.getMessage());
        }
    }

    private PropertyDescriptor createPropertyDescriptor(String propertyName) {
        try {
            Method writeMethod = NonPublicClass.class.getDeclaredMethod(propertyName, String.class);
            return new PropertyDescriptor(propertyName, null, writeMethod);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static class NonPublicClass {
        // Non-public method in a non-public class
        void nonPublicProperty(String value) {
            // Method implementation
        }
    }

}