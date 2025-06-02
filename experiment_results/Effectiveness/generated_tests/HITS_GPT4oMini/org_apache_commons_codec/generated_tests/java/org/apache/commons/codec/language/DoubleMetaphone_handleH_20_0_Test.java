package org.apache.commons.codec.language;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class DoubleMetaphone_handleH_20_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = doubleMetaphone.new DoubleMetaphoneResult(4);
    }

    private int invokeHandleH(String value, DoubleMetaphone.DoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleH", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, value, result, index);
    }

    @Test
    void testHandleHAtStartWithVowelAfter() throws Exception {
        int index = invokeHandleH("AH", result, 0);
        assertEquals('H', result.toString().charAt(0));
        assertEquals(2, index);
    }

    @Test
    void testHandleHAtStartWithConsonantAfter() throws Exception {
        int index = invokeHandleH("AHO", result, 0);
        assertEquals("", result.toString());
        assertEquals(1, index);
    }

    @Test
    void testHandleHBetweenVowels() throws Exception {
        int index = invokeHandleH("aHa", result, 1);
        assertEquals('H', result.toString().charAt(0));
        assertEquals(3, index);
    }

    @Test
    void testHandleHBetweenConsonants() throws Exception {
        int index = invokeHandleH("bHb", result, 1);
        assertEquals("", result.toString());
        assertEquals(2, index);
    }

    @Test
    void testHandleHWithVowelBeforeAndAfter() throws Exception {
        int index = invokeHandleH("aHe", result, 1);
        assertEquals('H', result.toString().charAt(0));
        assertEquals(3, index);
    }

    @Test
    void testHandleHWithVowelBeforeAndNonVowelAfter() throws Exception {
        int index = invokeHandleH("aHc", result, 1);
        assertEquals("", result.toString());
        assertEquals(2, index);
    }

    @Test
    void testHandleHWithNegativeIndex() throws Exception {
        int index = invokeHandleH("aH", result, -1);
        assertEquals("", result.toString());
        assertEquals(0, index);
    }
}
