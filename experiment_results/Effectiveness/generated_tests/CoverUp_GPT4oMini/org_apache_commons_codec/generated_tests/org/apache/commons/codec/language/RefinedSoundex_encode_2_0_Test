package org.apache.commons.codec.language;

import org.apache.commons.codec.language.RefinedSoundex;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

class RefinedSoundex_encode_2_0_Test {

    private final RefinedSoundex refinedSoundex = new RefinedSoundex();

    @Test
    void testEncodeWithNull() {
        assertNull(refinedSoundex.encode(null));
    }

    @Test
    void testEncodeWithEmptyString() {
        assertEquals("", refinedSoundex.encode(""));
    }

    @Test
    void testEncodeWithSingleCharacter() {
        assertEquals("A", refinedSoundex.encode("A"));
        assertEquals("B", refinedSoundex.encode("B"));
    }

    @Test
    void testEncodeWithMultipleCharacters() {
        assertEquals("A", refinedSoundex.encode("Aaaa"));
        assertEquals("B", refinedSoundex.encode("Bbbb"));
        assertEquals("C", refinedSoundex.encode("Cccc"));
    }

    @Test
    void testEncodeWithComplexInput() {
        assertEquals("A", refinedSoundex.encode("Aston"));
        assertEquals("B", refinedSoundex.encode("Benson"));
        assertEquals("C", refinedSoundex.encode("Carter"));
    }

    @Test
    void testEncodeWithDifferentCases() {
        assertEquals("A", refinedSoundex.encode("aston"));
        assertEquals("B", refinedSoundex.encode("BENSON"));
        assertEquals("C", refinedSoundex.encode("CaRtEr"));
    }

    @Test
    void testEncodeWithSpecialCharacters() {
        assertEquals("A", refinedSoundex.encode("Aston!"));
        assertEquals("B", refinedSoundex.encode("Benson@"));
        assertEquals("C", refinedSoundex.encode("Carter#"));
    }

    @Test
    void testPrivateSoundexMethod() throws Exception {
        Method method = RefinedSoundex.class.getDeclaredMethod("soundex", String.class);
        method.setAccessible(true);
        assertNull(method.invoke(refinedSoundex, (Object) null));
        assertEquals("", method.invoke(refinedSoundex, ""));
        assertEquals("A", method.invoke(refinedSoundex, "Aston"));
        assertEquals("B", method.invoke(refinedSoundex, "Benson"));
    }
}
