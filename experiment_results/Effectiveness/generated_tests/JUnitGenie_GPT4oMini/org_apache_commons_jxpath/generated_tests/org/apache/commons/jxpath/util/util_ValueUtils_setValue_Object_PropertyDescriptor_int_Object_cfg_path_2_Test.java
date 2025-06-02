package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetValue_withIndexedPropertyDescriptor_throwsIllegalArgumentException() {
        // Arrange
        Object bean = new TestBean(); // replace with actual bean object
        IndexedPropertyDescriptor propertyDescriptor = createIndexedPropertyDescriptor("property", bean.getClass());
        int index = 0;
        Object value = new Object(); // replace with actual value

        // Act & Assert
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Cannot access property: property"));
        }
    }
    
    @Test(timeout = 4000)
    public void testSetValue_withNonIndexedPropertyDescriptor_throwsIllegalArgumentException() {
        // Arrange
        Object bean = new TestBean(); // replace with actual bean object
        PropertyDescriptor propertyDescriptor = null; // Initialize to null
        try {
            propertyDescriptor = new PropertyDescriptor("property", bean.getClass());
        } catch (IntrospectionException e) {
            fail("Failed to create PropertyDescriptor: " + e.getMessage());
        }
        int index = 1;
        Object value = new Object(); // replace with actual value

        // Act & Assert
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Not a collection: property"));
        }
    }

    private IndexedPropertyDescriptor createIndexedPropertyDescriptor(String propertyName, Class<?> beanClass) {
        try {
            Method readMethod = beanClass.getMethod("get" + capitalize(propertyName), int.class);
            Method writeMethod = beanClass.getMethod("set" + capitalize(propertyName), int.class, Object.class);
            // Corrected constructor usage
            return new IndexedPropertyDescriptor(propertyName, readMethod, writeMethod, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create IndexedPropertyDescriptor", e);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    // Dummy TestBean class for demonstration purposes
    public static class TestBean {
        private Object[] property = new Object[10]; // Initialize array to avoid NullPointerException

        public Object getProperty(int index) {
            return property[index];
        }

        public void setProperty(int index, Object value) {
            property[index] = value;
        }
    }


}