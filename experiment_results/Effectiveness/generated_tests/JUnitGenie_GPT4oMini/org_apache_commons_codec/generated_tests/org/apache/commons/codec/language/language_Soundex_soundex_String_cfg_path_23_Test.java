package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String input = "Robert";
        String expected = "R163"; // Expected Soundex code for "Robert"
        String result = null;
        try {
            result = soundex.soundex(input);
        } catch (Exception e) {
            // Handle exception if thrown
        }
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        String input = null;
        String result = null;
        try {
            result = soundex.soundex(input);
        } catch (Exception e) {
            // Handle exception if thrown
        }
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        Soundex soundex = new Soundex();
        String input = "";
        String expected = ""; // Expected output for empty string
        String result = null;
        try {
            result = soundex.soundex(input);
        } catch (Exception e) {
            // Handle exception if thrown
        }
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCaseHW() {
        Soundex soundex = new Soundex();
        String input = "Hannah";
        String expected = "H500"; // Expected Soundex code for "Hannah"
        String result = null;
        try {
            result = soundex.soundex(input);
        } catch (Exception e) {
            // Handle exception if thrown
        }
        assertEquals(expected, result);
    }

}