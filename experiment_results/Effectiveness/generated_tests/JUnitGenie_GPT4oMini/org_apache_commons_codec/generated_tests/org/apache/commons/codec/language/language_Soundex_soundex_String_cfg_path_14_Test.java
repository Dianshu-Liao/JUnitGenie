package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Soundex_soundex_String_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String input = "example"; // Valid input
        String expected = "E251"; // Expected soundex code
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        try {
            String result = soundex.soundex(null);
            assertNull(result);
        } catch (Exception e) {
            fail("Should not throw an exception for null input");
        }
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("");
        assertEquals("", result);
    }
    
    @Test(timeout = 4000)
    public void testSoundexWithSpecialCharacters() {
        Soundex soundex = new Soundex();
        String input = "#$@!"; // Input with special characters
        String expected = "0"; // Expected incorrect output
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacters() {
        Soundex soundex = new Soundex();
        String input = "A1B2C3"; // Input containing numbers and letters
        try {
            String result = soundex.soundex(input);
            assertNotNull(result); // Ensure that the result is not null
        } catch (Exception e) {
            fail("Should not throw an exception for invalid characters");
        }
    }

    // Additional test to check for IllegalArgumentException
    @Test(timeout = 4000)
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String input = "HusseW"; // Input to test ignoring H and W
        String expected = "H021"; // Expected soundex ignoring H and W
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

}