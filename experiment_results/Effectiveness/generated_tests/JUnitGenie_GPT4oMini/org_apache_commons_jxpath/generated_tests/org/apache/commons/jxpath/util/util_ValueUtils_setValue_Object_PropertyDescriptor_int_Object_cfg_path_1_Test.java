package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Setup
        Object bean = new Object(); // Replace with a suitable bean object
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("propertyName", bean.getClass()); // Replace with actual property name and class
        } catch (IntrospectionException e) {
            fail("Should not throw IntrospectionException: " + e.getMessage());
        }
        int index = 0;
        Object value = new Object(); // Replace with a suitable value

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not throw IllegalArgumentException: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueThrowsIllegalArgumentException() {
        // Setup
        Object bean = new Object(); // Replace with a suitable bean object
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor("nonIndexedProperty", bean.getClass()); // Replace with actual property name and class
        } catch (IntrospectionException e) {
            fail("Should not throw IntrospectionException: " + e.getMessage());
        }
        int index = 1; // Invalid index for non-indexed property
        Object value = new Object(); // Replace with a suitable value

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException but got: " + e.getClass().getSimpleName());
        }
    }


}