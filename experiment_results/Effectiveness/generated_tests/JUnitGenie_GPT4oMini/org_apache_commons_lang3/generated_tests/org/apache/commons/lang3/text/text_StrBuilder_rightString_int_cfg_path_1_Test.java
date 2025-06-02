package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_rightString_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRightString() {
        // Setup
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello, World!"); // Assuming the buffer is populated
        // Directly setting the protected fields for testing purposes
        // This is not a good practice in production code but is acceptable for testing
        try {
            // Accessing protected fields via reflection (not shown here) or using a subclass
            // For this example, we will assume the size is set correctly
            // Let's assume size is 13 (length of "Hello, World!")
            strBuilder.size = 13; 
            strBuilder.buffer = "Hello, World!".toCharArray();

            // Test case where length is less than size
            String result = strBuilder.rightString(5);
            assertEquals("World", result); // Expecting "World" from "Hello, World!"

            // Test case where length is equal to size
            result = strBuilder.rightString(13);
            assertEquals("Hello, World!", result); // Expecting the full string

            // Test case where length is less than or equal to 0
            result = strBuilder.rightString(0);
            assertEquals("", result); // Expecting empty string

        } catch (Exception e) {
            e.printStackTrace(); // Handle any exceptions that may occur
        }
    }

}