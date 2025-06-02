package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_QCodec_decode_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecodeThrowsExceptionForUnsupportedType() {
        QCodec codec = new QCodec();
        Object unsupportedObject = new Integer(123); // Using an Integer which is unsupported

        try {
            codec.decode(unsupportedObject);
            fail("Expected DecoderException was not thrown.");
        } catch (DecoderException e) {
            assertEquals("Objects of type java.lang.Integer cannot be decoded using Q codec", e.getMessage());
        }
    }

}