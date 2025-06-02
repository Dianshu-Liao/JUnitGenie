package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithNoWriteMethod();
        Object value = new Object();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            assertEquals("No write method", ex.getMessage());
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithNoWriteMethod() {
        try {
            // Create a PropertyDescriptor with a null write method
            return new PropertyDescriptor("testProperty", null, null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create PropertyDescriptor", e);
        }
    }

}