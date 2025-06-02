package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String input = "Robert";
        String expected = "R163"; // Expected Soundex code for "Robert"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        String input = null;
        String result = soundex.soundex(input);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        Soundex soundex = new Soundex();
        String input = "";
        String expected = ""; // Expected output for empty string
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCaseHW() {
        Soundex soundex = new Soundex();
        String input = "Hannah";
        String expected = "H500"; // Expected Soundex code for "Hannah"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithAllVowels() {
        Soundex soundex = new Soundex();
        String input = "AEIOU";
        String expected = "A000"; // Expected Soundex code for "AEIOU"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithConsecutiveDuplicates() {
        Soundex soundex = new Soundex();
        String input = "Mississippi";
        String expected = "M242"; // Expected Soundex code for "Mississippi"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

}