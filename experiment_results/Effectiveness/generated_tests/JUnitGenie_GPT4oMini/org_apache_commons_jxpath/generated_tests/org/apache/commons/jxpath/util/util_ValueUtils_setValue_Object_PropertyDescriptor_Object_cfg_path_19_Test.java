package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_19_Test {

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithNoWriteMethod();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, new Object());
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("No write method", e.getMessage());
        } catch (Exception e) {
            fail("Expected JXPathException, but got: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_Success() {
        Object bean = new TestBean();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithWriteMethod();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, "newValue");
            assertEquals("newValue", ((TestBean) bean).getProperty());
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getClass().getName());
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithNoWriteMethod() {
        try {
            return new PropertyDescriptor("property", TestBean.class, null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithWriteMethod() {
        try {
            return new PropertyDescriptor("property", TestBean.class, "getProperty", "setProperty");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class TestBean {
        private String property;

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }
    }

}