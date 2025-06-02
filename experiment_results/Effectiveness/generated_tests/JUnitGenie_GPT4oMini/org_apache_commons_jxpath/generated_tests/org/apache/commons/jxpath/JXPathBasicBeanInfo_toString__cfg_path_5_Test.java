package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathBasicBeanInfo;
import org.junit.Test;
import java.beans.PropertyDescriptor;
import static org.junit.Assert.assertEquals;

public class JXPathBasicBeanInfo_toString__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testToString() {
        // Arrange
        Class<?> clazz = String.class; // Example class
        JXPathBasicBeanInfo beanInfo = new JXPathBasicBeanInfo(clazz) {
            @Override
            public boolean isDynamic() {
                return false; // Ensure dynamic is false
            }

            @Override
            public boolean isAtomic() {
                return false; // Ensure atomic is false
            }

            @Override
            public PropertyDescriptor[] getPropertyDescriptors() {
                return new PropertyDescriptor[0]; // No properties for this test
            }
        };

        // Act
        String result = null;
        try {
            result = beanInfo.toString();
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        String expected = "BeanInfo [class = java.lang.String, properties = []]";
        assertEquals(expected, result);
    }

}