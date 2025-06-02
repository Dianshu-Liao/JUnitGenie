package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class PercentCodec_insertAlwaysEncodeChar_10_0_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    private void invokeInsertAlwaysEncodeChar(byte b) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
        method.setAccessible(true);
        method.invoke(percentCodec, b);
    }

    @Test
    public void testInsertAlwaysEncodeChar_ValidByte() throws Exception {
        // ASCII for 'A'
        byte validByte = 65;
        assertDoesNotThrow(() -> invokeInsertAlwaysEncodeChar(validByte));
    }

    @Test
    public void testInsertAlwaysEncodeChar_MinBoundary() throws Exception {
        byte minByte = 0;
        assertDoesNotThrow(() -> invokeInsertAlwaysEncodeChar(minByte));
    }

    @Test
    public void testInsertAlwaysEncodeChar_MaxBoundary() throws Exception {
        byte maxByte = Byte.MAX_VALUE;
        assertDoesNotThrow(() -> invokeInsertAlwaysEncodeChar(maxByte));
    }

    @Test
    public void testInsertAlwaysEncodeChar_NegativeByte() {
        byte negativeByte = -1;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeInsertAlwaysEncodeChar(negativeByte);
        });
        assertEquals("byte must be >= 0", thrown.getMessage());
    }

    @Test
    public void testInsertAlwaysEncodeChar_UpdateMinMax() throws Exception {
        invokeInsertAlwaysEncodeChar((byte) 10);
        invokeInsertAlwaysEncodeChar((byte) 20);
        invokeInsertAlwaysEncodeChar((byte) 5);
        // Using reflection to access the private BitSet for testing
        try {
            java.lang.reflect.Field field = PercentCodec.class.getDeclaredField("alwaysEncodeChars");
            field.setAccessible(true);
            BitSet alwaysEncodeChars = (BitSet) field.get(percentCodec);
            assertTrue(alwaysEncodeChars.get(5));
            assertTrue(alwaysEncodeChars.get(10));
            assertTrue(alwaysEncodeChars.get(20));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
