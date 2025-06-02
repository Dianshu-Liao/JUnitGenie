package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class text_StrBuilder_endsWith_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEndsWith() {
        // Setup
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        strBuilder.size = 10; // Set size to match the length of the buffer
        strBuilder.buffer = "HelloWorld".toCharArray(); // Initialize buffer

        // Test case 1: Check if endsWith returns true for matching suffix
        assertTrue(strBuilder.endsWith("World"));

        // Test case 2: Check if endsWith returns false for non-matching suffix
        assertFalse(strBuilder.endsWith("Hello"));

        // Test case 3: Check if endsWith returns true for empty string
        assertTrue(strBuilder.endsWith(""));

        // Test case 4: Check if endsWith returns false for null
        assertFalse(strBuilder.endsWith(null));
    }

}