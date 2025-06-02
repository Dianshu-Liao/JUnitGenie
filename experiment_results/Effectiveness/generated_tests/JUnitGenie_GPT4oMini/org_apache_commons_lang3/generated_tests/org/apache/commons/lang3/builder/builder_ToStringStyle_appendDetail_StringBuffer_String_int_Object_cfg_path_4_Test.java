package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import java.lang.StringBuffer;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_appendDetail_StringBuffer_String_int_Object_cfg_path_4_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement any required abstract methods here if necessary
    }

    @Test(timeout = 4000)
    public void testAppendDetailWithNullItem() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            StringBuffer buffer = new StringBuffer();
            String fieldName = "testField";
            int i = 1;
            Object item = null;

            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("appendDetail", StringBuffer.class, String.class, int.class, Object.class);
            method.setAccessible(true);
            method.invoke(style, buffer, fieldName, i, item);

            // Verify the expected output
            assertEquals("Expected output after appending null text", "null", buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}