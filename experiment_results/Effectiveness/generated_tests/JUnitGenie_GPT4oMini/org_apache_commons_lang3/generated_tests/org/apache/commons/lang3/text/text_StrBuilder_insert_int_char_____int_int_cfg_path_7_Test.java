package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____int_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testInsertWithInvalidOffset() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        
        int index = 0;
        char[] chars = {'W', 'o', 'r', 'l', 'd'};
        int offset = 10; // Invalid offset
        int length = 5;

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException was not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid offset: 10", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithInvalidLength() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        
        int index = 0;
        char[] chars = {'W', 'o', 'r', 'l', 'd'};
        int offset = 0;
        int length = 10; // Invalid length

        try {
            strBuilder.insert(index, chars, offset, length);
            fail("Expected StringIndexOutOfBoundsException was not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Invalid length: 10", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        
        int index = 5; // Valid index
        char[] chars = {'W', 'o', 'r', 'l', 'd'};
        int offset = 0;
        int length = 5; // Valid length

        StrBuilder result = strBuilder.insert(index, chars, offset, length);
        assertEquals("HelloWorld", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        
        int index = 5;
        char[] chars = null; // Testing with null chars

        StrBuilder result = strBuilder.insert(index, chars, 0, 0);
        assertEquals("Hello", result.toString());
    }

}