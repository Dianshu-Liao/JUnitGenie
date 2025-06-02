package org.apache.commons.codec.binary;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.BaseNCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class binary_BaseNCodec_decode_Object_cfg_path_1_Test {

    private class BaseNCodecImpl extends BaseNCodec {
        protected BaseNCodecImpl(int unencodedBlockSize, int encodedBlockSize, int lineLength, int lineSeparator) {
            super(unencodedBlockSize, encodedBlockSize, lineLength, lineSeparator);
        }

        @Override
        protected void encode(byte[] source, int off, int len, BaseNCodec.Context context) {
            // Implementation not needed for this test
        }

        @Override
        protected boolean isInAlphabet(byte value) {
            return false; // Implementation not needed for this test
        }

        @Override
        protected void decode(byte[] source, int off, int len, BaseNCodec.Context context) {
            // Implementation not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testDecodeWithInvalidParameter() {
        BaseNCodec codec = new BaseNCodecImpl(0, 0, 0, 0);
        try {
            codec.decode(new Object()); // Passing an invalid type
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertEquals("Parameter supplied to Base-N decode is not a byte[] or a String", e.getMessage());
        }
    }


}