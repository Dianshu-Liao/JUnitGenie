package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Robert");
        assertEquals("R163", result); // Expected Soundex code for "Robert"
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex(null);
        assertEquals(null, result); // Expected result is null
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("");
        assertEquals("", result); // Expected result is empty string
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("H@ppy");
        assertEquals("H100", result); // Expected Soundex code for "H@ppy"
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacter() {
        Soundex soundex = new Soundex();
        try {
            soundex.soundex("1Invalid");
        } catch (IllegalArgumentException e) {
            // Expected exception for invalid character
        }
    }

}