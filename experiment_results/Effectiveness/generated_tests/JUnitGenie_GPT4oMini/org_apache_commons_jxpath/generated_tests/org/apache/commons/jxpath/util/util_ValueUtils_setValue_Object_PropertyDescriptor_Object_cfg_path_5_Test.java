package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSetValue_Success() {
        // Setup the test data
        Bean bean = new Bean();
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor("propertyName"); // Mock the PropertyDescriptor
        Object value = "testValue";

        try {
            // Call the focal method
            ValueUtils.setValue(bean, propertyDescriptor, value);
            // Assert the expected outcome
            assertEquals("testValue", bean.getPropertyName());
        } catch (Exception ex) {
            fail("Should not have thrown any exception: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_NullBean() {
        // Setup the test data
        Bean bean = null;
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor("propertyName"); // Mock the PropertyDescriptor
        Object value = "testValue";

        try {
            // Call the focal method
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException due to null bean");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("null"));
        } catch (Exception ex) {
            fail("Expected JXPathException, but got: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_NullMethod() {
        // Setup the test data
        Bean bean = new Bean();
        PropertyDescriptor propertyDescriptor = getNullWriteMethodPropertyDescriptor(); // Mock to return null for write method
        Object value = "testValue";

        try {
            // Call the focal method
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException due to null write method");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("Cannot modify property:"));
        } catch (Exception ex) {
            fail("Expected JXPathException, but got: " + ex.getMessage());
        }
    }

    // Mock methods for PropertyDescriptor
    private PropertyDescriptor getPropertyDescriptor(String propertyName) {
        try {
            Method method = Bean.class.getMethod("setPropertyName", String.class);
            return new PropertyDescriptor(propertyName, Bean.class.getMethod("getPropertyName"), method);
        } catch (Exception e) {
            return null; // Handle exception appropriately
        }
    }

    private PropertyDescriptor getNullWriteMethodPropertyDescriptor() {
        try {
            return new PropertyDescriptor("propertyName", Bean.class.getMethod("getPropertyName"), null);
        } catch (Exception e) {
            return null; // Handle exception appropriately
        }
    }

    // Simple bean class for testing
    public static class Bean {
        private String propertyName;

        public String getPropertyName() {
            return propertyName;
        }

        public void setPropertyName(String propertyName) {
            this.propertyName = propertyName;
        }
    }


}