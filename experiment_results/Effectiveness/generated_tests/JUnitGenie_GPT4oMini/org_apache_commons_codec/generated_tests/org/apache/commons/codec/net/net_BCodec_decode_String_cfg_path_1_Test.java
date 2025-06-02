package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.BCodec;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_BCodec_decode_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeThrowsDecoderException() {
        BCodec codec = new BCodec();
        String invalidValue = "invalid_value"; // This should trigger an exception in decodeText

        try {
            codec.decode(invalidValue);
            fail("Expected DecoderException to be thrown");
        } catch (DecoderException e) {
            assertNotNull(e.getMessage());
        } catch (IllegalArgumentException e) {
            fail("Unexpected exception type: " + e.getClass().getSimpleName());
        }
    }

}