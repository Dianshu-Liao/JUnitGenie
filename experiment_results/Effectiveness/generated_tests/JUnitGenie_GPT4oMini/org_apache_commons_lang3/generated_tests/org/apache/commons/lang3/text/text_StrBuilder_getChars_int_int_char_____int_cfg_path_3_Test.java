package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_getChars_int_int_char_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetChars_ThrowsStringIndexOutOfBoundsException_EndIndexLessThanZero() {
        StrBuilder strBuilder = new StrBuilder("test");
        char[] destination = new char[10];
        int startIndex = 0;
        int endIndex = -1; // Invalid endIndex
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            // Use the static method getMessage() to check for specific messages
            assertTrue(e.getMessage().contains("Index -1 out of bounds"));
        }
    }

    @Test(timeout = 4000)
    public void testGetChars_ThrowsStringIndexOutOfBoundsException_EndIndexGreaterThanLength() {
        StrBuilder strBuilder = new StrBuilder("test");
        char[] destination = new char[10];
        int startIndex = 0;
        int endIndex = 10; // Invalid endIndex
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            // Use the static method getMessage() to check for specific messages
            assertTrue(e.getMessage().contains("Index 10 out of bounds"));
        }
    }

    @Test(timeout = 4000)
    public void testGetChars_ThrowsStringIndexOutOfBoundsException_StartIndexGreaterThanEndIndex() {
        StrBuilder strBuilder = new StrBuilder("test");
        char[] destination = new char[10];
        int startIndex = 2;
        int endIndex = 1; // Invalid case where startIndex > endIndex
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            // Check the exception message for their context
            assertEquals("end < start", e.getMessage());
        }
    }

}