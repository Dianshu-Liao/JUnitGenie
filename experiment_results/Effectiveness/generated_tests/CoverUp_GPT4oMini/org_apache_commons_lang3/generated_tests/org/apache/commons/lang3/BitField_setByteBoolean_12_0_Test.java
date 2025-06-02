package org.apache.commons.lang3;

import org.apache.commons.lang3.BitField;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class BitField_setByteBoolean_12_0_Test {

    private BitField bitField;

    @BeforeEach
    public void setUp() {
        // Example mask for testing
        bitField = new BitField(0b00000001);
    }

    @Test
    public void testSetByteBooleanTrue() throws Exception {
        // Initial holder
        byte holder = 0b00000000;
        boolean flag = true;
        byte result = invokeSetByteBoolean(holder, flag);
        // Expecting the result to be set (1)
        assertEquals(0b00000001, result);
    }

    @Test
    public void testSetByteBooleanFalse() throws Exception {
        // Initial holder with the bit set
        byte holder = 0b00000001;
        boolean flag = false;
        byte result = invokeSetByteBoolean(holder, flag);
        // Expecting the result to be cleared (0)
        assertEquals(0b00000000, result);
    }

    private byte invokeSetByteBoolean(byte holder, boolean flag) throws Exception {
        Method method = BitField.class.getDeclaredMethod("setByteBoolean", byte.class, boolean.class);
        method.setAccessible(true);
        return (byte) method.invoke(bitField, holder, flag);
    }
}
