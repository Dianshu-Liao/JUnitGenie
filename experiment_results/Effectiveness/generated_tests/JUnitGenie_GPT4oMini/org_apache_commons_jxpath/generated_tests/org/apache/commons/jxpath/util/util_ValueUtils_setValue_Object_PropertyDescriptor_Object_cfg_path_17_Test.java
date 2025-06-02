package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testSetValueThrowsJXPathExceptionWhenMethodIsNull() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithNullWriteMethod();
        Object value = new Object();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("Cannot modify property: " + bean.getClass().getName() + "." + propertyDescriptor.getName(), e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueThrowsJXPathExceptionWhenBeanIsNull() {
        Object bean = null;
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithPublicWriteMethod();
        Object value = new Object();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("Cannot modify property: null." + propertyDescriptor.getName(), e.getMessage());
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithNullWriteMethod() {
        try {
            Method method = null; // Simulating a null write method
            return new PropertyDescriptor("propertyName", null, method);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithPublicWriteMethod() {
        try {
            Method method = PublicBean.class.getMethod("setProperty", Object.class);
            return new PropertyDescriptor("propertyName", null, method);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class PublicBean {
        public void setProperty(Object value) {
            // Setter method
        }
    }

}