package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class binary_BinaryCodec_encode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode_withValidByteArray() throws EncoderException {
        BinaryCodec codec = new BinaryCodec();
        byte[] input = new byte[]{65, 66, 67}; // ASCII for 'A', 'B', 'C'
        byte[] expectedOutput = new byte[]{65, 66, 67}; // Expected output as byte array

        byte[] result = codec.encode(input);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testEncode_withInvalidInput() {
        BinaryCodec codec = new BinaryCodec();
        Object invalidInput = "Not a byte array";

        try {
            codec.encode(invalidInput);
        } catch (EncoderException e) {
            // Expected exception
            assertEquals("argument not a byte array", e.getMessage());
        }
    }

}