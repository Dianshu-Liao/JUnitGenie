package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_5_Test {

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
        String result = soundex.soundex(null);
        assertEquals(null, result);
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
        String input = "O'Brien";
        String expected = "O165"; // Expected Soundex code for "O'Brien"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String input = "Hannah";
        String expected = "H500"; // Expected Soundex code for "Hannah"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSingleCharacter() {
        Soundex soundex = new Soundex();
        String input = "A";
        String expected = "A000"; // Expected Soundex code for "A"
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

}