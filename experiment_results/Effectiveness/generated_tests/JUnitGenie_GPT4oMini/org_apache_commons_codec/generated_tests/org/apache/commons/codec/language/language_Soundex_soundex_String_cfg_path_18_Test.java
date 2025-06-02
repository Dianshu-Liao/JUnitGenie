package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_18_Test {

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
        String result = soundex.soundex("R@bert");
        assertEquals("R163", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithLowercaseInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("robert");
        assertEquals("R163", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithControlCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("\u0001\u0002");
        assertEquals("0000", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithInvalidCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("12345");
        assertEquals("0000", result);
    }

}