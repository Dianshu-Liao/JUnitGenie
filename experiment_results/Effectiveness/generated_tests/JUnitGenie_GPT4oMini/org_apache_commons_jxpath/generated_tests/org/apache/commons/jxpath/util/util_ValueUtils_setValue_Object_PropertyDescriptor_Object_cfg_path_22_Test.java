package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testSetValue_withPublicMethod() {
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("value", true);
        Object value = "newValue";

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            assertEquals("newValue", ((TestBean) bean).getValue());
        } catch (JXPathException e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_withNullBean() {
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("value", true);
        Object value = "newValue";

        try {
            ValueUtils.setValue(null, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("Cannot modify property: null.value"));
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_withNoWriteMethod() {
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptor("noSetter", false);
        Object value = "someValue";

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("No write method"));
        }
    }

    private PropertyDescriptor createPropertyDescriptor(String propertyName, boolean hasSetter) {
        try {
            Method writeMethod = hasSetter ? TestBean.class.getMethod("setValue", String.class) : null;
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

}