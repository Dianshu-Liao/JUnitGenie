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

class DoubleMetaphone_handleAEIOUY_13_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        // Provide an integer argument
        result = doubleMetaphone.new DoubleMetaphoneResult(0);
    }

    @Test
    void testHandleAEIOUY_indexZero() throws Exception {
        int index = invokeHandleAEIOUY(result, 0);
        assertEquals(1, index);
        assertEquals("A", result.toString());
    }

    @Test
    void testHandleAEIOUY_indexOne() throws Exception {
        int index = invokeHandleAEIOUY(result, 1);
        assertEquals(2, index);
        assertEquals("A", result.toString());
    }

    @Test
    void testHandleAEIOUY_indexTwo() throws Exception {
        int index = invokeHandleAEIOUY(result, 2);
        assertEquals(3, index);
        assertEquals("A", result.toString());
    }

    @Test
    void testHandleAEIOUY_indexNegative() throws Exception {
        int index = invokeHandleAEIOUY(result, -1);
        assertEquals(0, index);
        assertEquals("", result.toString());
    }

    private int invokeHandleAEIOUY(DoubleMetaphone.DoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleAEIOUY", DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
        // Make the private method accessible
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, result, index);
    }
}
