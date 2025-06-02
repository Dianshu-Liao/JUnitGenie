package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class net_BCodec_doDecoding_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        BCodec bCodec = new BCodec();
        try {
            Method method = BCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(bCodec, (byte[]) null);
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}