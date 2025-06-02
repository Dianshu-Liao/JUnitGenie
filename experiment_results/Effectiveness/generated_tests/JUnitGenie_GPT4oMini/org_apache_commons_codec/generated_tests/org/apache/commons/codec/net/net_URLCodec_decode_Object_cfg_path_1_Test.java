package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class net_URLCodec_decode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeWithValidByteArray() {
        URLCodec codec = new URLCodec();
        byte[] input = { 104, 101, 108, 108, 111 }; // Represents "hello" in byte form
        byte[] expectedOutput = { 104, 101, 108, 108, 111 }; // Expected output should match input

        try {
            Object result = codec.decode(input);
            assertArrayEquals(expectedOutput, (byte[]) result);
        } catch (DecoderException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithNull() {
        URLCodec codec = new URLCodec();
        Object input = null;

        try {
            Object result = codec.decode(input);
            assertArrayEquals(new byte[0], (byte[]) result); // Expecting an empty byte array for null input
        } catch (DecoderException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithInvalidType() {
        URLCodec codec = new URLCodec();
        Object input = 123; // Invalid type

        try {
            codec.decode(input);
        } catch (DecoderException e) {
            // Expected exception
            assertEquals("Objects of type java.lang.Integer cannot be URL decoded", e.getMessage());
        }
    }


}