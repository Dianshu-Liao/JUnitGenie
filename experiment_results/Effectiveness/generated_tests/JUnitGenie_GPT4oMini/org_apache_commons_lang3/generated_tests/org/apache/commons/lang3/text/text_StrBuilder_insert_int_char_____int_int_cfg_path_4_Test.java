package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = 6; // valid length
        
        try {
            strBuilder.insert(index, chars, offset, length);
            assertEquals("Hello World", strBuilder.toString());
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testInsertThrowsStringIndexOutOfBoundsExceptionForInvalidOffset() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = -1; // invalid offset
        int length = 6; // valid length
        
        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException was not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: -1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertThrowsStringIndexOutOfBoundsExceptionForInvalidLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = -1; // invalid length
        
        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException was not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: -1", e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testInsertThrowsStringIndexOutOfBoundsExceptionForExceedingLength() {
        StrBuilder strBuilder = new StrBuilder("Hello");
        char[] chars = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // valid index
        int offset = 0; // valid offset
        int length = 7; // invalid length (exceeds chars.length)
        
        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException was not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: 7", e.getMessage());
        }
    }

}