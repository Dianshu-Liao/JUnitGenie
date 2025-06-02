package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_QuotedPrintableCodec_encode_String_Charset_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEncode_NullSourceStr() {
        QuotedPrintableCodec codec = new QuotedPrintableCodec();
        String result = codec.encode(null, java.nio.charset.StandardCharsets.UTF_8);
        assertNull(result);
    }

}