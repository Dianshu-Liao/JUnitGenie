package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_6_Test {

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
            propertyDescriptor = new IndexedPropertyDescriptor("nonIndexed", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "Test Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Not a collection: nonIndexed"));
        }
    }

    @Test(timeout = 4000)
    public void testSetValueThrowsException() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw exception: " + e.getMessage());
        }
        int index = 0;
        Object value = null; // This should cause an exception in convert method

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cannot access property: values"));
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] values = new String[10];

        public String[] getValues() {
            return values;
        }
    }


}