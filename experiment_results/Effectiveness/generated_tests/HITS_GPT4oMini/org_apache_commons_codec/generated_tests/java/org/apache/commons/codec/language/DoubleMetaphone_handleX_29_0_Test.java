package org.apache.commons.codec.language;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

class DoubleMetaphone_handleX_29_0_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        // Providing the required integer argument
        result = doubleMetaphone.new DoubleMetaphoneResult(0);
    }

    @Test
    public void testHandleX_AtStart_AppendS() throws Exception {
        String input = "example";
        int index = 0;
        int newIndex = invokeHandleX(input, index);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    @Test
    public void testHandleX_NotAtStart_NoAppendS() throws Exception {
        String input = "example";
        int index = 1;
        int newIndex = invokeHandleX(input, index);
        assertEquals(2, newIndex);
        assertEquals("", result.toString());
    }

    @Test
    public void testHandleX_AtStart_IncrementIndex() throws Exception {
        String input = "anotherExample";
        int index = 0;
        int newIndex = invokeHandleX(input, index);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    @Test
    public void testHandleX_MultipleCalls_AtStart() throws Exception {
        String input = "start";
        int index = 0;
        invokeHandleX(input, index);
        int newIndex = invokeHandleX(input, index);
        assertEquals(1, newIndex);
        assertEquals("S", result.toString());
    }

    private int invokeHandleX(String input, int index) throws Exception {
        java.lang.reflect.Method method = DoubleMetaphone.class.getDeclaredMethod("handleX", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, input, result, index);
    }
}
