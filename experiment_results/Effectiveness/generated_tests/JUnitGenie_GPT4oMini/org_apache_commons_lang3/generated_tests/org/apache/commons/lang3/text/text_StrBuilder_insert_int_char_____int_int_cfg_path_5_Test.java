package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = 6; // Valid length

        // Ensure the size is 5 before insertion
        assertEquals(5, strBuilder.size());
        
        strBuilder.insert(index, charsToInsert, offset, length);
        
        // Check the result after insertion
        assertEquals("Hello World", strBuilder.toString());
        assertEquals(11, strBuilder.size()); // Size should now be 11
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        int index = 5; // Valid index

        // Inserting null chars should not throw an exception
        strBuilder.insert(index, null, 0, 0);
        
        // Check the result after insertion
        assertEquals("Hello", strBuilder.toString());
        assertEquals(5, strBuilder.size()); // Size should remain 5
    }

    @Test(timeout = 4000)
    public void testInsertWithInvalidOffset() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 10; // Invalid offset
        int length = 6; // Valid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException for invalid offset");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithInvalidLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = 10; // Invalid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException for invalid length");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = -1; // Invalid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException for negative length");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        }
    }

}