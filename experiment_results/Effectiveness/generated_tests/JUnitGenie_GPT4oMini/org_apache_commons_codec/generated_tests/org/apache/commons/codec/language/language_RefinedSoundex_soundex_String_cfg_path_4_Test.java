package org.apache.commons.codec.language;
import org.apache.commons.codec.language.RefinedSoundex;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class language_RefinedSoundex_soundex_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSoundexWithEmptyString() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("");
        assertEquals("", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNull() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex(null);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithSingleCharacter() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("A");
        assertEquals("A", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithMultipleSameCharacters() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("AAA");
        assertEquals("A", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithDifferentCharacters() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("AAB");
        assertEquals("AB", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithUppercaseLetters() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("B");
        assertEquals("B", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithLowercaseLetters() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("b");
        assertEquals("B", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithMixedCase() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("AbC");
        assertEquals("ABC", result);
    }

    @Test(timeout = 4000)
    public void testSoundexWithNonLetterCharacters() {
        RefinedSoundex refinedSoundex = new RefinedSoundex();
        String result = refinedSoundex.soundex("A1B2C3");
        assertEquals("ABC", result);
    }

}