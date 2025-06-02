package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSetValueThrowsJXPathExceptionWhenWriteMethodIsNull() {
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithNullWriteMethod();

        try {
            ValueUtils.setValue(bean, propertyDescriptor, "someValue");
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            assertEquals("Cannot modify property: " + bean.getClass().getName() + "." + propertyDescriptor.getName(), e.getMessage());
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithNullWriteMethod() {
        try {
            return new PropertyDescriptor("propertyName", null, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}