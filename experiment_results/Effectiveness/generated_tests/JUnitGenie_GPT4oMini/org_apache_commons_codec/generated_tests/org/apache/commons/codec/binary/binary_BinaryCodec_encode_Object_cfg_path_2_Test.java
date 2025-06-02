package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_BinaryCodec_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeThrowsExceptionForNonByteArray() {
        BinaryCodec codec = new BinaryCodec();
        Object nonByteArrayInput = "This is not a byte array";

        try {
            codec.encode(nonByteArrayInput);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("argument not a byte array", e.getMessage());
        }
    }

}