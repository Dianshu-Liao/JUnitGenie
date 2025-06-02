package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithoutWriteMethod();
        Object value = "testValue";

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("No write method", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_CannotModifyProperty() {
        Object bean = null; // Simulating a null bean
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithWriteMethod();
        Object value = "testValue";

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("Cannot modify property: null"));
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithoutWriteMethod() {
        try {
            return new PropertyDescriptor("propertyName", null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithWriteMethod() {
        try {
            Method writeMethod = DummyBean.class.getMethod("setPropertyName", String.class);
            return new PropertyDescriptor("propertyName", null, writeMethod);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class DummyBean {
        private String propertyName;

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }
    }

}