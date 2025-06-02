package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = 6; // valid length

        StrBuilder result = strBuilder.insert(index, chars, offset, length);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        int index = 5; // valid index

        StrBuilder result = strBuilder.insert(index, null, 0, 0);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeOffset() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = -1; // invalid offset
        int length = 6; // valid length

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithOffsetGreaterThanCharsLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 7; // invalid offset
        int length = 6; // valid length

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: 7", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = -1; // invalid length

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithLengthExceedingChars() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = 7; // invalid length

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: 7", e.getMessage());
        }
    }

}