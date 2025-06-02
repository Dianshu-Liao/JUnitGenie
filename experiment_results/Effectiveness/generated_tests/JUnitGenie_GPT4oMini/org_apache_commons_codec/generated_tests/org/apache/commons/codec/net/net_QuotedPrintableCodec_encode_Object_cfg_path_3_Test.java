package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.apache.commons.codec.EncoderException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class net_QuotedPrintableCodec_encode_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEncodeString() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String input = "Hello World!";
        String expectedOutput = "Hello World!"; // Assuming the encode method returns the same string for this example

        try {
            Object result = codec.encode(input);
            assertEquals(expectedOutput, result);
        } catch (EncoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}