package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendDetail_StringBuffer_String_int_____cfg_path_3_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement any abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testAppendDetail() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            StringBuffer buffer = new StringBuffer();
            String fieldName = "testField";
            int[] array = {1, 2, 3};

            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("appendDetail", StringBuffer.class, String.class, int[].class);
            method.setAccessible(true);
            method.invoke(style, buffer, fieldName, array);

            // Expected output
            String expectedOutput = "{1,2,3}";
            assertEquals(expectedOutput, buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}