package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_11_0_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        soundex = new Soundex();
    }

    @Test
    public void testSoundexWithValidInput() {
        assertEquals("S530", soundex.encode("Smith"));
        assertEquals("S530", soundex.encode("Smythe"));
        assertEquals("C430", soundex.encode("Catherine"));
        assertEquals("B430", soundex.encode("Broughton"));
    }

    @Test
    public void testSoundexWithEmptyString() {
        assertEquals("", soundex.encode(""));
    }

    @Test
    public void testSoundexWithNullInput() {
        assertThrows(NullPointerException.class, () -> {
            soundex.encode(null);
        });
    }

    @Test
    public void testSoundexWithSpecialCharacters() {
        assertEquals("S530", soundex.encode("S!mith"));
        assertEquals("S530", soundex.encode("S-myth"));
        assertEquals("C430", soundex.encode("C@therine"));
    }

    @Test
    public void testSoundexWithDifferentMappings() {
        Soundex simplifiedSoundex = new Soundex(Soundex.US_ENGLISH_MAPPING_STRING, false);
        assertEquals("S530", simplifiedSoundex.encode("Smith"));
        assertEquals("C430", simplifiedSoundex.encode("Catherine"));
    }

    @Test
    public void testSoundexWithHWHandling() {
        Soundex specialSoundex = new Soundex(Soundex.US_ENGLISH_MAPPING_STRING, true);
        assertEquals("H050", specialSoundex.encode("Howard"));
        assertEquals("H063", specialSoundex.encode("Hawkins"));
    }

    @Test
    public void testSoundexWithMaxLength() {
        Soundex limitedSoundex = new Soundex(Soundex.US_ENGLISH_MAPPING_STRING, true);
        assertEquals("S53", limitedSoundex.encode("Smith").substring(0, 3));
    }
}
