package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_QuotedPrintableCodec_encode_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEncode_NullInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        try {
            // Explicitly cast null to String to resolve ambiguity
            Object result = codec.encode((String) null);
            assertNull(result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}