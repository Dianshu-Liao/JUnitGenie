package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import java.beans.PropertyDescriptor;
import java.beans.IndexedPropertyDescriptor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_int_Object_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testSetValueWithIndexedPropertyDescriptor() {
        try {
            // Setup for IndexedPropertyDescriptor
            PropertyDescriptor pd = new IndexedPropertyDescriptor("property", TestBean.class);
            TestBean bean = new TestBean();
            // Set array in the bean for testing collection conditions
            bean.setArrayProperty(new String[]{"initialValue", "newValue"});

            // Valid index and value
            ValueUtils.setValue(bean, pd, 1, "newValue");
            assertEquals("newValue", bean.getArrayProperty()[1]); // validating that the value has been set
        } catch (Exception e) {
            fail("Exception thrown when setting value: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithInvalidCollection() {
        try {
            PropertyDescriptor pd = new IndexedPropertyDescriptor("property", TestBean.class);
            TestBean bean = new TestBean();
            bean.setArrayProperty(null); // Setting the property to null to trigger the exception

            ValueUtils.setValue(bean, pd, 1, "newValue");
            fail("Expected IllegalArgumentException should be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Not a collection: property", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithWrongIndex() {
        try {
            PropertyDescriptor pd = new IndexedPropertyDescriptor("property", TestBean.class);
            TestBean bean = new TestBean();
            bean.setArrayProperty(new String[]{"value1"});

            // Setting with index 1 which should trigger an exception because there's only one element
            ValueUtils.setValue(bean, pd, 1, "newValue");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Not a collection: property", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    public static class TestBean {
        private String[] arrayProperty;

        public String[] getArrayProperty() {
            return arrayProperty;
        }

        public void setArrayProperty(String[] arrayProperty) {
            this.arrayProperty = arrayProperty;
        }
    }

}