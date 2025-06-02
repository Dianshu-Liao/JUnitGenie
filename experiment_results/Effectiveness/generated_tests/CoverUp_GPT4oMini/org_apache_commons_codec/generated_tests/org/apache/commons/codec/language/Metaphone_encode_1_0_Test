package org.apache.commons.codec.language;

import org.apache.commons.codec.language.Metaphone;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone_encode_1_0_Test {

    private Metaphone metaphone;

    @BeforeEach
    public void setUp() {
        metaphone = new Metaphone();
    }

    @Test
    public void testEncodeNull() throws Exception {
        String result = invokeEncode(null);
        assertEquals("", result);
    }

    @Test
    public void testEncodeEmptyString() throws Exception {
        String result = invokeEncode("");
        assertEquals("", result);
    }

    @Test
    public void testEncodeSingleCharacter() throws Exception {
        String result = invokeEncode("A");
        assertEquals("A", result);
        result = invokeEncode("B");
        assertEquals("B", result);
    }

    @Test
    public void testEncodeWordWithVowels() throws Exception {
        String result = invokeEncode("APPLE");
        assertEquals("APL", result);
        result = invokeEncode("ORANGE");
        assertEquals("ARNK", result);
    }

    @Test
    public void testEncodeWordWithSilentLetters() throws Exception {
        String result = invokeEncode("KNIGHT");
        assertEquals("NKT", result);
        result = invokeEncode("HOUR");
        assertEquals("R", result);
    }

    @Test
    public void testEncodeWordWithMultipleConsonants() throws Exception {
        String result = invokeEncode("SCHOOL");
        assertEquals("SKL", result);
        result = invokeEncode("THOUGHT");
        assertEquals("0T", result);
    }

    @Test
    public void testEncodeWordWithEdgeCases() throws Exception {
        String result = invokeEncode("SIOUX");
        assertEquals("S", result);
        result = invokeEncode("PHOENIX");
        assertEquals("F", result);
    }

    private String invokeEncode(String input) throws Exception {
        Method encodeMethod = Metaphone.class.getDeclaredMethod("encode", String.class);
        encodeMethod.setAccessible(true);
        return (String) encodeMethod.invoke(metaphone, input);
    }
}
