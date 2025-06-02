package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testSetValueWithValidParameters() {
        try {
            // Setup
            TestBean bean = new TestBean(); // Changed Object to TestBean
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);

            // Verify
            assertEquals("newValue", bean.getProperty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNullBean() {
        try {
            // Setup
            TestBean bean = null; // Changed Object to TestBean
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("JXPathException expected but not thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("Cannot modify property: null.property"));
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNoWriteMethod() {
        try {
            // Setup
            TestBeanWithoutWriteMethod bean = new TestBeanWithoutWriteMethod(); // Changed Object to TestBeanWithoutWriteMethod
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("property", TestBeanWithoutWriteMethod.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("JXPathException expected but not thrown");
        } catch (JXPathException e) {
            assertTrue(e.getMessage().contains("No write method"));
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getMessage());
        }
    }

    // Test bean with a writable property
    public static class TestBean {
        private String property;

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }
    }

    // Test bean without a writable property
    public static class TestBeanWithoutWriteMethod {
        private String property;

        public String getProperty() {
            return property;
        }
    }


}