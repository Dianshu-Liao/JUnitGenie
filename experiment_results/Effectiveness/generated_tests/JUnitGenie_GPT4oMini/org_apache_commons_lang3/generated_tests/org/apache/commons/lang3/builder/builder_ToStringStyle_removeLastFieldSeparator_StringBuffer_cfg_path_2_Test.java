package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.Strings;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_removeLastFieldSeparator_StringBuffer_cfg_path_2_Test {

    private class ConcreteToStringStyle extends ToStringStyle {
        // Implement any abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testRemoveLastFieldSeparator() {
        try {
            // Create an instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            
            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("removeLastFieldSeparator", StringBuffer.class);
            method.setAccessible(true);
            
            // Prepare the test input
            StringBuffer buffer = new StringBuffer("field1,field2,");
            // Set the private fieldSeparator to match the test case
            java.lang.reflect.Field fieldSeparatorField = ToStringStyle.class.getDeclaredField("fieldSeparator");
            fieldSeparatorField.setAccessible(true);
            fieldSeparatorField.set(style, ",");
            
            // Call the method
            method.invoke(style, buffer);
            
            // Assert the expected output
            assertEquals("field1,field2", buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}