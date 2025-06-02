package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.*;

public class language_Soundex_soundex_String_cfg_path_21_Test {

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
        assertNull(result);
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
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacter() {
        Soundex soundex = new Soundex();
        try {
            soundex.soundex("@Invalid");
            fail("Expected IllegalArgumentException for invalid character");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("@"));
        }
    }

}