package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testSoundex_WithEmptyString() {
        Soundex soundex = new Soundex();
        String result = null;
        try {
            result = soundex.soundex("");
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSoundex_WithNull() {
        Soundex soundex = new Soundex();
        String result = null;
        try {
            result = soundex.soundex(null);
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSoundex_WithValidInput() {
        Soundex soundex = new Soundex();
        String result = null;
        try {
            result = soundex.soundex("Ashcraft");
        } catch (Exception e) {
            // Handle exception if any
        }
        assertEquals("A261", result); // Assuming "Ashcraft" would return "A261"
    }

}