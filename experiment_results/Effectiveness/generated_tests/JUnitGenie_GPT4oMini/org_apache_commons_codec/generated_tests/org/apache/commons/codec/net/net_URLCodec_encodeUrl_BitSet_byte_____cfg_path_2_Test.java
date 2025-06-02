package org.apache.commons.codec.net;
import org.apache.commons.codec.net.URLCodec;
import java.util.BitSet;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class net_URLCodec_encodeUrl_BitSet_byte_____cfg_path_2_Test {
    
    @Test(timeout = 4000)
    public void testEncodeUrlWithValidParameters() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a');
        urlsafe.set('b');
        urlsafe.set('c');
        byte[] bytes = new byte[] { 'a', 'b', ' ', 'c' };

        try {
            byte[] result = URLCodec.encodeUrl(urlsafe, bytes);
            assertNotNull(result);
            assertArrayEquals(new byte[] { 'a', 'b', '+', 'c' }, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }
    
    @Test(timeout = 4000)
    public void testEncodeUrlWithNullBytes() {
        BitSet urlsafe = new BitSet();
        urlsafe.set('a');
        byte[] result;

        try {
            result = URLCodec.encodeUrl(urlsafe, null);
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testEncodeUrlWithNullUrlsafe() {
        byte[] bytes = new byte[] { 'a', 'b', ' ', 'c' };

        try {
            byte[] result = URLCodec.encodeUrl(null, bytes);
            assertNotNull(result);
            // The result should still encode correctly
            assertArrayEquals(new byte[] { 'a', 'b', '+', 'c' }, result);
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

}