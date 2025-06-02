package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_BCodec_encode_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode() {
        BCodec bCodec = new BCodec();
        String strSource = "Hello, World!";
        String sourceCharset = "UTF-8";
        
        try {
            String result = bCodec.encode(strSource, sourceCharset);
            // Assuming encodeText method returns the same string for valid input
            assertEquals("Hello, World!", result);
        } catch (EncoderException e) {
            // Handle the EncoderException if it occurs
            e.printStackTrace();
        }
    }

}