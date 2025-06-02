package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Soundex_soundex_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCaseHW() {
        Soundex soundex = new Soundex();
        String input = "Harrison";
        String expected = "H652"; // Expected output based on Soundex algorithm
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex(null);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacter() {
        Soundex soundex = new Soundex();
        try {
            soundex.soundex("\u0000"); // Testing with a character less than 'A'
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}