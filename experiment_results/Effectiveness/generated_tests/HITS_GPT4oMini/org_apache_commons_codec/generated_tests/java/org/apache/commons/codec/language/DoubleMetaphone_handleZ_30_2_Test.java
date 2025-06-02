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

class DoubleMetaphone_handleZ_30_2_Test {

    private DoubleMetaphone doubleMetaphone;

    private DoubleMetaphone.DoubleMetaphoneResult result;

    @BeforeEach
    public void setUp() {
        doubleMetaphone = new DoubleMetaphone();
        result = mock(DoubleMetaphone.DoubleMetaphoneResult.class);
    }

    private int invokeHandleZ(String value, DoubleMetaphone.DoubleMetaphoneResult result, int index, boolean slavoGermanic) throws Exception {
        Method method = DoubleMetaphone.class.getDeclaredMethod("handleZ", String.class, DoubleMetaphone.DoubleMetaphoneResult.class, int.class, boolean.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleMetaphone, value, result, index, slavoGermanic);
    }

    @Test
    public void testHandleZ_WithNextCharH_ShouldAppendJAndIncrementIndexBy2() throws Exception {
        String value = "Zhao";
        int index = 0;
        boolean slavoGermanic = false;
        // Act
        int newIndex = invokeHandleZ(value, result, index, slavoGermanic);
        // Assert
        verify(result).append('J');
        assertEquals(2, newIndex);
    }

    @Test
    public void testHandleZ_WithNextCharNotH_ShouldAppendSAndIncrementIndexBy1() throws Exception {
        String value = "Zebra";
        int index = 0;
        boolean slavoGermanic = false;
        // Act
        int newIndex = invokeHandleZ(value, result, index, slavoGermanic);
        // Assert
        verify(result).append('S');
        assertEquals(1, newIndex);
    }
}
