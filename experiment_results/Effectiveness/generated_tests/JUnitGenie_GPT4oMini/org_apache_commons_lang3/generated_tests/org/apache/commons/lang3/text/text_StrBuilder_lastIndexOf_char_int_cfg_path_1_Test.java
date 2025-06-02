package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class text_StrBuilder_lastIndexOf_char_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInputs() {
        StrBuilder strBuilder = new StrBuilder("abcabc");
        char ch = 'a';
        int startIndex = 5; // Start from the last character
        int expectedIndex = 3; // Last index of 'a' should be 3

        int result = strBuilder.lastIndexOf(ch, startIndex);
        assertEquals(expectedIndex, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NoMatch() {
        StrBuilder strBuilder = new StrBuilder("abcabc");
        char ch = 'd';
        int startIndex = 5; // Start from the last character
        int expectedIndex = -1; // No 'd' in the string

        int result = strBuilder.lastIndexOf(ch, startIndex);
        assertEquals(expectedIndex, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        StrBuilder strBuilder = new StrBuilder("abcabc");
        char ch = 'b';
        int startIndex = 10; // Start index is out of bounds
        int expectedIndex = 4; // Should return index of last 'b' which is 4

        int result = strBuilder.lastIndexOf(ch, startIndex);
        assertEquals(expectedIndex, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexNegative() {
        StrBuilder strBuilder = new StrBuilder("abcabc");
        char ch = 'c';
        int startIndex = -1; // Start index is negative
        int expectedIndex = -1; // Should return -1

        int result = strBuilder.lastIndexOf(ch, startIndex);
        assertEquals(expectedIndex, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyString() {
        StrBuilder strBuilder = new StrBuilder("");
        char ch = 'a';
        int startIndex = 0; // Start from the last character
        int expectedIndex = -1; // No match in an empty string

        int result = strBuilder.lastIndexOf(ch, startIndex);
        assertEquals(expectedIndex, result);
    }

}