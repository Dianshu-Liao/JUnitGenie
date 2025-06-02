package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("testProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }

        // Verify
        assertEquals("newValue", bean.getTestProperty(0)); // No change needed here
    }

    @Test(timeout = 4000)
    public void testSetValueWithException() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("invalidProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Verify
            assertTrue(e.getMessage().contains("Cannot access property: invalidProperty"));
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] properties = new String[1];

        public String getTestProperty(int index) {
            return properties[index];
        }

        public void setTestProperty(int index, String value) {
            properties[index] = value;
        }
    }

}