package org.apache.commons.compress.compressors.snappy;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class compressors_snappy_SnappyCompressorOutputStream_finish__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFinish() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SnappyCompressorOutputStream compressor = null;

        try {
            compressor = new SnappyCompressorOutputStream(outputStream, 1024);
            // Assuming the compressor is not finished initially
            compressor.finish(); // This should call the finish method without throwing an exception
        } catch (IOException e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        } finally {
            if (compressor != null) {
                try {
                    compressor.close(); // Ensure the compressor is closed
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}