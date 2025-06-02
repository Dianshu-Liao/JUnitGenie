package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Prepare test data
        TestBean bean = new TestBean();
        PropertyDescriptor pd = getIndexedPropertyDescriptor("values", TestBean.class);
        int index = 0;
        Object value = "newValue";
        
        // Execute the method to test
        try {
            ValueUtils.setValue(bean, pd, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown exception: " + e.getMessage());
        }
        
        // Verify the outcome
        assertEquals("newValue", bean.getValues()[index]);
    }

    @Test(timeout = 4000)
    public void testSetValueThrowsIllegalArgumentExceptionForNullMethod() {
        // Prepare test data with property descriptor that has no indexed write method
        TestBean bean = new TestBean();
        PropertyDescriptor pd = null; // Initialize to null
        try {
            pd = new PropertyDescriptor("nonIndexedProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Failed to create PropertyDescriptor: " + e.getMessage());
        }
        int index = 0;
        Object value = "value";

        try {
            ValueUtils.setValue(bean, pd, index, value);
            fail("Expected IllegalArgumentException but none was thrown.");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cannot access property: nonIndexedProperty"));
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithInvalidCollection() {
        // Prepare test data with an invalid collection
        TestBean bean = new TestBean();
        PropertyDescriptor pd = getIndexedPropertyDescriptor("values", TestBean.class); // Changed to "values"
        int index = 1; // This index is out of bounds for the default array size
        Object value = "value";

        try {
            ValueUtils.setValue(bean, pd, index, value);
            fail("Expected IllegalArgumentException but none was thrown.");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Not a collection: values")); // Changed to "values"
        }
    }

    // Helper class to mimic a bean with properties
    public static class TestBean {
        private String[] values = new String[1];

        public String[] getValues() {
            return values;
        }

        public void setValues(String[] values) {
            this.values = values;
        }

        // Added a method to allow indexed access
        public String getValues(int index) {
            return values[index];
        }

        public void setValues(int index, String value) {
            if (index >= values.length) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            values[index] = value;
        }
    }

    // Helper method to get IndexedPropertyDescriptor
    private PropertyDescriptor getIndexedPropertyDescriptor(String propertyName, Class<?> beanClass) {
        try {
            return new IndexedPropertyDescriptor(propertyName, beanClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create IndexedPropertyDescriptor for " + propertyName, e);
        }
    }

}