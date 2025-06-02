package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.CodecPolicy;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import java.nio.charset.Charset;

public class net_BCodec_isStrictDecoding__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsStrictDecoding() {
        // Create a BCodec instance with a valid Charset
        BCodec codec = new BCodec(Charset.forName("UTF-8")); // Use a valid Charset
        
        try {
            // Call the isStrictDecoding method
            boolean result = codec.isStrictDecoding();
            
            // Verify that the result is false
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}