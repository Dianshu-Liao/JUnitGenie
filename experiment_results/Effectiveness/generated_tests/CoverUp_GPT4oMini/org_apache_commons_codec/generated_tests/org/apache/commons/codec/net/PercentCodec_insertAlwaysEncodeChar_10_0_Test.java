package org.apache.commons.codec.net;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteBuffer;
import java.util.BitSet;
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

    @Test
    public void testInsertAlwaysEncodeChar_ValidByte() throws Exception {
        // Using reflection to access the private method
        Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
        method.setAccessible(true);
        // Test with a valid byte value
        method.invoke(percentCodec, (byte) 10);
        // Check the internal state of alwaysEncodeCharsMin and alwaysEncodeCharsMax
        assertEquals(10, getPrivateFieldValue("alwaysEncodeCharsMin"));
        assertEquals(10, getPrivateFieldValue("alwaysEncodeCharsMax"));
    }

    @Test
    public void testInsertAlwaysEncodeChar_ByteLessThanZero() throws Exception {
        // Using reflection to access the private method
        Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
        method.setAccessible(true);
        // Test with an invalid byte value
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(percentCodec, (byte) -1);
        });
        assertEquals("byte must be >= 0", thrown.getMessage());
    }

    @Test
    public void testInsertAlwaysEncodeChar_UpdateMinAndMax() throws Exception {
        // Using reflection to access the private method
        Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
        method.setAccessible(true);
        // Insert a byte value
        method.invoke(percentCodec, (byte) 20);
        assertEquals(20, getPrivateFieldValue("alwaysEncodeCharsMin"));
        assertEquals(20, getPrivateFieldValue("alwaysEncodeCharsMax"));
        // Insert a smaller byte value
        method.invoke(percentCodec, (byte) 10);
        assertEquals(10, getPrivateFieldValue("alwaysEncodeCharsMin"));
        assertEquals(20, getPrivateFieldValue("alwaysEncodeCharsMax"));
        // Insert a larger byte value
        method.invoke(percentCodec, (byte) 30);
        assertEquals(10, getPrivateFieldValue("alwaysEncodeCharsMin"));
        assertEquals(30, getPrivateFieldValue("alwaysEncodeCharsMax"));
    }

    private Object getPrivateFieldValue(String fieldName) throws Exception {
        Field field = PercentCodec.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(percentCodec);
    }
}
