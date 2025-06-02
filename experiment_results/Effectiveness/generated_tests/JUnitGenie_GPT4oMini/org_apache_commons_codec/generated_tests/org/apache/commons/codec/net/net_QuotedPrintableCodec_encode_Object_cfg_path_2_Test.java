package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_QuotedPrintableCodec_encode_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncodeWithInvalidObject() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Object invalidObject = new Object(); // An object that is neither byte[] nor String

        try {
            codec.encode(invalidObject);
            fail("Expected EncoderException to be thrown");
        } catch (EncoderException e) {
            assertEquals("Objects of type java.lang.Object cannot be quoted-printable encoded", e.getMessage());
        }
    }

}