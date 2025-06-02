package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class text_StrBuilder_endsWith_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEndsWith() {
        // Setup
        StrBuilder strBuilder = new StrBuilder("HelloWorld");
        strBuilder.size = 10; // Set size to match the string length
        strBuilder.buffer = strBuilder.toString().toCharArray(); // Initialize buffer

        // Test case 1: endsWith with a matching suffix
        assertTrue(strBuilder.endsWith("World"));

        // Test case 2: endsWith with a non-matching suffix
        assertFalse(strBuilder.endsWith("Hello"));

        // Test case 3: endsWith with an empty string
        assertTrue(strBuilder.endsWith(""));

        // Test case 4: endsWith with null
        assertFalse(strBuilder.endsWith(null));

        // Test case 5: endsWith with a longer string than the StrBuilder
        assertFalse(strBuilder.endsWith("HelloWorld!"));
    }

}