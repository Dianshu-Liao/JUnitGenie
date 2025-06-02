package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;

public class Conversion_longToHex_33_0_Test {

    @Test
    public void testLongToHex_WithZeroHexs() {
        String result = Conversion.longToHex(0x12345678L, 0, "initial", 0, 0);
        assertEquals("initial", result);
    }

    @Test
    public void testLongToHex_WithValidParameters() {
        String result = Conversion.longToHex(0x12345678L, 0, "0000", 0, 4);
        assertEquals("1234", result);
    }

    @Test
    public void testLongToHex_WithDstPosEqualToAppend() {
        String result = Conversion.longToHex(0x12345678L, 0, "00", 2, 2);
        assertEquals("0012", result);
    }

    @Test
    public void testLongToHex_WithDstPosGreaterThanAppend() {
        String result = Conversion.longToHex(0x12345678L, 0, "00", 3, 2);
        assertEquals("0001", result);
    }

    @Test
    public void testLongToHex_ThrowsIllegalArgumentException_WhenNHexsIsTooLarge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Conversion.longToHex(0x12345678L, 0, "0000", 0, 17);
        });
        assertEquals("(nHexs-1)*4+srcPos is greater or equal to than 64", exception.getMessage());
    }

    @Test
    public void testLongToHex_ThrowsIllegalArgumentException_WhenNibbleOutOfRange() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokePrivateMethod("intToHexDigit", -1);
        });
        assertEquals("nibble value not between 0 and 15: -1", exception.getMessage());
    }

    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = Conversion.class.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        return method.invoke(null, args);
    }
}
