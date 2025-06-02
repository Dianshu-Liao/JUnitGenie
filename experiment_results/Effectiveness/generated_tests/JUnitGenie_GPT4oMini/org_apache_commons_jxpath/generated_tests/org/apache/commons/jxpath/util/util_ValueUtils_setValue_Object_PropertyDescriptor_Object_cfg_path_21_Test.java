package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.JXPathException;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testSetValue_NoWriteMethod() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = null; // Simulating a PropertyDescriptor with no write method
        Object value = new Object();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("No write method", e.getMessage());
        } catch (Exception e) {
            fail("Expected JXPathException, but got: " + e.getClass().getName());
        }
    }

}