package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_URLCodec_encode_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEncodeString() {
        URLCodec codec = new URLCodec();
        String input = "Hello World!";
        String expectedOutput = "Hello%20World!"; // Expected URL encoded output

        try {
            Object result = codec.encode(input);
            assertEquals(expectedOutput, result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}