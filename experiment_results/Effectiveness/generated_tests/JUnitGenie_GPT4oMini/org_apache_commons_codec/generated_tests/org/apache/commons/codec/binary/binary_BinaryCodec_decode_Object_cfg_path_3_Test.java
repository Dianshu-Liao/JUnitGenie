package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.BinaryCodec;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class binary_BinaryCodec_decode_Object_cfg_path_3_Test {

    private final BinaryCodec binaryCodec = new BinaryCodec();

    @Test(timeout = 4000)
    public void testDecodeWithInvalidInput() {
        try {
            // This should throw a DecoderException
            binaryCodec.decode(new Object());
        } catch (DecoderException e) {
            // Verify that the exception message is as expected
            assertEquals("argument not a byte array", e.getMessage());
        }
    }


}