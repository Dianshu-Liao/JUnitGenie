package org.apache.commons.codec.language;
import org.apache.commons.codec.language.RefinedSoundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_RefinedSoundex_soundex_String_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSoundexWithValidInput() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("Robert");
        assertEquals("R163", result); // Expected Soundex code for "Robert"
    }

    @Test(timeout = 4000)
    public void testSoundexWithNullInput() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex(null);
        assertEquals(null, result); // Expected result is null
    }

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("");
        assertEquals("", result); // Expected result is an empty string
    }

    @Test(timeout = 4000)
    public void testSoundexWithCleanedInput() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("A");
        assertEquals("A", result); // Expected Soundex code for "A"
    }

}