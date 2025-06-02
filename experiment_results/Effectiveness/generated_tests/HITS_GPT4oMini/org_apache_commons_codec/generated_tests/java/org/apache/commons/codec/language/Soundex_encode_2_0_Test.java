package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex_encode_2_0_Test {

    private final Soundex soundex = Soundex.US_ENGLISH;

    @Test
    public void testEncodeNull() {
        assertNull(soundex.encode(null), "Encoding null should return null");
    }

    @Test
    public void testEncodeEmptyString() {
        assertEquals("", soundex.encode(""), "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncodeSingleCharacter() {
        assertEquals("A000", soundex.encode("A"), "Encoding 'A' should return 'A000'");
        assertEquals("B000", soundex.encode("B"), "Encoding 'B' should return 'B000'");
    }

    @Test
    public void testEncodeWithVowels() {
        assertEquals("A000", soundex.encode("Aardvark"), "Encoding 'Aardvark' should return 'A000'");
        assertEquals("B000", soundex.encode("Boeing"), "Encoding 'Boeing' should return 'B000'");
    }

    @Test
    public void testEncodeWithRepeatedCharacters() {
        assertEquals("A000", soundex.encode("Aaa"), "Encoding 'Aaa' should return 'A000'");
        assertEquals("B000", soundex.encode("Bbb"), "Encoding 'Bbb' should return 'B000'");
    }

    @Test
    public void testEncodeWithHW() {
        assertEquals("A000", soundex.encode("Hawkins"), "Encoding 'Hawkins' should return 'A000'");
        assertEquals("B000", soundex.encode("Wright"), "Encoding 'Wright' should return 'B000'");
    }

    @Test
    public void testEncodeComplexName() {
        assertEquals("S532", soundex.encode("Smith"), "Encoding 'Smith' should return 'S532'");
        assertEquals("S530", soundex.encode("Smythe"), "Encoding 'Smythe' should return 'S530'");
        assertEquals("C530", soundex.encode("Catherine"), "Encoding 'Catherine' should return 'C530'");
    }

    @Test
    public void testEncodeDifferentNames() {
        assertEquals("B430", soundex.encode("Benson"), "Encoding 'Benson' should return 'B430'");
        assertEquals("J250", soundex.encode("Jackson"), "Encoding 'Jackson' should return 'J250'");
        assertEquals("K245", soundex.encode("Katherine"), "Encoding 'Katherine' should return 'K245'");
    }
}
