package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.StringBuffer;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendDetail_StringBuffer_String_int_____cfg_path_2_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement any abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testAppendDetail() {
        // Arrange
        ConcreteToStringStyle style = new ConcreteToStringStyle();
        StringBuffer buffer = new StringBuffer();
        String fieldName = "testField";
        int[] array = {1, 2, 3};

        // Accessing the protected method using reflection
        try {
            Method method = ToStringStyle.class.getDeclaredMethod("appendDetail", StringBuffer.class, String.class, int.class);
            method.setAccessible(true); // Make the protected method accessible

            // Act
            for (int value : array) {
                method.invoke(style, buffer, fieldName, value);
            }

            // Assert
            String expectedOutput = "{1}{2}{3}";
            assertEquals(expectedOutput, buffer.toString());

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}