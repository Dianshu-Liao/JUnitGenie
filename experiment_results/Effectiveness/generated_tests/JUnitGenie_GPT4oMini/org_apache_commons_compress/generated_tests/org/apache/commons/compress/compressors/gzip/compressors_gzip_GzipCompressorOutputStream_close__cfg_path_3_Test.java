package org.apache.commons.compress.compressors.gzip;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import static org.junit.Assert.assertTrue;

public class compressors_gzip_GzipCompressorOutputStream_close__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloseMethod() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GzipCompressorOutputStream gzipCompressorOutputStream = null;

        try {
            gzipCompressorOutputStream = new GzipCompressorOutputStream(byteArrayOutputStream);
            // Ensure the stream is open
            assertTrue(!gzipCompressorOutputStream.isClosed());

            // Call the close method which should invoke finish and end the deflater
            gzipCompressorOutputStream.close();
        } catch (IOException e) {
            // Handle the IOException that may be thrown by the close method
            e.printStackTrace();
        } finally {
            if (gzipCompressorOutputStream != null) {
                try {
                    gzipCompressorOutputStream.close(); // Ensure resources are cleaned up
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}