package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSetValue() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("testProperty");
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
        } catch (JXPathException ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }

        // Verify
        assertEquals("newValue", ((TestBean) bean).getTestProperty());
    }

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        // Setup
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("noWriteMethodProperty");
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("No write method"));
        }
    }

    private PropertyDescriptor createPropertyDescriptor(String propertyName) {
        try {
            Method writeMethod = TestBean.class.getMethod("set" + capitalize(propertyName), String.class);
            Method readMethod = TestBean.class.getMethod("get" + capitalize(propertyName));
            return new PropertyDescriptor(propertyName, readMethod, writeMethod);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static class TestBean {
        private String testProperty;
        private String noWriteMethodProperty;

        public String getTestProperty() {
            return testProperty;
        }

        public void setTestProperty(String testProperty) {
            this.testProperty = testProperty;
        }

        public String getNoWriteMethodProperty() {
            return noWriteMethodProperty;
        }
    }

}