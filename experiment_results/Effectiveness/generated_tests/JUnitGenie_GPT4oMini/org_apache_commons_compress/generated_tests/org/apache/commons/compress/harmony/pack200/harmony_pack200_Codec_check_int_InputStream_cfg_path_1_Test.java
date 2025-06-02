package org.apache.commons.compress.harmony.pack200;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.io.input.BoundedInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class harmony_pack200_Codec_check_int_InputStream_cfg_path_1_Test extends Codec {
    
    @Override
    public byte[] encode(int a, int b) {
        return new byte[0];
    }

    @Override
    public byte[] encode(int a) {
        return new byte[0];
    }

    @Override
    public int decode(InputStream in, long length) {
        return 0;
    }

    @Override
    public int decode(InputStream in) {
        return 0;
    }

    @Test(timeout = 4000)
    public void testCheckThrowsPack200Exception() {
        int n = 5;
        InputStream in = new BoundedInputStream(new ByteArrayInputStream(new byte[0]), 0);
        
        try {
            check(n, in);
        } catch (Pack200Exception e) {
            String expectedMessage = "Can't read beyond end of stream (n = 5, count = 0, maxLength = 0, remaining = 0)";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}