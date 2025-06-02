package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_PercentCodec_encode_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode_WithNonNullBytes_ShouldEncode() {
        PercentCodec codec = new PercentCodec();
        byte[] input = new byte[] { 'a', 'b', 'c' }; // Non-null byte array
        try {
            byte[] result = codec.encode(input);
            assertNotNull(result);
            assertNotEquals(input.length, result.length); // Assuming encoding changes the length
        } catch (EncoderException e) {
            fail("EncoderException should not be thrown for valid input");
        }
    }

    @Test(timeout = 4000)
    public void testEncode_WithEmptyBytes_ShouldReturnEmpty() {
        PercentCodec codec = new PercentCodec();
        byte[] input = new byte[0]; // Empty byte array
        try {
            byte[] result = codec.encode(input);
            assertArrayEquals(input, result); // Should return the same empty array
        } catch (EncoderException e) {
            fail("EncoderException should not be thrown for empty input");
        }
    }

    @Test(timeout = 4000)
    public void testEncode_WithNullBytes_ShouldReturnNull() {
        PercentCodec codec = new PercentCodec();
        byte[] input = null; // Null byte array
        try {
            byte[] result = codec.encode(input);
            assertNull(result); // Should return null
        } catch (EncoderException e) {
            fail("EncoderException should not be thrown for null input");
        }
    }

    @Test(timeout = 4000)
    public void testEncode_WithBytesContainingSpace_ShouldEncode() {
        PercentCodec codec = new PercentCodec();
        byte[] input = new byte[] { 'a', ' ', 'b' }; // Byte array containing space
        try {
            byte[] result = codec.encode(input);
            assertNotNull(result);
            assertNotEquals(input.length, result.length); // Assuming encoding changes the length
        } catch (EncoderException e) {
            fail("EncoderException should not be thrown for valid input with space");
        }
    }

}