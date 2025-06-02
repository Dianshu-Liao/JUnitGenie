package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.regex.Pattern;
import org.apache.commons.codec.StringEncoder;

public class Nysiis_encode_2_0_Test {

    private final Nysiis nysiis = new Nysiis();

    @Test
    public void testEncode_ValidString() throws EncoderException {
        String input = "MAC";
        String expected = "MCC";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ValidStringWithKN() throws EncoderException {
        String input = "KNIGHT";
        String expected = "NNIGHT";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ValidStringWithPH() throws EncoderException {
        String input = "PHILIP";
        String expected = "FFILIP";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ValidStringWithSCH() throws EncoderException {
        String input = "SCHOOL";
        String expected = "SSCHOOL";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ValidStringWithEE() throws EncoderException {
        String input = "JOE";
        String expected = "JOY";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ValidStringWithDT() throws EncoderException {
        String input = "ANDREW";
        String expected = "ANDREW";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_EmptyString() throws EncoderException {
        String input = "";
        String expected = "";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_NullString() {
        assertThrows(EncoderException.class, () -> {
            nysiis.encode(null);
        });
    }

    @Test
    public void testEncode_NonStringObject() {
        assertThrows(EncoderException.class, () -> {
            nysiis.encode(123);
        });
    }

    @Test
    public void testEncode_OnlySpaces() throws EncoderException {
        String input = "   ";
        String expected = "   ";
        assertEquals(expected, nysiis.encode(input));
    }

    @Test
    public void testEncode_ComplexString() throws EncoderException {
        String input = "SANDRA";
        // Assuming the complex case returns itself
        String expected = "SANDRA";
        assertEquals(expected, nysiis.encode(input));
    }
}
