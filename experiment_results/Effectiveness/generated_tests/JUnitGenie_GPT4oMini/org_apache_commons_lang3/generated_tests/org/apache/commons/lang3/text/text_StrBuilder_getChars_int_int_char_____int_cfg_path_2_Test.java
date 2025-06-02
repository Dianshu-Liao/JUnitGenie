package org.apache.commons.lang3.text;
import org.apache.commons.lang3.text.StrBuilder;
import org.junit.Test;
import static org.junit.Assert.fail;

public class text_StrBuilder_getChars_int_int_char_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetChars_EndIndexNegative_ThrowsStringIndexOutOfBoundsException() {
        StrBuilder strBuilder = new StrBuilder("Sample String");
        char[] destination = new char[10];
        int startIndex = 0;
        int endIndex = -1; // Invalid end index
        int destinationIndex = 0;

        try {
            strBuilder.getChars(startIndex, endIndex, destination, destinationIndex);
            fail("Expected StringIndexOutOfBoundsException to be thrown");
        } catch (StringIndexOutOfBoundsException e) {
            // Exception thrown as expected
        }
    }

}