package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.apache.commons.jxpath.JXPathException;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_11_Test {

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
        } catch (Exception ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_NullBean() {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("testProperty", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(null, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("Cannot modify property: null"));
        } catch (Exception ex) {
            fail("Unexpected exception type: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        try {
            TestBean bean = new TestBean(); // Change Object to TestBean
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("noWriteMethodProperty", TestBean.class);
            Object value = "newValue";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("No write method"));
        } catch (Exception ex) {
            fail("Unexpected exception type: " + ex.getMessage());
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
        
        // This property has no write method
        public String getNoWriteMethodProperty() {
            return "noWriteMethod";
        }
    }


}