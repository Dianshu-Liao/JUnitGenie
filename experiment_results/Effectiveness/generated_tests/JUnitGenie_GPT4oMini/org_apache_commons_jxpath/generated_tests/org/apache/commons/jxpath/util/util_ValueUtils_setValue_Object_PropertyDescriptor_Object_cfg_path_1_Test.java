package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import java.beans.PropertyDescriptor;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import static org.junit.Assert.fail;

public class util_ValueUtils_setValue_Object_PropertyDescriptor_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetValue_WithNullWriteMethod_ShouldThrowJXPathException() {
        // Given
        Object bean = new Object();
        PropertyDescriptor propertyDescriptor = createPropertyDescriptorWithNullWriteMethod();
        Object value = new Object();

        // When
        try {
            ValueUtils.setValue(bean, propertyDescriptor, value);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException ex) {
            // Then
            // Exception is expected, test succeeds
        } catch (Exception ex) {
            fail("Expected JXPathException but got: " + ex.getMessage());
        }
    }

    private PropertyDescriptor createPropertyDescriptorWithNullWriteMethod() {
        try {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor("testProperty", Object.class, null, null);
            return propertyDescriptor;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}