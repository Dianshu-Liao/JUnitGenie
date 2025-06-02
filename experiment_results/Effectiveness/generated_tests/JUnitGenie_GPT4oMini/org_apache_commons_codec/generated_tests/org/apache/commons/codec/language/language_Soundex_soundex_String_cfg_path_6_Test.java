package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Robert");
        assertEquals("R163", result);
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
        String result = soundex.soundex("O'Brien");
        assertEquals("O165", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacter() {
        Soundex soundex = new Soundex();
        try {
            soundex.soundex("A" + (char) 64); // ASCII value 64 is less than 65
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }

}