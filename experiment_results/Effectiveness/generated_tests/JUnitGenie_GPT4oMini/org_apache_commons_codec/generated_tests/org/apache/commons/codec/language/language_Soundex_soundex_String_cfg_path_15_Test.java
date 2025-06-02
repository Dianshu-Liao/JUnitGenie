package org.apache.commons.codec.language;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_Soundex_soundex_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Example");
        assertEquals("E251", result); // Assuming that "Example" returns "E251"
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex(null);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCaseHW() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("Harrison");
        assertEquals("H635", result); // Assuming that "Harrison" returns "H635"
    }

    @Test(timeout = 4000)
    public void testSoundexWithOnlyHAndWShouldIgnore() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("HW");
        assertEquals("H000", result); // Assuming that such output reflects ignoring H and W
    }

    @Test(timeout = 4000)
    public void testSoundexWithNonAlphabeticalCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("1234");
        assertEquals("0", result); // Assuming that non-alphabetical input returns "0"
    }

    @Test(timeout = 4000)
    public void testSoundexWithLowercaseInput() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("lowercase");
        assertEquals("L620", result); // Assuming that "lowercase" returns "L620"
    }

    @Test(timeout = 4000)
    public void testSoundexWithSpecialCharacters() {
        Soundex soundex = new Soundex();
        String result = soundex.soundex("!@#$%");
        assertEquals("0", result); // Assuming special characters return "0"
    }

}