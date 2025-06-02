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

class DoubleMetaphone_handleCC_15_0_Test {

    private DoubleMetaphone doubleMetaphone;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
    }

    private int invokeHandleCC(String value, DoubleMetaphone.DoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, value, result, index);
    }

    @Test
    void testHandleCC_WithIAtIndexPlusTwo() throws Exception {
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0);
        String value = "BACCI";
        int index = 1;
        int newIndex = invokeHandleCC(value, result, index);
        assertEquals(4, newIndex);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleCC_WithEAtIndexPlusTwo() throws Exception {
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0);
        String value = "BECOME";
        int index = 1;
        int newIndex = invokeHandleCC(value, result, index);
        assertEquals(4, newIndex);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleCC_WithHAtIndexPlusTwo() throws Exception {
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0);
        String value = "BACH";
        int index = 1;
        int newIndex = invokeHandleCC(value, result, index);
        assertEquals(3, newIndex);
        assertEquals("K", result.toString());
    }

    @Test
    void testHandleCC_WithHUAtIndexPlusTwo() throws Exception {
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0);
        String value = "BACCHUS";
        int index = 1;
        int newIndex = invokeHandleCC(value, result, index);
        assertEquals(3, newIndex);
        assertEquals("K", result.toString());
    }

    @Test
    void testHandleCC_WithNoVowelAtIndexPlusTwo() throws Exception {
        DoubleMetaphone.DoubleMetaphoneResult result = doubleMetaphone.new DoubleMetaphoneResult(0);
        String value = "BATCH";
        int index = 1;
        int newIndex = invokeHandleCC(value, result, index);
        assertEquals(3, newIndex);
        assertEquals("K", result.toString());
    }
}
