package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DoubleMetaphone_handleCC_15_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        // Ensure DoubleMetaphoneResult is properly instantiated
        result = new DoubleMetaphoneResult();
    }

    @Test
    void testHandleCC_WithI_H() throws Exception {
        int index = invokeHandleCC("BAH", result, 1);
        assertEquals(3, index);
        assertEquals("KS", result.toString());
    }

    @Test
    void testHandleCC_WithE_H() throws Exception {
        int index = invokeHandleCC("BAE", result, 1);
        assertEquals(3, index);
        assertEquals("KS", result.toString());
    }

    @Test
    void testHandleCC_WithNotHU() throws Exception {
        int index = invokeHandleCC("BACCI", result, 0);
        assertEquals(3, index);
        assertEquals("X", result.toString());
    }

    @Test
    void testHandleCC_WithPiercesRule() throws Exception {
        int index = invokeHandleCC("BACH", result, 0);
        assertEquals(2, index);
        assertEquals("K", result.toString());
    }

    private int invokeHandleCC(String value, DoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, value, result, index);
    }
}

class DoubleMetaphoneResult {

    private StringBuilder result = new StringBuilder();

    public void append(String str) {
        result.append(str);
    }

    public void append(char ch) {
        result.append(ch);
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
