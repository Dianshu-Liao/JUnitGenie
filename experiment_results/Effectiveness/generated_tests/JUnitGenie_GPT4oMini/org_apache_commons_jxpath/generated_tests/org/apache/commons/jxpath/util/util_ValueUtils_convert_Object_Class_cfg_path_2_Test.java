package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.JXPathException;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class util_ValueUtils_convert_Object_Class_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConvertThrowsJXPathException() {
        // Arrange
        Object value = "string"; // A string cannot be converted to Integer
        Class<?> type = Integer.class; // Target type is Integer

        try {
            // Access the private static method using reflection
            Method method = ValueUtils.class.getDeclaredMethod("convert", Object.class, Class.class);
            method.setAccessible(true);

            // Act
            method.invoke(null, value, type);
            fail("Expected JXPathException to be thrown");
        } catch (JXPathException e) {
            // Assert
            String expectedMessage = "Cannot convert value of class java.lang.String to type class java.lang.Integer";
            assert e.getMessage().contains(expectedMessage);
        } catch (Exception ex) {
            fail("Unexpected exception thrown: " + ex.getMessage());
        }
    }

}