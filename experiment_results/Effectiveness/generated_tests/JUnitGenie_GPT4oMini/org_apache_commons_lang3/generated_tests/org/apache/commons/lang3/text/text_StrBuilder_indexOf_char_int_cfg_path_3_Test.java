package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_indexOf_char_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIndexOf() {
        // Setup
        StrBuilder strBuilder = new StrBuilder("hello");
        strBuilder.size = 5; // Set size directly for testing
        strBuilder.buffer = new char[] {'h', 'e', 'l', 'l', 'o'};

        // Test case: character found at the start index
        int result = strBuilder.indexOf('l', 0);
        assertEquals(2, result);

        // Test case: character found at a later index
        result = strBuilder.indexOf('o', 0);
        assertEquals(4, result);

        // Test case: character not found
        result = strBuilder.indexOf('x', 0);
        assertEquals(-1, result);

        // Test case: startIndex is greater than size
        result = strBuilder.indexOf('h', 10);
        assertEquals(-1, result);

        // Test case: startIndex is negative
        result = strBuilder.indexOf('e', -1);
        assertEquals(1, result); // Should start from index 0
    }

}