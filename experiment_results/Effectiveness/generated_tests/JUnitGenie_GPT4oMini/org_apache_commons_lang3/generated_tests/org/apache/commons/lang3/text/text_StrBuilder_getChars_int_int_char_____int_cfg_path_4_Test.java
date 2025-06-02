package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_getChars_int_int_char_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetCharsValidInput() {
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        char[] destination = new char[5];
        int startIndex = 0;
        int endIndex = 5;
        int destinationIndex = 0;

        strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
        assertArrayEquals(new char[] {'H', 'e', 'l', 'l', 'o'}, destination);
    }

    @Test(timeout = 4000)
    public void testGetCharsStartIndexNegative() {
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        char[] destination = new char[5];
        int startIndex = -1;
        int endIndex = 5;
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 13", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetCharsEndIndexNegative() {
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        char[] destination = new char[5];
        int startIndex = 0;
        int endIndex = -1;
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Index: -1, Length: 13", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetCharsEndIndexGreaterThanLength() {
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        char[] destination = new char[5];
        int startIndex = 0;
        int endIndex = 20; // Greater than length
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("Index: 20, Length: 13", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetCharsStartGreaterThanEnd() {
        StrBuilder strBuilder = new StrBuilder("Hello, World!");
        char[] destination = new char[5];
        int startIndex = 5;
        int endIndex = 3; // start > end
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("end < start", e.getMessage());
        }
    }


}