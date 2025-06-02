package org.apache.commons.compress.compressors.gzip;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class compressors_gzip_GzipCompressorOutputStream_close__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testClose_whenNotClosed() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GzipCompressorOutputStream gzipCompressorOutputStream = null;
        try {
            gzipCompressorOutputStream = new GzipCompressorOutputStream(byteArrayOutputStream);
            gzipCompressorOutputStream.close(); // Close should succeed without exceptions
            assertTrue("OutputStream should be closed", byteArrayOutputStream.size() > 0);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (gzipCompressorOutputStream != null) {
                try {
                    gzipCompressorOutputStream.close(); // Ensure the stream is closed in case of an exception
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}