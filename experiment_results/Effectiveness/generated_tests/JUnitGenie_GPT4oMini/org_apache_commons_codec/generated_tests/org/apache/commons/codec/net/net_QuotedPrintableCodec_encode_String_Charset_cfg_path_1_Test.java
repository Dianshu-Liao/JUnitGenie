package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.apache.commons.codec.binary.StringUtils;
import org.junit.Test;
import java.nio.charset.Charset;
import static org.junit.Assert.assertEquals;

public class net_QuotedPrintableCodec_encode_String_Charset_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String sourceStr = "Hello, World!";
        Charset sourceCharset = Charset.forName("UTF-8");
        
        try {
            String result = codec.encode(sourceStr, sourceCharset);
            String expected = StringUtils.newStringUsAscii(codec.encode(sourceStr.getBytes(sourceCharset)));
            assertEquals(expected, result);
        } catch (Exception e) {
            // Handle the exception as necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeWithNullSourceStr() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        Charset sourceCharset = Charset.forName("UTF-8");
        
        try {
            String result = codec.encode(null, sourceCharset);
            assertEquals(null, result);
        } catch (Exception e) {
            // Handle the exception as necessary
            e.printStackTrace();
        }
    }

}