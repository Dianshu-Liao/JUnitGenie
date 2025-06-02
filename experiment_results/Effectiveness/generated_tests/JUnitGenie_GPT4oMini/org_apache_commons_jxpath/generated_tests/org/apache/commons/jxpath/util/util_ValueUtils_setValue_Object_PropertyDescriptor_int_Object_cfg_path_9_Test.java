package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_9_Test {

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
    public void testSetValueWithNullMethod() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("testProperty", TestBean.class) {
                @Override
                public Method getIndexedWriteMethod() {
                    return null; // Simulate no indexed write method
                }
            };
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Cannot access property: testProperty"));
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonCollection() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor("nonCollectionProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 1; // Invalid index for non-collection
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Not a collection: nonCollectionProperty"));
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] testProperty = new String[1];
        private String nonCollectionProperty;

        public String getTestProperty(int index) {
            return testProperty[index];
        }

        public void setTestProperty(int index, String value) {
            testProperty[index] = value;
        }

        public String getNonCollectionProperty() {
            return nonCollectionProperty;
        }

        public void setNonCollectionProperty(String nonCollectionProperty) {
            this.nonCollectionProperty = nonCollectionProperty;
        }
    }

}