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

public class DoubleMetaphone_handleT_27_1_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = doubleMetaphone.new DoubleMetaphoneResult(doubleMetaphone.getMaxCodeLen());
    }

    @Test
    public void testHandleT_WithTion() throws Exception {
        String input = "MOTION";
        int index = 2;
        int expectedIndex = 5;
        int newIndex = invokeHandleT(input, result, index);
        assertEquals("X", result.toString());
        assertEquals(expectedIndex, newIndex);
    }

    @Test
    public void testHandleT_WithTia() throws Exception {
        String input = "TIA";
        int index = 0;
        int expectedIndex = 3;
        int newIndex = invokeHandleT(input, result, index);
        assertEquals("X", result.toString());
        assertEquals(expectedIndex, newIndex);
    }

    @Test
    public void testHandleT_WithTch() throws Exception {
        String input = "MATCH";
        int index = 0;
        int expectedIndex = 3;
        int newIndex = invokeHandleT(input, result, index);
        assertEquals("X", result.toString());
        assertEquals(expectedIndex, newIndex);
    }

    @Test
    public void testHandleT_WithoutTionTiaTch() throws Exception {
        String input = "TEST";
        int index = 0;
        int expectedIndex = 1;
        int newIndex = invokeHandleT(input, result, index);
        assertEquals("T", result.toString());
        assertEquals(expectedIndex, newIndex);
    }

    private int invokeHandleT(String value, DoubleMetaphone.DoubleMetaphoneResult result, int index) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleT", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, value, result, index);
    }
}
