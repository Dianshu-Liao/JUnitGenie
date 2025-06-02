package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class text_StrBuilder_getChars_int_int_char_____int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetChars_ThrowsException_WhenStartIndexIsGreaterThanEndIndex() {
        StrBuilder strBuilder = new StrBuilder("example");
        char[] destination = new char[10];
        int startIndex = 5;
        int endIndex = 3;
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("end < start", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetChars_ThrowsException_WhenStartIndexIsNegative() {
        StrBuilder strBuilder = new StrBuilder("example");
        char[] destination = new char[10];
        int startIndex = -1;
        int endIndex = 3;
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("-1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetChars_ThrowsException_WhenEndIndexIsNegative() {
        StrBuilder strBuilder = new StrBuilder("example");
        char[] destination = new char[10];
        int startIndex = 0;
        int endIndex = -1;
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("-1", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetChars_ThrowsException_WhenEndIndexIsGreaterThanLength() {
        StrBuilder strBuilder = new StrBuilder("example");
        char[] destination = new char[10];
        int startIndex = 0;
        int endIndex = 10; // greater than length
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            assertEquals("10", e.getMessage());
        }
    }

}