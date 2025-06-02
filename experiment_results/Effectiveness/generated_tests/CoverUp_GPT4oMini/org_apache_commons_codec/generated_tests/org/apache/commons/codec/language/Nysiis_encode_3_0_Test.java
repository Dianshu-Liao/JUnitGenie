package org.apache.commons.codec.language;

import org.apache.commons.codec.language.Nysiis;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

class Nysiis_encode_3_0_Test {

    @Test
    void testEncodeWithNull() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode(null);
        assertNull(result);
    }

    @Test
    void testEncodeWithEmptyString() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("");
        assertEquals("", result);
    }

    @Test
    void testEncodeWithMac() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("MAC");
        assertEquals("MCC", result);
    }

    @Test
    void testEncodeWithKn() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("KNIGHT");
        assertEquals("NNIGHT", result);
    }

    @Test
    void testEncodeWithPh() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("PHILIP");
        assertEquals("FFILIP", result);
    }

    @Test
    void testEncodeWithSch() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("SCHOOL");
        assertEquals("SSCHOOL", result);
    }

    @Test
    void testEncodeWithEe() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("JOHNSON");
        assertEquals("JOHNSON", result);
    }

    @Test
    void testEncodeWithEndingS() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("BASS");
        assertEquals("BA", result);
    }

    @Test
    void testEncodeWithAyEnding() throws Exception {
        Nysiis nysiis = new Nysiis();
        String result = nysiis.encode("BAY");
        assertEquals("B", result);
    }

    @Test
    void testEncodeWithStrictMode() throws Exception {
        Nysiis nysiis = new Nysiis(true);
        String result = nysiis.encode("JOHNSON");
        assertEquals("JOHN", result);
    }

    @Test
    void testEncodeWithNonStrictMode() throws Exception {
        Nysiis nysiis = new Nysiis(false);
        String result = nysiis.encode("JOHNSON");
        assertEquals("JOHNSON", result);
    }

    private String invokeNysiisMethod(Nysiis nysiis, String str) throws Exception {
        Method method = Nysiis.class.getDeclaredMethod("nysiis", String.class);
        method.setAccessible(true);
        return (String) method.invoke(nysiis, str);
    }
}
