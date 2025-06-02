package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidIndexAndNonNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndexAndNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        int index = 5; // Valid index

        // Specify the method to avoid ambiguity
        StrBuilder result = strBuilder.insert(index, (char[]) null);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithValidIndexAndEmptyChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {};
        int index = 5; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithInvalidIndex() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = -1; // Invalid index

        try {
            strBuilder.insert(index, charsToInsert);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            // Expected exception
        }
    }


}