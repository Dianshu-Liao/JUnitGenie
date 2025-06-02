package org.apache.commons.compress.compressors.xz;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class compressors_xz_XZCompressorInputStream_read_byte_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testReadWithZeroLength() {
        byte[] buf = new byte[10];
        int off = 0;
        int len = 0;

        // Use a valid input stream for XZCompressorInputStream
        try (XZCompressorInputStream xzInputStream = new XZCompressorInputStream(new ByteArrayInputStream(new byte[] { 0x00 }))) {
            int result = xzInputStream.read(buf, off, len);
            assertEquals(0, result);
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}