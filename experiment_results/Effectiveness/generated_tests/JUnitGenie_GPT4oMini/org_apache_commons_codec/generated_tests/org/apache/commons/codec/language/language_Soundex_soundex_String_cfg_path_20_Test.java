package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_20_Test {

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
    public void testSoundexWithEmptyInput() {
        Soundex soundex = new Soundex();
        String input = "";
        String expected = ""; // Expected output for empty input
        String result = soundex.soundex(input);
        assertEquals(expected, result);
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
    public void testSoundexWithInvalidCharacter() {
        Soundex soundex = new Soundex();
        String input = "123"; // Input with numbers
        String expected = "1230"; // Expected Soundex code for "123"
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithCharacterBelowA() {
        Soundex soundex = new Soundex();
        String input = "\u0001"; // Character with ASCII value less than 65
        String expected = "0000"; // Expected Soundex code for invalid character
        String result = soundex.soundex(input);
        assertEquals(expected, result);
    }

}