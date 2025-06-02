package org.apache.commons.codec.net;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_URLCodec_encode_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEncodeWithNullObject() {
        URLCodec urlCodec = new URLCodec();
        try {
            // Explicitly cast null to String to resolve ambiguity
            String result = urlCodec.encode((String) null);
            assertNull("Expected null return for null input", result);
        } catch (EncoderException e) {
            // Handle the exception if thrown, though it shouldn't be for null input
            e.printStackTrace();
        }
    }


}