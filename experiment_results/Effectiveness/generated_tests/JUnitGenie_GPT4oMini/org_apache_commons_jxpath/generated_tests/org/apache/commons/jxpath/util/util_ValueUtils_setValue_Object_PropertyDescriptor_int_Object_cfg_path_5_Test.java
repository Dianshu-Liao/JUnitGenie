package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("values", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "New Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not throw an exception: " + e.getMessage());
        }

        // Verify
        assertEquals("New Value", ((TestBean) bean).getValueAt(index));
    }

    @Test(timeout = 4000)
    public void testSetValueWithNullMethod() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("nonIndexedProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not throw an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "New Value";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Not a collection: nonIndexedProperty"));
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] values = new String[10];

        public String getValueAt(int index) {
            return values[index];
        }

        public void setValueAt(int index, String value) {
            values[index] = value;
        }
    }


}