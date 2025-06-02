package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
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

public class BinaryCodec_toByteArray_10_0_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test
    public void testToByteArray_NullInput() {
        byte[] result = binaryCodec.toByteArray(null);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testToByteArray_EmptyString() {
        byte[] result = binaryCodec.toByteArray("");
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testToByteArray_SingleCharacter() {
        byte[] result = binaryCodec.toByteArray("A");
        // ASCII value of 'A' is 65
        assertArrayEquals(new byte[] { 65 }, result);
    }

    @Test
    public void testToByteArray_MultipleCharacters() {
        byte[] result = binaryCodec.toByteArray("Hello");
        // ASCII values for 'H', 'e', 'l', 'l', 'o'
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result);
    }

    // Reflection test to call private method
    @Test
    public void testToByteArray_Reflection() throws Exception {
        Method method = BinaryCodec.class.getDeclaredMethod("fromAscii", char[].class);
        method.setAccessible(true);
        char[] input = new char[] { 'H', 'e', 'l', 'l', 'o' };
        byte[] result = (byte[]) method.invoke(binaryCodec, (Object) input);
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, result);
    }
}
