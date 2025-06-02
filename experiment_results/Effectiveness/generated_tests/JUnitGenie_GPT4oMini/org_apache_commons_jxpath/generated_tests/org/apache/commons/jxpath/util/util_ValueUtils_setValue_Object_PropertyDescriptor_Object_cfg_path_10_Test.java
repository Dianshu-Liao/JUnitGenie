package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSetValue() {
        try {
            // Setup
            TestBean bean = new TestBean(); // Change Object to TestBean
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("testProperty", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);

            // Verify
            assertEquals("newValue", bean.getTestProperty());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        try {
            // Setup
            TestBean bean = new TestBean(); // Change Object to TestBean
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("noWriteMethodProperty", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    // TestBean class for testing purposes
    public static class TestBean {
        private String testProperty;

        public String getTestProperty() {
            return testProperty;
        }

        public void setTestProperty(String testProperty) {
            this.testProperty = testProperty;
        }

        // This property does not have a write method
        public String getNoWriteMethodProperty() {
            return "noWriteMethod";
        }
    }


}