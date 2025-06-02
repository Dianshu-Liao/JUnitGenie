package org.apache.commons.codec.language;

import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.language.SoundexUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_soundex_7_0_Test {

    private final Soundex soundex = new Soundex();

    @Test
    public void testSoundexWithNull() {
        assertNull(soundex.soundex(null));
    }

    @Test
    public void testSoundexWithEmptyString() {
        assertEquals("", soundex.soundex(""));
    }

    @Test
    public void testSoundexWithSingleLetter() {
        assertEquals("A000", soundex.soundex("A"));
    }

    @Test
    public void testSoundexWithMultipleLetters() {
        assertEquals("A530", soundex.soundex("Ashcraft"));
        assertEquals("B430", soundex.soundex("Bach"));
        assertEquals("C530", soundex.soundex("Catherine"));
    }

    @Test
    public void testSoundexWithHW() {
        assertEquals("S530", soundex.soundex("Smith"));
        assertEquals("S530", soundex.soundex("Smyth"));
    }

    @Test
    public void testSoundexWithVowels() {
        assertEquals("A320", soundex.soundex("Avery"));
        assertEquals("C320", soundex.soundex("Cae"));
    }

    @Test
    public void testSoundexWithRepeats() {
        assertEquals("A530", soundex.soundex("Ashcraft"));
        assertEquals("B430", soundex.soundex("Bach"));
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("S530", soundex.soundex("Smith!@#"));
        assertEquals("C320", soundex.soundex("Catherine123"));
    }

    @Test
    public void testSoundexWithOnlyHW() {
        assertEquals("H000", soundex.soundex("H"));
        assertEquals("W000", soundex.soundex("W"));
    }

    @Test
    public void testSoundexWithAllSilentCharacters() {
        assertEquals("A000", soundex.soundex("Hawhaw"));
    }

    private String invokeSoundexMethod(String input) throws Exception {
        Method method = Soundex.class.getDeclaredMethod("soundex", String.class);
        method.setAccessible(true);
        return (String) method.invoke(soundex, input);
    }

    @Test
    public void testInvokeSoundexMethod() throws Exception {
        String result = invokeSoundexMethod("Test");
        assertEquals("T230", result);
    }
}
