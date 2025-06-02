package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_insert_int_char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertWithValidParameters() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 5; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hello World", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNullChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = null;
        int index = 5; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithEmptyChars() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {};
        int index = 5; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hello", result.toString());
    }

    @Test(timeout = 4000)
    public void testInsertWithNegativeIndex() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = -1; // Invalid index

        try {
            strBuilder.insert(index, charsToInsert);
            fail("Expected an exception to be thrown due to invalid index");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithIndexGreaterThanSize() {
        StrBuilder strBuilder = new StrBuilder();
        strBuilder.append("Hello");
        char[] charsToInsert = {' ', 'W', 'o', 'r', 'l', 'd'};
        int index = 10; // Invalid index (greater than size)

        try {
            strBuilder.insert(index, charsToInsert);
            fail("Expected an exception to be thrown due to invalid index");
        } catch (IndexOutOfBoundsException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testInsertWithEnsureCapacity() {
        StrBuilder strBuilder = new StrBuilder(5); // Initial capacity
        strBuilder.append("Hi");
        char[] charsToInsert = {' ', 'J', 'a', 'v', 'a'};
        int index = 2; // Valid index

        StrBuilder result = strBuilder.insert(index, charsToInsert);
        assertEquals("Hi Java", result.toString());
    }

}