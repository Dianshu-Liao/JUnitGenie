package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.junit.Test;
import java.nio.charset.Charset;
import static org.junit.Assert.assertNull;

public class net_QuotedPrintableCodec_decode_String_Charset_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDecode_NullSourceStr() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        try {
            String result = codec.decode(null, Charset.forName("UTF-8"));
            assertNull(result);
        } catch (DecoderException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}