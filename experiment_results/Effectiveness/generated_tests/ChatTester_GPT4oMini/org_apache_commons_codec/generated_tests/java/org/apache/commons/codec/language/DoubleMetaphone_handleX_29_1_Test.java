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

class DoubleMetaphone_handleX_29_1_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new DoubleMetaphoneResult();
    }

    @Test
    void testHandleX_firstIndex() throws Exception {
        String value = "XAMPLE";
        int index = 0;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    @Test
    void testHandleX_notLastIndex() throws Exception {
        String value = "EXAMPLE";
        int index = 1;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(2, newIndex);
        assertEquals("KS", result.toString());
    }

    @Test
    void testHandleX_lastIndexWithIAU() throws Exception {
        String value = "BIAUX";
        int index = 3;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(4, newIndex);
        // No change in result
        assertEquals("", result.toString());
    }

    @Test
    void testHandleX_lastIndexWithAU() throws Exception {
        String value = "BAUX";
        int index = 3;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(4, newIndex);
        // No change in result
        assertEquals("", result.toString());
    }

    @Test
    void testHandleX_containsC() throws Exception {
        String value = "EXCITING";
        int index = 1;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(2, newIndex);
        assertEquals("KS", result.toString());
    }

    @Test
    void testHandleX_containsX() throws Exception {
        String value = "EXAMPLE";
        int index = 1;
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        assertEquals(2, newIndex);
        assertEquals("KS", result.toString());
    }

    // Inner class for DoubleMetaphoneResult
    static class DoubleMetaphoneResult {

        private StringBuilder result = new StringBuilder();

        public void append(char c) {
            result.append(c);
        }

        public void append(String s) {
            result.append(s);
        }

        @Override
        public String toString() {
            return result.toString();
        }
    }
}
