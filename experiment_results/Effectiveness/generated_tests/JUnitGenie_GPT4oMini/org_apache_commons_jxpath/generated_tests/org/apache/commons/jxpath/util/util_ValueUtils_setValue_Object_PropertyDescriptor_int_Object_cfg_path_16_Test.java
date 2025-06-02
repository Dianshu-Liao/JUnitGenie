package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        IndexedPropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new IndexedPropertyDescriptor("testProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 0;
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
        } catch (IllegalArgumentException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }

        // Verify
        assertEquals("newValue", bean.getTestProperty()[index]);
    }

    @Test(timeout = 4000)
    public void testSetValueWithNonCollection() {
        // Setup
        TestBean bean = new TestBean(); // Change Object to TestBean
        PropertyDescriptor propertyDescriptor = null;
        try {
            propertyDescriptor = new PropertyDescriptor("nonCollectionProperty", TestBean.class);
        } catch (IntrospectionException e) {
            fail("Should not have thrown an exception: " + e.getMessage());
        }
        int index = 1;
        Object value = "newValue";

        // Execute
        try {
            ValueUtils.setValue(bean, propertyDescriptor, index, value);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Not a collection: nonCollectionProperty", e.getMessage());
        }
    }

    // Additional test cases can be added here to cover more scenarios

    // TestBean class for testing purposes
    public static class TestBean {
        private String[] testProperty = new String[1];
        private String nonCollectionProperty;

        public String[] getTestProperty() {
            return testProperty;
        }

        public void setTestProperty(String[] testProperty) {
            this.testProperty = testProperty;
        }

        public String getNonCollectionProperty() {
            return nonCollectionProperty;
        }

        public void setNonCollectionProperty(String nonCollectionProperty) {
            this.nonCollectionProperty = nonCollectionProperty;
        }
    }

}