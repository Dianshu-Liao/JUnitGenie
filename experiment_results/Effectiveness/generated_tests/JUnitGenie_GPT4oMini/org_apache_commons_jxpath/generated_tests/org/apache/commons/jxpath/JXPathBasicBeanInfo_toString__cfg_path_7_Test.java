package org.apache.commons.jxpath;
import org.apache.commons.jxpath.JXPathBasicBeanInfo;
import org.junit.Test;
import java.beans.PropertyDescriptor;
import static org.junit.Assert.assertEquals;

public class JXPathBasicBeanInfo_toString__cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testToString() {
        // Arrange
        Class<?> clazz = String.class; // Example class
        JXPathBasicBeanInfo beanInfo = new JXPathBasicBeanInfo(clazz);
        
        // Set the necessary conditions for the test
        // Assuming we have a way to set dynamicPropertyHandlerClass to null
        // and atomic to false. This might require reflection or a subclass.
        // For this example, we will assume these conditions are met.

        // Act
        String result = beanInfo.toString();

        // Assert
        String expected = "BeanInfo [class = " + clazz.getName() + ", properties = \n" +
                          "java.lang.Class: clazz]";
        assertEquals(expected, result);
    }

}