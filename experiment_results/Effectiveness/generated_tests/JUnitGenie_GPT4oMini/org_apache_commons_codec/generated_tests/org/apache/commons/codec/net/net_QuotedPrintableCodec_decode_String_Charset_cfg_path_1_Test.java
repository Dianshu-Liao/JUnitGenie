package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import java.nio.charset.Charset;
import static org.junit.Assert.assertEquals;

public class net_QuotedPrintableCodec_decode_String_Charset_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDecode_ValidInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "Hello World!";
        Charset sourceCharset = Charset.forName("US-ASCII");
        
        try {
            String result = codec.decode(sourceStr, sourceCharset);
            assertEquals("Hello World!", result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_NullInput() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = null;
        Charset sourceCharset = Charset.forName("US-ASCII");
        
        try {
            String result = codec.decode(sourceStr, sourceCharset);
            assertEquals(null, result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDecode_EmptyString() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "";
        Charset sourceCharset = Charset.forName("US-ASCII");
        
        try {
            String result = codec.decode(sourceStr, sourceCharset);
            assertEquals("", result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}