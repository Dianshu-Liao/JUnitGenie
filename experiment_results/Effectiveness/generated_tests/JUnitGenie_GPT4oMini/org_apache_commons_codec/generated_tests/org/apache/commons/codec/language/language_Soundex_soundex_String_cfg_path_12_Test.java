package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_12_Test {

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
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithAllVowels() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("AEIOU");
        assertEquals("A000", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSingleCharacter() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("A");
        assertEquals("A000", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithMultipleSameCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("AAA");
        assertEquals("A000", result);
    }

}