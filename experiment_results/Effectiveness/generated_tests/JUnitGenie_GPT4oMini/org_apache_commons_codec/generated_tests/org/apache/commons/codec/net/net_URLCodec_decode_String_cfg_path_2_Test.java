package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_URLCodec_decode_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecode_ValidString() {
        URLCodec codec = new URLCodec();
        String input = "Hello%20World";
        String expectedOutput = "Hello World";
        
        try {
            String result = codec.decode(input);
            assertEquals(expectedOutput, result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_NullString() {
        URLCodec codec = new URLCodec();
        String input = null;
        
        try {
            String result = codec.decode(input);
            assertEquals(null, result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}