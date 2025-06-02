package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_Soundex_8_0_Test {

    private Soundex soundex;

    @BeforeEach
    public void setUp() {
        soundex = new Soundex();
    }

    @Test
    public void testSoundex_EmptyString() {
        String result = soundex.soundex("");
        assertEquals("0000", result, "Soundex of empty string should be '0000'");
    }

    @Test
    public void testSoundex_SingleCharacter() {
        String result = soundex.soundex("A");
        assertEquals("A000", result, "Soundex of 'A' should be 'A000'");
    }

    @Test
    public void testSoundex_SimpleName() {
        String result = soundex.soundex("Robert");
        assertEquals("R163", result, "Soundex of 'Robert' should be 'R163'");
    }

    @Test
    public void testSoundex_SimilarNames() {
        String result1 = soundex.soundex("Rupert");
        String result2 = soundex.soundex("Robert");
        assertEquals(result1, result2, "Soundex of 'Rupert' and 'Robert' should be the same");
    }

    @Test
    public void testSoundex_NamesWithHW() {
        String result = soundex.soundex("Henry");
        assertEquals("H560", result, "Soundex of 'Henry' should be 'H560'");
    }

    @Test
    public void testSoundex_NamesWithSilentLetters() {
        String result = soundex.soundex("Smyth");
        assertEquals("S530", result, "Soundex of 'Smyth' should be 'S530'");
    }

    @Test
    public void testSoundex_NamesWithMultipleConsonants() {
        String result = soundex.soundex("Jackson");
        assertEquals("J250", result, "Soundex of 'Jackson' should be 'J250'");
    }

    @Test
    public void testSoundex_NamesWithDifferentLengths() {
        String result = soundex.soundex("Smith");
        assertEquals("S530", result, "Soundex of 'Smith' should be 'S530'");
    }
}
