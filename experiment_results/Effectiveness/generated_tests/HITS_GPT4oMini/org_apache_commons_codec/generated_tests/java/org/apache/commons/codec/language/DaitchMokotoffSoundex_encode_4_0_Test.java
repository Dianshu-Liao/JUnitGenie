package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.Resources;
import org.apache.commons.codec.StringEncoder;

public class DaitchMokotoffSoundex_encode_4_0_Test {

    @Test
    public void testEncode_NullInput() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertNull(soundex.encode(null), "Encoding null should return null");
    }

    @Test
    public void testEncode_EmptyString() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("", soundex.encode(""), "Encoding an empty string should return an empty string");
    }

    @Test
    public void testEncode_SingleCharacter() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("A000", soundex.encode("A"), "Encoding 'A' should return 'A000'");
        assertEquals("B000", soundex.encode("B"), "Encoding 'B' should return 'B000'");
    }

    @Test
    public void testEncode_SimpleNames() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("D000", soundex.encode("Doe"), "Encoding 'Doe' should return 'D000'");
        assertEquals("S000", soundex.encode("Smith"), "Encoding 'Smith' should return 'S000'");
    }

    @Test
    public void testEncode_ComplexNames() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("M000", soundex.encode("Miller"), "Encoding 'Miller' should return 'M000'");
        assertEquals("N000", soundex.encode("Nelson"), "Encoding 'Nelson' should return 'N000'");
    }

    @Test
    public void testEncode_NamesWithSpaces() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("S000", soundex.encode("Smith John"), "Encoding 'Smith John' should return 'S000'");
        assertEquals("D000", soundex.encode("Doe Jane"), "Encoding 'Doe Jane' should return 'D000'");
    }

    @Test
    public void testEncode_NamesWithSpecialCharacters() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals("C000", soundex.encode("C'est"), "Encoding 'C'est' should return 'C000'");
        assertEquals("O000", soundex.encode("O'Neil"), "Encoding 'O'Neil' should return 'O000'");
    }

    @Test
    public void testEncode_ConsistentResults() {
        DaitchMokotoffSoundex soundex = new DaitchMokotoffSoundex();
        assertEquals(soundex.encode("Robert"), soundex.encode("Robert"), "Encoding 'Robert' should be consistent");
        assertEquals(soundex.encode("Rupert"), soundex.encode("Rupert"), "Encoding 'Rupert' should be consistent");
    }
}
