package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class DoubleMetaphone_handleCC_15_2_Test {

    private DoubleMetaphone doubleMetaphone;

    private TestDoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = new TestDoubleMetaphoneResult();
    }

    @Test
    public void testHandleCC_WithI_E_H() throws Exception {
        // Prepare the input
        String value = "bacchus";
        int index = 1;
        // Invoke the private method using reflection
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, TestDoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        // Assert the expected output
        assertEquals(4, newIndex);
        assertEquals("KS", result.toString());
    }

    @Test
    public void testHandleCC_WithNoI_E_H() throws Exception {
        // Prepare the input
        String value = "bertucci";
        int index = 1;
        // Invoke the private method using reflection
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, TestDoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        // Assert the expected output
        assertEquals(3, newIndex);
        assertEquals("X", result.toString());
    }

    @Test
    public void testHandleCC_WithPierceRule() throws Exception {
        // Prepare the input
        String value = "test";
        int index = 0;
        // Invoke the private method using reflection
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleCC", String.class, TestDoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        int newIndex = (int) method.invoke(doubleMetaphone, value, result, index);
        // Assert the expected output
        assertEquals(2, newIndex);
        assertEquals("K", result.toString());
    }

    private static class TestDoubleMetaphoneResult {

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
}
