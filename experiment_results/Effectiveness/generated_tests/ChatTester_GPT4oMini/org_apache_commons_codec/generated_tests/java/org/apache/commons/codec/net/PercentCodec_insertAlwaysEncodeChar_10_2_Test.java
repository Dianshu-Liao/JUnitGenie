package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.util.BitSet;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class PercentCodec_insertAlwaysEncodeChar_10_2_Test {

    private PercentCodec percentCodec;

    @BeforeEach
    public void setUp() {
        percentCodec = new PercentCodec();
    }

    @Test
    public void testInsertAlwaysEncodeChar_ValidByte() throws Exception {
        // Invoke the private method with a valid byte
        invokeInsertAlwaysEncodeChar((byte) 5);
        // Use reflection to access private fields
        assertTrue(getAlwaysEncodeChars().get(5));
        assertEquals(5, getAlwaysEncodeCharsMin());
        assertEquals(5, getAlwaysEncodeCharsMax());
    }

    @Test
    public void testInsertAlwaysEncodeChar_ValidByte_UpdateMinMax() throws Exception {
        // Invoke with a lower byte
        invokeInsertAlwaysEncodeChar((byte) 3);
        assertEquals(3, getAlwaysEncodeCharsMin());
        assertEquals(3, getAlwaysEncodeCharsMax());
        // Invoke with a higher byte
        invokeInsertAlwaysEncodeChar((byte) 7);
        assertEquals(3, getAlwaysEncodeCharsMin());
        assertEquals(7, getAlwaysEncodeCharsMax());
    }

    @Test
    public void testInsertAlwaysEncodeChar_NegativeByte() {
        // Expect IllegalArgumentException when passing a negative byte
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeInsertAlwaysEncodeChar((byte) -1);
        });
        assertEquals("byte must be >= 0", thrown.getMessage());
    }

    private void invokeInsertAlwaysEncodeChar(byte b) throws Exception {
        Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
        method.setAccessible(true);
        method.invoke(percentCodec, b);
    }

    private BitSet getAlwaysEncodeChars() throws Exception {
        java.lang.reflect.Field field = PercentCodec.class.getDeclaredField("alwaysEncodeChars");
        field.setAccessible(true);
        return (BitSet) field.get(percentCodec);
    }

    private int getAlwaysEncodeCharsMin() throws Exception {
        java.lang.reflect.Field field = PercentCodec.class.getDeclaredField("alwaysEncodeCharsMin");
        field.setAccessible(true);
        return (int) field.get(percentCodec);
    }

    private int getAlwaysEncodeCharsMax() throws Exception {
        java.lang.reflect.Field field = PercentCodec.class.getDeclaredField("alwaysEncodeCharsMax");
        field.setAccessible(true);
        return (int) field.get(percentCodec);
    }
}
