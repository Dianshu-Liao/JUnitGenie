package org.apache.commons.compress.compressors.lz4;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class compressors_lz4_FramedLZ4CompressorOutputStream_finish__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFinish() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FramedLZ4CompressorOutputStream compressorOutputStream = null;

        try {
            compressorOutputStream = new FramedLZ4CompressorOutputStream(outputStream);
            // Call finish() when isFinished() returns false
            compressorOutputStream.finish();
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        } finally {
            if (compressorOutputStream != null) {
                try {
                    compressorOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}