package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class builder_ToStringStyle_removeLastFieldSeparator_StringBuffer_cfg_path_1_Test {

    private static class ConcreteToStringStyle extends ToStringStyle {
        // Implement necessary abstract methods if any

        // Add a method to access the fieldSeparator
        protected String getFieldSeparator() {
            return ", "; // Assuming a comma and space as the field separator
        }

        // Override the toString method to avoid the error
        @Override
        public String toString() {
            return super.toString();
        }
    }

    @Test(timeout = 4000)
    public void testRemoveLastFieldSeparator() {
        try {
            // Create instance of the concrete class
            ConcreteToStringStyle style = new ConcreteToStringStyle();
            StringBuffer buffer = new StringBuffer("field1,field2,");

            // Access the protected method using reflection
            Method method = ToStringStyle.class.getDeclaredMethod("removeLastFieldSeparator", StringBuffer.class);
            method.setAccessible(true);  // Allow access to the protected method

            // Set up the fieldSeparator for this instance
            style.append(buffer, "field1", "value1", true);
            style.append(buffer, "field2", "value2", false);

            // Call the method
            method.invoke(style, buffer);

            // Verify the result
            assertEquals("Expected buffer to have the last field separator removed", "field1=value1, field2=value2", buffer.toString());
        } catch (Exception e) {
            e.printStackTrace(); // For debugging purposes, handle exceptions
        }
    }


}
