package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testSetValue() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("value");
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
        } catch (JXPathException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        // Verify
        assertEquals("newValue", ((TestBean) bean).getValue());
    }

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        // Setup
        Object bean = new TestBeanWithoutWriteMethod();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("value");
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Expected exception
        }
    }

    private PropertyDescriptor createPropertyDescriptor(String propertyName) {
        try {
            Method writeMethod = TestBean.class.getMethod("setValue", String.class);
            return new PropertyDescriptor(propertyName, null, writeMethod);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create PropertyDescriptor", e);
        }
    }

    public static class TestBean {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class TestBeanWithoutWriteMethod {
        private String value;

        public String getValue() {
            return value;
        }
    }

}