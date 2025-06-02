package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "Test Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not throw exception: " + e.getMessage());
        }

        // Verify
        assertEquals("Test Value", ((TestBean) bean).getValues()[index]);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNullMethod() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class) {
                @Override
                public Method getIndexedWriteMethod() {
                    return null; // Simulate no indexed write method
                }
            };
        } catch (IntrospectionException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "Test Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Cannot access property: values"));
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonCollection() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor("nonCollectionProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
        int index = 1; // Invalid index for non-collection
        Object value = "Test Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Not a collection: nonCollectionProperty"));
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] values = new String[1];
        private String nonCollectionProperty;

        public String[] getValues() {
            return values;
        }

        public String getNonCollectionProperty() {
            return nonCollectionProperty;
        }
    }


}