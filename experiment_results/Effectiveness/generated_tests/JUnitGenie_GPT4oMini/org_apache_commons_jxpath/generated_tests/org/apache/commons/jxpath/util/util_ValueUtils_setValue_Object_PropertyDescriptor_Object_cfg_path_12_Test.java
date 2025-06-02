package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testSetValue_WithValidInputs() {
        try {
            // Setup
            TestBean bean = new TestBean();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
            Object value = "New Value";

            // Execute
            ValueUtils.setValue(bean, propertyDescriptor, value);

            // Verify
            assertEquals("New Value", bean.getName());
        } catch (Exception ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_WithNullBean() {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", TestBean.class);
            ValueUtils.setValue(null, propertyDescriptor, "Some Value");
            fail("JXPathException expected");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("Cannot modify property: null.name"));
        } catch (Exception ex) {
            fail("Unexpected exception type: " + ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValue_WithNoWriteMethod() {
        try {
            TestBean bean = new TestBean();
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("noWriteMethod", TestBean.class);
            ValueUtils.setValue(bean, propertyDescriptor, "Some Value");
            fail("JXPathException expected");
        } catch (JXPathException ex) {
            assertTrue(ex.getMessage().contains("No write method"));
        } catch (Exception ex) {
            fail("Unexpected exception type: " + ex.getMessage());
        }
    }

    // A simple test bean class with a public field and public getter and setter
    public static class TestBean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
        // A property with no setter
        public String getNoWriteMethod() {
            return "Cannot set this";
        }
    }

}