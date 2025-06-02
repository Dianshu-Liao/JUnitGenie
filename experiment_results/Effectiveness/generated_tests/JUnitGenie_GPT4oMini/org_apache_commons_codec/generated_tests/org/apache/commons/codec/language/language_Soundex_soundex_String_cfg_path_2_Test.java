package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_2_Test {

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
    public void testSoundexWithSingleCharacter() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("A");
        assertEquals("A000", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithMultipleCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Ashcraft");
        assertEquals("A261", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithHWCharacters() {
        Soundex soundex = new Soundex();
        // Removed the line that tries to access the private field
        String result = soundex.soundex("Hannah");
        assertEquals("H500", result);
    }


}