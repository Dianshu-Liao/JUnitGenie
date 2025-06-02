package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = 6; // Valid length

        StrBuilder result = strBuilder.insert(index, charsToInsert, offset, length);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");

        char[] charsToInsert = null;
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = 0; // Valid length

        StrBuilder result = strBuilder.insert(index, charsToInsert, offset, length);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeOffset() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = -1; // Invalid offset
        int length = 6; // Valid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithOffsetGreaterThanCharsLength() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 7; // Invalid offset (greater than chars length)
        int length = 6; // Valid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: 7", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeLength() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = -1; // Invalid length

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithLengthExceedingCharsLength() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index
        int offset = 0; // Valid offset
        int length = 7; // Invalid length (exceeds chars length)

        try {
            strBuilder.insert(index, charsToInsert, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: 7", e.getMessage());
        }
    }

}